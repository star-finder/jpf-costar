package costar.constrainsts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import costar.valuation.ValuationGenerator;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.MethodInfo;
import starlib.GlobalVariables;
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
import starlib.jpf.PathFinderUtils;

public class Preprocessor {
	
	private static ClassInfo ci;
	
	private static MethodInfo mi;
	
	private static boolean first = true;
	
	public static void setClassAndMethodInfo(ClassInfo ci, MethodInfo mi, Config conf) {
		if(first) {
			Preprocessor.ci = ci;
			Preprocessor.mi = mi;
			first = false;
		}
	}
	
	public static void reset() {
		first = true;
	}
	
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
	
	public static List<Formula> preprocess(Formula pre, Formula pc, Formula f) {
		// list of returned formulas after resolving 
		List<Formula> fs = new ArrayList<Formula>();
		
		// map the original "this"/static field name to new name in the process
		Map<String, String> nameMap = new HashMap<String, String>();
		
		// map the ref var/field to address
		Map<String, Integer> addressMap = new HashMap<String, Integer>();
		
		// map address to node
		Map<Integer, Map<String, String>> nodeMap = new HashMap<Integer, Map<String, String>>();
		
		// contains not null vars, help to quick check unsat
		Set<String> noNullSet = new HashSet<String>();
		
		Utilities.resetAddress();
		
		// add initial not null vars from heap formula
		HeapFormula hf = f.getHeapFormula();
		
		for (HeapTerm ht : hf.getHeapTerms()) {
			if (ht instanceof PointToTerm) {
				PointToTerm pt = (PointToTerm) ht;
				String rootName = pt.getRoot().getName();
				
				noNullSet.add(rootName);
				
				int address = Utilities.freshAddress();
				addressMap.put(rootName, address);
				
				fillInFields(nodeMap, address, pt);
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
					if (Utilities.isNull(f, rootName)) {
						return fs;
					}
					
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
						
						// enumeration here
//						HashMap<String,String> knownTypeVars = PathFinderUtils.initTypeVarMap(ci,mi);
//						
//						f.updateType(knownTypeVars);
//						String type = knownTypeVars.get(rootName);
//						
//						if (type == null)
//							return fs;
//						else {
//							HeapFormula hff = f.getHeapFormula();
//							HeapTerm[] hts = hff.getHeapTerms();
//							
//							List<Variable> sameType = new ArrayList<Variable>();
//							
//							for (HeapTerm htt : hts) {
//								if (htt instanceof PointToTerm && ((PointToTerm) htt).getType().equals(type)) {
//									sameType.add(((PointToTerm) htt).getRoot());
//								}
//							}
//							
//							for (int j = 0; j <= sameType.size(); j++) {
//								if (j == sameType.size()) {
//									// new node here
//									Formula preCopy = pre.copy();
//									
//									preCopy.addPointToTerm(new Variable(rootName), type);
//									
//									preprocess(preCopy, pc);
//								} else {
//									// old node here
//									Formula preCopy = pre.copy();
//									
//									preCopy.addComparisonTerm(Comparator.EQ, new Variable(rootName), sameType.get(j));
//									
//									preprocess(preCopy, pc);
//								}
//							}
//						}
					} else if (ht instanceof PointToTerm) {
						String fieldName = varNameSplit[i];
						
						// get new name via address and node map
						Integer address = addressMap.get(rootName);
						if (address == null) {
							for (String alias : f.getAlias(rootName)) {
								address = addressMap.get(alias);
								if (address != null) {
									addressMap.put(rootName, address);
									break;
								}
							}
						}
						
						Map<String, String> node = nodeMap.get(address);
						String newName = node == null ? null : node.get(fieldName);
						
						if (newName == null) {
							return fs;
						}
						
						// prepare to resolve next field
						rootName = newName;
						
						for (int j = i + 1; j < varNameSplit.length; j++) {
							newName += "." + varNameSplit[j];
						}
						
						var.setName(newName);
					} else if (ht instanceof InductiveTerm) {
						// inductive term, need to unfold, then preprocess with new unfolded formula
						if (pre.getDepth() >= GlobalVariables.MAX_DEPTH) return fs;
						
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
			
			// in case the term is assignment to ref var
			// we need to update aliasMap and noNullSet
			if (cp == Comparator.ARV) {
				// get old name
				String lhsName = ct.getExp1().toString();
				String rhsName = ct.getExp2().toString();
					
				// update aliasMap
				updateAliasMap(f.getAliasMap(), lhsName, rhsName);
				// if rhs is not null, so is newLhs
				updateNoNullSet(noNullSet, lhsName, rhsName);
			} else if (cp == Comparator.APF || cp == Comparator.ARF) {
				Variable lhs = (Variable) ct.getExp1();
				String oldLhsName = lhs.toString();
				
				Variable tmp = new Variable(oldLhsName);
				String newLhsName = Utilities.freshVar(tmp).getName();
				
				lhs.setName(newLhsName);
				
				// update nameMap because the name of lhs is changed
				if (lastFieldName.isEmpty()) {
					// this is the case when we assign to a field of "this" object or static field
					// no need to update alias because no alias with "this" or class
					nameMap.put(lastVarName, newLhsName);
				} else {
					Integer address = addressMap.get(lastVarName);
					Map<String, String> node = nodeMap.get(address);
					node.put(lastFieldName, newLhsName);
				}
				
				if (cp == Comparator.ARF) {
					String rhsName = ct.getExp2().toString();
					// update alias because now lhs is alias with rhs
					
					// update aliasMap
					updateAliasMap(f.getAliasMap(), newLhsName, rhsName);
					// if rhs is not null, so is newLhs
					updateNoNullSet(noNullSet, newLhsName, rhsName);
				}
			} else if (cp == Comparator.EQ) {
				String lhs = ct.getExp1().toString();
				String rhs = ct.getExp2().toString();
				
				Integer address1 = addressMap.get(lhs);
				Integer address2 = addressMap.get(rhs);
				
				if (address1 != null && address2 != null && !address1.equals(address2)) {
					return fs;
				}
				
				f.getPureFormula().updateAlias(ct);
				
				// above update alias should make lhs and rhs alias
				Set<String> aliasLhs = f.getAlias(lhs);
				
				if (aliasLhs != null) {
					// in this case at least lhs and rhs are alias
					// create a tmp alias set
					Set<String> tmp = new HashSet<String>();
					tmp.addAll(aliasLhs);
					
					// if tmp contains null and noNullSet contains alias
					// the formula is wrong
					if (tmp.contains("null")) {
						for (String alias : tmp) {
							if (noNullSet.contains(alias)) {
								return fs;
							}
						}
					} else {
						// otherwise, if noNullSet contains alias
						// add the whole tmp set into nuNullSet
						for (String alias : tmp) {
							if (noNullSet.contains(alias)) {
								noNullSet.addAll(tmp);
								break;
							}
						}
					}
				}
			} else if (cp == Comparator.NE) {
				String lhs = ct.getExp1().toString();
				String rhs = ct.getExp2().toString();
				
				// clearly wrong
				if (lhs.equals(rhs)) return fs;
				
				Set<String> aliasLhs = f.getAlias(lhs);
				Set<String> aliasRhs = f.getAlias(rhs);
				
				// in case alias of lhs or rhs contains any alias of the other
				if (aliasLhs != null && aliasRhs != null) {
					for (String alias : aliasRhs) {
						if (aliasLhs.contains(alias))
							return fs;
					}
				}
				
				// in case rhs is null
				if (rhs.equals("null") || (aliasRhs != null && aliasRhs.contains("null"))) {
					if (aliasLhs == null) noNullSet.add(lhs);
					else noNullSet.addAll(aliasLhs);
				}
			}			
		}
		
		fs.add(f);
		return fs;
	}
		
	// aliasMap contains alias information
	private static void updateAliasMap(Map<String,Set<String>> aliasMap,
			String newLhsName, String rhsName) {
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
	
	private static void fillInFields(Map<Integer, Map<String, String>> nodeMap,
			int address, PointToTerm pt) {
		DataNode dn = DataNodeMap.find(pt.getType());
		Variable[] fields = dn.getFields();
		
		Map<String, String> newMap = new HashMap<String, String>();

		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			String symName = pt.getVarsNoRoot()[i].getName();
			
			newMap.put(fieldName, symName);
		}
		
		nodeMap.put(address, newMap);
	}

}
