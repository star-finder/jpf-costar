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
	
//	private static void updateAliasMapWithRename(Map<String,Set<String>> aliasMap, String oldName, String newName) {
//		// update keys
//		Map<String,Set<String>> tmp = new HashMap<String,Set<String>>();
//		Iterator<String> keysIt = aliasMap.keySet().iterator();
//			
//		while (keysIt.hasNext()) {
//			String key = keysIt.next();
//			if (key.equals(oldName)) {
//				Set<String> values = aliasMap.get(key);
//				tmp.put(newName, values);
//				keysIt.remove();
//			}
//		}
//		
//		aliasMap.putAll(tmp);
//		
//		// update values
//		for (String key : aliasMap.keySet()) {
//			Set<String> values = aliasMap.get(key);
//			if (values.contains(oldName)) {
//				values.remove(oldName);
//				values.add(newName);
//			}
//		}
//	}
	
//	private static void updateNameMapWithAssign(Map<String,String> nameMap, String oldLhsName,
//			String newLhsName, String rhsName) {
//		// update value from old name to new name
//		Map<String,String> tmp = new HashMap<String,String>();
//		Iterator<String> keysIt = nameMap.keySet().iterator();
//		
//		while (keysIt.hasNext()) {
//			String key = keysIt.next();
//			String value = nameMap.get(key);
//			
//			if (value.equals(oldLhsName)) {
//				tmp.put(key, newLhsName);
//				keysIt.remove();
//			}
//		}
//		
//		nameMap.putAll(tmp);
//		
//		// in case reference assignment, update field references
//		if (rhsName != null) {
//			tmp = new HashMap<String,String>();
//			keysIt = nameMap.keySet().iterator();
//			
//			while (keysIt.hasNext()) {
//				String key = keysIt.next();
//				
//				if (key.startsWith(rhsName + ".")) {
//					String suffix = key.substring(rhsName.length());
//					String value = nameMap.get(key);
//					
//					tmp.put(newLhsName + suffix, value);
//				}
//			}
//			
//			nameMap.putAll(tmp);
//		}
//	}
	
//	private static void updateAliasMapWithAssign(Map<String,Set<String>> aliasMap, String oldLhsName,
//			String newLhsName, String rhsName) {
//		Set<String> rhsAlias = aliasMap.get(rhsName);
//		
//		if (rhsAlias == null) {
//			Set<String> set = new HashSet<String>();
//			set.add(newLhsName); set.add(rhsName);
//			
//			aliasMap.put(newLhsName, set);
//			aliasMap.put(rhsName, set);
//		} else {
//			rhsAlias.add(newLhsName);
//			aliasMap.put(newLhsName, rhsAlias);
//		}
//	}
	
