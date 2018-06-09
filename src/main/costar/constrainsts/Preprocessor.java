package costar.constrainsts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import starlib.data.DataNode;
import starlib.data.DataNodeMap;
import starlib.formula.Formula;
import starlib.formula.HeapFormula;
import starlib.formula.PureFormula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.heap.HeapTerm;
import starlib.formula.heap.InductiveTerm;
import starlib.formula.heap.PointToTerm;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.PureTerm;

public class Preprocessor {
	
	public static List<Formula> preprocess(Formula pre, Formula pc) {
		Formula preCopy = pre.copy();
		Formula pcCopy = pc.copy();
		
		Formula f = preCopy;
		HeapFormula hf = pcCopy.getHeapFormula();
		for (HeapTerm ht : hf.getHeapTerms()) {
			PointToTerm pt = (PointToTerm) ht;
			f.addPointToTerm(pt.getVars(), pt.getType());
		}
		
		PureFormula pf = pcCopy.getPureFormula();
		for (PureTerm pt : pf.getPureTerms()) {
			ComparisonTerm ct = (ComparisonTerm) pt;
			f.addComparisonTerm(ct.getComparator(), ct.getExp1(), ct.getExp2());
		}
		
		f.getPureFormula().setAliasMap(new HashMap<String,Set<String>>());
		List<Formula> result = preprocess(pre, pc, f);
		
		return result;
	}
	
	private static String getName(PointToTerm pt, String root, String field) {
		DataNode dn = DataNodeMap.find(pt.getType());
		Variable[] fields = dn.getFields();

		int i = 0;
		for (i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			
			if (field.equals(fieldName)) {
				return pt.getVarsNoRoot()[i].getName();
			}
		}
		
		return null;
	}
	
	private static void updateNameMapWithRename(Set<String> alias, Map<String,String> nameMap,
			String rootName, String field, String newName) {
		if (alias == null) return;
		
		for (String name : alias) {
			String oldName = name + "." + field;
			nameMap.put(oldName, newName);			
		}
	}
	
	private static void updateAliasMapWithRename(Map<String,Set<String>> aliasMap, String oldName, String newName) {
		// update keys
		Map<String,Set<String>> tmp = new HashMap<String,Set<String>>();
		Iterator<String> keysIt = aliasMap.keySet().iterator();
			
		while (keysIt.hasNext()) {
			String key = keysIt.next();
			if (key.equals(oldName)) {
				Set<String> values = aliasMap.get(key);
				tmp.put(newName, values);
				keysIt.remove();
			}
		}
		
		aliasMap.putAll(tmp);
		
		// update values
		for (String key : aliasMap.keySet()) {
			Set<String> values = aliasMap.get(key);
			if (values.contains(oldName)) {
				values.remove(oldName);
				values.add(newName);
			}
		}
	}
	
	private static void updateNameMapWithAssign(Map<String,String> nameMap, String oldLhsName,
			String newLhsName, String rhsName) {
		// update value from old name to new name
		Map<String,String> tmp = new HashMap<String,String>();
		Iterator<String> keysIt = nameMap.keySet().iterator();
		
		while (keysIt.hasNext()) {
			String key = keysIt.next();
			String value = nameMap.get(key);
			
			if (value.equals(oldLhsName)) {
				tmp.put(key, newLhsName);
				keysIt.remove();
			}
		}
		
		nameMap.putAll(tmp);
		
		// in case reference assignment, update field references
		if (rhsName != null) {
			tmp = new HashMap<String,String>();
			keysIt = nameMap.keySet().iterator();
			
			while (keysIt.hasNext()) {
				String key = keysIt.next();
				
				if (key.startsWith(rhsName + ".")) {
					String suffix = key.substring(rhsName.length());
					String value = nameMap.get(key);
					
					tmp.put(newLhsName + suffix, value);
				}
			}
			
			nameMap.putAll(tmp);
		}
	}
	
	private static void updateAliasMapWithAssign(Map<String,Set<String>> aliasMap, String oldLhsName,
			String newLhsName, String rhsName) {
		Set<String> rhsAlias = aliasMap.get(rhsName);
		
		if (rhsAlias == null) {
			Set<String> set = new HashSet<String>();
			set.add(newLhsName); set.add(rhsName);
			
			aliasMap.put(newLhsName, set);
			aliasMap.put(rhsName, set);
		} else {
			rhsAlias.add(newLhsName);
			aliasMap.put(newLhsName, rhsAlias);
		}
	}
	
