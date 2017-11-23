package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.NullExpression;

public class CMPInstrSymbHelper {
	
	public static Instruction getNextInstructionAndSetPCChoiceLong(ThreadInfo ti,
			Instruction instr, Expression sym_v1, Expression sym_v2,
			Comparator fstComparator, Comparator sndComparator, Comparator trdComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // < 0 formulas
		constraints.add(new ArrayList<Formula>()); // = 0 formulas
		constraints.add(new ArrayList<Formula>()); // > 0 formulas
		
		int conditionValue = 0;
		
		long v2 = sf.popLong();
		long v1 = sf.popLong();
		
		if (v1 < v2) conditionValue = -1;
		else if (v1 == v2) conditionValue = 0;
		else conditionValue = 1;
		
		for (Formula formula : formulas) {
			Formula f0 = formula.copy();
			Formula f1 = formula.copy();
			Formula f2 = formula.copy();
			
			if (sym_v1 != null) {
				if (sym_v2 != null) {
					f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
					f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
					f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
				} else {
					f0.addComparisonTerm(fstComparator, sym_v1, new LiteralExpression(v2));
					f1.addComparisonTerm(sndComparator, sym_v1, new LiteralExpression(v2));
					f2.addComparisonTerm(trdComparator, sym_v1, new LiteralExpression(v2));
				}
			} else {
				f0.addComparisonTerm(fstComparator, new LiteralExpression(v1), sym_v2);
				f1.addComparisonTerm(sndComparator, new LiteralExpression(v1), sym_v2);
				f2.addComparisonTerm(trdComparator, new LiteralExpression(v1), sym_v2);
			}
			
			constraints.get(0).add(f0);
			constraints.get(1).add(f1);
			constraints.get(2).add(f2);
		}
		
		if (conditionValue == -1) {
			analysis.decision(ti, instr, 0, constraints);
		} else if (conditionValue == 0) {
			analysis.decision(ti, instr, 1, constraints);
		} else {
			analysis.decision(ti, instr, 2, constraints);
		}
		
		sf.push(conditionValue);
		return instr.getNext(ti);
	}
	
	public static Instruction getNextInstructionAndSetPCChoiceFloat(ThreadInfo ti,
			Instruction instr, Expression sym_v1, Expression sym_v2,
			Comparator fstComparator, Comparator sndComparator, Comparator trdComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // < 0 formulas
		constraints.add(new ArrayList<Formula>()); // = 0 formulas
		constraints.add(new ArrayList<Formula>()); // > 0 formulas
		
		int conditionValue = 0;
		
		float v2 = sf.popFloat();
		float v1 = sf.popFloat();
		
		if (Float.isNaN(v1) || Float.isNaN(v2)) {
			if (instr instanceof FCMPG) {
				conditionValue = 1;
			} else {
				conditionValue = -1;
			}
		} else {
			if (v1 < v2) conditionValue = -1;
			else if (v1 == v2) conditionValue = 0;
			else conditionValue = 1;
		}
		
		for (Formula formula : formulas) {
			Formula f0 = formula.copy();
			Formula f1 = formula.copy();
			Formula f2 = formula.copy();
			
			if (sym_v1 != null) {
				if (sym_v2 != null) {
					f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
					f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
					f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
				} else {
					f0.addComparisonTerm(fstComparator, sym_v1, new LiteralExpression(v2));
					f1.addComparisonTerm(sndComparator, sym_v1, new LiteralExpression(v2));
					f2.addComparisonTerm(trdComparator, sym_v1, new LiteralExpression(v2));
				}
			} else {
				f0.addComparisonTerm(fstComparator, new LiteralExpression(v1), sym_v2);
				f1.addComparisonTerm(sndComparator, new LiteralExpression(v1), sym_v2);
				f2.addComparisonTerm(trdComparator, new LiteralExpression(v1), sym_v2);
			}
			
			constraints.get(0).add(f0);
			constraints.get(1).add(f1);
			constraints.get(2).add(f2);
		}
		
		if (conditionValue == -1) {
			analysis.decision(ti, instr, 0, constraints);
		} else if (conditionValue == 0) {
			analysis.decision(ti, instr, 1, constraints);
		} else {
			analysis.decision(ti, instr, 2, constraints);
		}
		
		sf.push(conditionValue);
		return instr.getNext(ti);
	}
	
	public static Instruction getNextInstructionAndSetPCChoiceDouble(ThreadInfo ti,
			Instruction instr, Expression sym_v1, Expression sym_v2,
			Comparator fstComparator, Comparator sndComparator, Comparator trdComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // < 0 formulas
		constraints.add(new ArrayList<Formula>()); // = 0 formulas
		constraints.add(new ArrayList<Formula>()); // > 0 formulas
		
		int conditionValue = 0;
		
		double v2 = sf.popDouble();
		double v1 = sf.popDouble();
		
		if (Double.isNaN(v1) || Double.isNaN(v2)) {
			if (instr instanceof DCMPG) {
				conditionValue = 1;
			} else {
				conditionValue = -1;
			}
		} else {
			if (v1 < v2) conditionValue = -1;
			else if (v1 == v2) conditionValue = 0;
			else conditionValue = 1;
		}
		
		for (Formula formula : formulas) {
			Formula f0 = formula.copy();
			Formula f1 = formula.copy();
			Formula f2 = formula.copy();
			
			if (sym_v1 != null) {
				if (sym_v2 != null) {
					f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
					f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
					f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
				} else {
					f0.addComparisonTerm(fstComparator, sym_v1, new LiteralExpression(v2));
					f1.addComparisonTerm(sndComparator, sym_v1, new LiteralExpression(v2));
					f2.addComparisonTerm(trdComparator, sym_v1, new LiteralExpression(v2));
				}
			} else {
				f0.addComparisonTerm(fstComparator, new LiteralExpression(v1), sym_v2);
				f1.addComparisonTerm(sndComparator, new LiteralExpression(v1), sym_v2);
				f2.addComparisonTerm(trdComparator, new LiteralExpression(v1), sym_v2);
			}
			
			constraints.get(0).add(f0);
			constraints.get(1).add(f1);
			constraints.get(2).add(f2);
		}
		
		if (conditionValue == -1) {
			analysis.decision(ti, instr, 0, constraints);
		} else if (conditionValue == 0) {
			analysis.decision(ti, instr, 1, constraints);
		} else {
			analysis.decision(ti, instr, 2, constraints);
		}
		
		sf.push(conditionValue);
		return instr.getNext(ti);
	}
	
	/*
	 * Make a variable in the predicate sym_v is the symbolic variable put in by
	 * symbolic execution, sym_v = null means the variable is concrete. v is the
	 * concrete value of the variable, v = 0 means the variable is null
	 */
	public static Expression makeExpression(Object sym_v, int v) {
		if(sym_v != null) {
			return new Variable(sym_v.toString());
		} else if(v == 0) {
			return NullExpression.getInstance();
		} else {
			return new LiteralExpression(v);
		}
	}

}