//	private static void removeOldNameMap(String name, Map<String,String> nameMap) {
//		Iterator<String> it = nameMap.keySet().iterator();
//		while (it.hasNext()) {
//			String key = it.next();
//			
//			if (name.equals(key)) {
//				it.remove();
//			}
//		}
//	}
	
	public static List<Formula> preprocess(Formula pre, Formula pc, Formula f) {
		// list of returned formulas after resolving 
		List<Formula> fs = new ArrayList<Formula>();
		// map the original variable name to new name in the process
		Map<String,String> nameMap = new HashMap<String,String>();
		// contains not null vars, help to quick check unsat
		Set<String> noNullSet = new HashSet<String>();
		
		// add initial not null vars from heap formula
		HeapFormula hf = f.getHeapFormula();
		
		for (HeapTerm ht : hf.getHeapTerms()) {
			if (ht instanceof PointToTerm) {
				PointToTerm pt = (PointToTerm) ht;
				noNullSet.add(pt.getRoot().getName());
			}
		}
		
		// begin resolve pure formula
		PureFormula pf = f.getPureFormula();
		
		// resolve pure term one by one
		for (PureTerm pt : pf.getPureTerms()) {			
			// all pure term should be ComparisonTerm
			ComparisonTerm ct = (ComparisonTerm) pt;
			Comparator cp = ct.getComparator();
			
			// collect list of variables in current term
			// note that because of term like i := i + 1
			// set of variables does not work
			List<Variable> vars = new ArrayList<Variable>();
			CollectVarsVisitor visitor = new CollectVarsVisitor(vars);
			visitor.visit(ct);
			
			// keep the last var and last field for assign
			String lastVarName = "", lastFieldName = "";
			
			// resolve variable one by one
			for (int indexVar = 0; indexVar < vars.size(); indexVar++) {
				Variable var = vars.get(indexVar);
				
				// split name in case variables here is a field access, e.g., x.next
				String varName = var.getName();
				String[] varNameSplit = varName.split("\\.");
								
				// if nameMap contains a name, that name is changed to a new name
				String rootName = varNameSplit[0];
				if (nameMap.containsKey(rootName)) rootName = nameMap.get(rootName);
				
				// for normal variable name, not field access
				if (varNameSplit.length == 1) var.setName(rootName);
				
				// get last var and last field
				if (indexVar == vars.size() - 1) {
					if (cp == Comparator.APV || cp == Comparator.ARV) {
						lastVarName = varNameSplit[0];
					}
					// for assign to "this" field or static field, e.g., this_x
					else if ((cp == Comparator.APF || cp == Comparator.ARF) &&
							varNameSplit.length == 1) {
						lastVarName = varNameSplit[0];
					}
				}
				
				for (int i = 1; i < varNameSplit.length; i++) {
					// should handle the case rootName points to null first
					if (Utilities.isNull(f, rootName)) return fs;
					
					// get last var and last field
					if (indexVar == vars.size() - 1) {
						if (cp == Comparator.APF || cp == Comparator.ARF &&
								i == varNameSplit.length - 1) {
							lastVarName = rootName;
							lastFieldName = varNameSplit[i];
						}
					}
					
					HeapTerm ht = Utilities.findHeapTermNoRoot(f, rootName);
					
					if (ht == null) {
						return fs;
					} else if (ht instanceof PointToTerm) {
						String newName = null;
						String oldName = rootName + "." + varNameSplit[i];
						
						String fieldName = varNameSplit[i];

						if (nameMap.containsKey(oldName)) {
							newName = nameMap.get(oldName);
						} else {
							newName = getName((PointToTerm) ht, rootName, fieldName);
							if (newName == null) return fs;
							
							updateNameMap(nameMap, oldName, newName);
						}
						
						// update alias here
//						updateAliasMapWithRename(f.getAliasMap(), oldName, newName);
						updateNameMapForAlias(nameMap, f.getAlias(rootName), fieldName, newName);
						
//						updateNoNullSet(noNullSet, oldName, newName);
						
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
												
						return fs;
					}
				}
			}
			
			// resolve with operator
			
			// in case the term is assignment
			// we need to update the name for the lhs
			if (cp == Comparator.APV || cp == Comparator.ARV) {
				// get old name
				Variable lhs = (Variable) ct.getExp1();
				String oldLhsName = lhs.toString();
				
				// get new name
				Variable tmp = new Variable(oldLhsName);
				String newLhsName = Utilities.freshVar(tmp).getName();
				
				// update
				lhs.setName(newLhsName);
								
				// update nameMap because the name of lhs is changed
				updateNameMap(nameMap, lastVarName, newLhsName);
				
				// in case we have assign ref var update alias because now lhs is alias with rhs
				if (cp == Comparator.ARV) {
					String rhsName = ((Variable) ct.getExp2()).getName();
					
					// if rhs.f is f1 then newLhs.f should be f1 too
					updateNameMapForFields(nameMap, newLhsName, rhsName);
					// update aliasMap
					updateAliasMap(f.getAliasMap(), newLhsName, rhsName);
					// if rhs is not null, so is newLhs
					updateNoNullSet(noNullSet, newLhsName, rhsName);
				}
			} else if (cp == Comparator.APF || cp == Comparator.ARF) {
				Variable lhs = (Variable) ct.getExp1();
				String oldLhsName = lhs.toString();
				
				Variable tmp = new Variable(oldLhsName);
				String newLhsName = Utilities.freshVar(tmp).getName();
				
//				if (oldLhsName.startsWith("this_")) {
//					String root = "this_";
//					String suffix = oldLhsName.substring(5);
//					if (suffix.contains("_")) suffix = suffix.substring(0, suffix.indexOf('_'));
//					
//					nameMap.put(root + suffix, newLhsName);
//				}
				
				lhs.setName(newLhsName);
				
				// update nameMap because the name of lhs is changed
				if (lastFieldName.isEmpty()) {
					// this is the case when we assign to a field of "this" object
					// no need to update alias because no alias with "this"
					updateNameMap(nameMap, lastVarName, newLhsName);
				} else {
					updateNameMap(nameMap, lastVarName + "." + lastFieldName, newLhsName);
					updateNameMapForAlias(nameMap, f.getAlias(lastVarName), lastFieldName, newLhsName);
				}
				
				String rhsName = null;
				if (cp == Comparator.ARF) {
					rhsName = ct.getExp2().toString();
					// update alias because now lhs is alias with rhs
					
					// if rhs.f is f1 then newLhs.f should be f1 too
					updateNameMapForFields(nameMap, newLhsName, rhsName);
					// update aliasMap
					updateAliasMap(f.getAliasMap(), newLhsName, rhsName);
					// if rhs is not null, so is newLhs
					updateNoNullSet(noNullSet, newLhsName, rhsName);
				}
				
//				updateNameMapWithAssign(nameMap, oldLhsName, newLhsName, rhsName);
			} else if (cp == Comparator.EQ) {
				String lhs = ct.getExp1().toString();
				String rhs = ct.getExp2().toString();
				
				f.getPureFormula().updateAlias(ct);
				
				Set<String> aliasLhs = f.getAlias(lhs);
				Set<String> aliasRhs = f.getAlias(rhs);
				
				Set<String> tmp = new HashSet<String>();
				
				if (aliasLhs != null) tmp.addAll(aliasLhs);
				if (aliasRhs != null) tmp.addAll(aliasRhs);
				
				if (tmp.contains("null")) {
					for (String alias : tmp) {
						if (noNullSet.contains(alias)) {
							return fs;
						}
					}
				} else {
					for (String alias : tmp) {
						if (noNullSet.contains(alias)) {
							noNullSet.addAll(tmp);
							break;
						}
					}
				}
				
//				if (aliasLhs != null && aliasRhs != null) {
//					if (aliasLhs.contains("null")) {
//						for (String alias : aliasRhs) {
//							if (noNullSet.contains(alias))
//								return fs;
//						}
//					} else if (aliasRhs.contains("null")) {
//						for (String alias : aliasLhs) {
//							if (noNullSet.contains(alias))
//								return fs;
//						}
//					}
//				}
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
	
	// nameMap contains information in form of original name -> new name
	private static void updateNameMap(Map<String, String> nameMap,
			String oldName, String newName) {
		nameMap.put(oldName, newName);
//		Map<String, String> newMap = new HashMap<String, String>();
//
//		Iterator<String> it = nameMap.keySet().iterator();
//
//		while (it.hasNext()) {
//			String key = it.next();
//			String value = nameMap.get(key);
//
//			// in case original name -> some name already
//			// we have to remove the old map and prepare the new map
//			if (value.equals(oldName)) {
//				newMap.put(key, newName);
//				it.remove();
//			}
//		}
//
//		// in case we do NOT have original name -> some name
//		if (newMap.isEmpty()) newMap.put(oldName, newName);
//
//		nameMap.putAll(newMap);
	}
	
	private static void updateNameMapForAlias(Map<String,String> nameMap,
			Set<String> alias, String fieldName, String newName) {
		if (alias == null) return;
		
		for (String name : alias) {
			String oldName = name + "." + fieldName;
			nameMap.put(oldName, newName);			
		}
	}
	
	private static void updateNameMapForFields(Map<String,String> nameMap,
			String newLhsName, String rhsName) {
		Map<String, String>	tmp = new HashMap<String, String>();
		Iterator<String> keysIt = nameMap.keySet().iterator();
			
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
	
	// aliasMap contains alias information
	private static void updateAliasMap(Map<String,Set<String>> aliasMap,
			String newLhsName, String rhsName) {
		// remove old lhs from its own alias
//		Set<String> oldLhsAlias = aliasMap.get(oldLhsName);
//		
//		if (oldLhsAlias != null) {
//			oldLhsAlias.remove(oldLhsName);
//			if (oldLhsAlias.size() <= 1) aliasMap.remove(oldLhsAlias);
//		}
		
		// get alias for rhs
		Set<String> rhsAlias = aliasMap.get(rhsName);
		
		// if null means rhs does not have any alias
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
	
	private static void updateNoNullSet(Set<String> noNullSet,
			String newLhsName, String rhsName) {
		if (noNullSet.contains(rhsName))
			noNullSet.add(newLhsName);
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

}