	private static void removeOldNameMap(String name, Map<String,String> nameMap) {
		Iterator<String> it = nameMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			
			if (name.equals(key)) {
				it.remove();
			}
		}
	}
	
	private static void updateNoNullSet(Set<String> noNullSet, String oldName, String newName) {
		Iterator<String> it = noNullSet.iterator();
		boolean removed = false;
		
		while (it.hasNext()) {
			String name = it.next();
			if (name.equals(oldName)) {
				it.remove();
				removed = true;
			}
		}
		
		if (removed) noNullSet.add(newName);
	}
	
	public static List<Formula> preprocess(Formula pre, Formula pc, Formula f) {
		List<Formula> fs = new ArrayList<Formula>();		
		Map<String,String> nameMap = new HashMap<String,String>();
		Set<String> noNullSet = new HashSet<String>();
		
		HeapFormula hf = f.getHeapFormula();
		
		for (HeapTerm ht : hf.getHeapTerms()) {
			if (ht instanceof PointToTerm) {
				PointToTerm pt = (PointToTerm) ht;
				noNullSet.add(pt.getRoot().getName());
			}
		}
		
		PureFormula pf = f.getPureFormula();
		
		for (PureTerm pt : pf.getPureTerms()) {
			ComparisonTerm ct = (ComparisonTerm) pt;
			Comparator cp = ct.getComparator();
			
			List<Variable> vars = new ArrayList<Variable>();
			CollectVarsVisitor visitor = new CollectVarsVisitor(vars);
			visitor.visit(ct);
			
			for (int indexVar = 0; indexVar < vars.size(); indexVar++) {
				Variable var = vars.get(indexVar);
				
				String varName = var.getName();
				String[] varNameSplit = varName.split("\\.");
								
				String rootName = varNameSplit[0];
				if (nameMap.containsKey(rootName)) rootName = nameMap.get(rootName);
				
				if (varNameSplit.length <= 1) var.setName(rootName);
				
				for (int i = 1; i < varNameSplit.length; i++) {
					// should handle the case rootName points to null first
					if (Utilities.isNull(f, rootName)) return fs;
					
					HeapTerm ht = Utilities.findHeapTermNoRoot(f, rootName);
					
					if (ht == null) {
						return fs;
					} else if (ht instanceof PointToTerm) {
						String newName = null;
						String oldName = rootName + "." + varNameSplit[i];
						
						String field = varNameSplit[i];

						if (nameMap.containsKey(oldName)) {
							newName = nameMap.get(oldName);
						} else {
							newName = getName((PointToTerm) ht, rootName, field);
							if (newName == null) return fs;
							
							removeOldNameMap(oldName, nameMap);
							nameMap.put(oldName, newName);
						}
						
						// update alias here
						updateAliasMapWithRename(f.getAliasMap(), oldName, newName);
						updateNameMapWithRename(f.getAlias(rootName), nameMap, rootName, field, newName);
						
						updateNoNullSet(noNullSet, oldName, newName);
						
						rootName = newName;
						
						for (int j = i + 1; j < varNameSplit.length; j++) {
							newName += "." + varNameSplit[j];
						}
						
						var.setName(newName);
					} else if (ht instanceof InductiveTerm) {
						InductiveTerm it = (InductiveTerm) ht;
						Formula preCopy = pre.copy();
						Formula pcCopy = pc.copy();
						
						for (HeapTerm preht : preCopy.getHeapFormula().getHeapTerms()) {
							if (preht.equals(it)) {
								InductiveTerm preit = (InductiveTerm) preht;
								Formula[] unfoldFs = preit.unfold();
								
								for (int j = 0; j < unfoldFs.length; j++) {
									Formula preCopy2 = preCopy.copy();
									preCopy2.unfold(preit, j);
									
									fs.addAll(preprocess(preCopy2, pcCopy));
								}
							}
						}
						
//						Formula[] unfoldFs = it.unfold();
//						
//						for (int j = 0; j < unfoldFs.length; j++) {
//							Formula copyF = f.copy();
//							copyF.unfold(it, j);
//							
//							copyF.getPureFormula().setAliasMap(new HashMap<String,Set<String>>());
//							fs.addAll(preprocess(preCopy, pcCopy));
//						}
						
						return fs;
					}
				}
			}
			
			if (cp == Comparator.APV) {
				Variable lhs = (Variable) ct.getExp1();
				String oldLhsName = lhs.toString();
				
				Variable tmp = new Variable(oldLhsName);
				String newLhsName = Utilities.freshVar(tmp).getName();
				
				lhs.setName(newLhsName);
								
				nameMap.put(oldLhsName, newLhsName);
			} else if (cp == Comparator.ARF || cp == Comparator.ARV) {
				Variable lhs = (Variable) ct.getExp1();
				String oldLhsName = lhs.toString();
				
				Variable tmp = new Variable(oldLhsName);
				String newLhsName = Utilities.freshVar(tmp).getName();
				
				if (oldLhsName.startsWith("this_")) {
					String root = "this_";
					String suffix = oldLhsName.substring(5);
					if (suffix.contains("_")) suffix = suffix.substring(0, suffix.indexOf('_'));
					
					nameMap.put(root + suffix, newLhsName);
				}
				
				lhs.setName(newLhsName);
				
				String rhsName = null;
				if (cp == Comparator.ARF) {
					rhsName = ct.getExp2().toString();
					updateAliasMapWithAssign(f.getAliasMap(), oldLhsName, newLhsName, rhsName);
				}
				
				updateNameMapWithAssign(nameMap, oldLhsName, newLhsName, rhsName);
			} else if (cp == Comparator.EQ) {
				String lhs = ct.getExp1().toString();
				String rhs = ct.getExp2().toString();
				
				f.getPureFormula().updateAlias(ct);
				
				Set<String> aliasLhs = f.getAlias(lhs);
				Set<String> aliasRhs = f.getAlias(rhs);
				
				if (aliasLhs != null && aliasRhs != null) {
					if (aliasLhs.contains("null")) {
						for (String alias : aliasRhs) {
							if (noNullSet.contains(alias))
								return fs;
						}
					} else if (aliasRhs.contains("null")) {
						for (String alias : aliasLhs) {
							if (noNullSet.contains(alias))
								return fs;
						}
					}
				}
			} else if (cp == Comparator.NE) {
				String lhs = ct.getExp1().toString();
				String rhs = ct.getExp2().toString();
				
				Set<String> alias = f.getAlias(lhs);
				if (alias != null && alias.contains(rhs))
					return fs;
				
				if (rhs.equals("null")) {
					noNullSet.add(lhs);
				}
			}
			
		}
		
		fs.add(f);
		return fs;
	}

}
