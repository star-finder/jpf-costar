package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.NullExpression;

public class CMPInstrHelper {
	
	private static void addToStack(ThreadInfo ti, Instruction instr, CoStarConstrainstTree tree,
			int conditionValue, Formula f, Expression sym_v1, Expression sym_v2) {
		Instruction condInstr = instr.getNext(ti);
		
		if (condInstr instanceof IFEQ) {
			IFEQ ifeqInstr = (IFEQ) condInstr;
			ifeqInstr.addToStack(ti, tree, conditionValue, f, sym_v1, sym_v2);
		} else if (condInstr instanceof IFNE) {
			IFNE ifneInstr = (IFNE) condInstr;
			ifneInstr.addToStack(ti, tree, conditionValue, f, sym_v1, sym_v2);
		} else if (condInstr instanceof IFGT) {
			IFGT ifgtInstr = (IFGT) condInstr;
			ifgtInstr.addToStack(ti, tree, conditionValue, f, sym_v1, sym_v2);
		} else if (condInstr instanceof IFGE) {
			IFGE ifgeInstr = (IFGE) condInstr;
			ifgeInstr.addToStack(ti, tree, conditionValue, f, sym_v1, sym_v2);
		} else if (condInstr instanceof IFLT) {
			IFLT ifltInstr = (IFLT) condInstr;
			ifltInstr.addToStack(ti, tree, conditionValue, f, sym_v1, sym_v2);
		} else if (condInstr instanceof IFLE) {
			IFLE ifleInstr = (IFLE) condInstr;
			ifleInstr.addToStack(ti, tree, conditionValue, f, sym_v1, sym_v2);
		}
	}
	
	private static void addToStack(ThreadInfo ti, Instruction instr, CoStarConstrainstTree tree,
			int conditionValue, Formula f0, Formula f1, Formula f2) {
		Instruction condInstr = instr.getNext(ti);
		
		if (condInstr instanceof IFEQ) {
			IFEQ ifeqInstr = (IFEQ) condInstr;
			ifeqInstr.addToStack(ti, tree, conditionValue, f0, f1, f2);
		} else if (condInstr instanceof IFNE) {
			IFNE ifneInstr = (IFNE) condInstr;
			ifneInstr.addToStack(ti, tree, conditionValue, f0, f1, f2);
		} else if (condInstr instanceof IFGT) {
			IFGT ifgtInstr = (IFGT) condInstr;
			ifgtInstr.addToStack(ti, tree, conditionValue, f0, f1, f2);
		} else if (condInstr instanceof IFGE) {
			IFGE ifgeInstr = (IFGE) condInstr;
			ifgeInstr.addToStack(ti, tree, conditionValue, f0, f1, f2);
		} else if (condInstr instanceof IFLT) {
			IFLT ifltInstr = (IFLT) condInstr;
			ifltInstr.addToStack(ti, tree, conditionValue, f0, f1, f2);
		} else if (condInstr instanceof IFLE) {
			IFLE ifleInstr = (IFLE) condInstr;
			ifleInstr.addToStack(ti, tree, conditionValue, f0, f1, f2);
		}
	}
	
	public static Instruction getNextInstructionAndSetPCChoiceLong(ThreadInfo ti,
			Instruction instr, Expression sym_v1, Expression sym_v2,
			Comparator fstComparator, Comparator sndComparator, Comparator trdComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		Config config = ti.getVM().getConfig();
		boolean isInstrument = Boolean.parseBoolean(config.getProperty("costar.instrument", "false"));
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		List<Formula> constraints = new ArrayList<Formula>();
		
		int conditionValue = 0;
		
		long v2 = sf.popLong();
		long v1 = sf.popLong();
		
		if (v1 < v2) conditionValue = -1;
		else if (v1 == v2) conditionValue = 0;
		else conditionValue = 1;
		
		Formula f0 = formula.copy();
		Formula f1 = formula.copy();
		Formula f2 = formula.copy();
		
		if (sym_v1 != null) {
			if (sym_v2 != null) {
				f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
				f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
				f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
			} else {
				sym_v2 = new LiteralExpression(v2);
				
				f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
				f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
				f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
			}
		} else {
			sym_v1 = new LiteralExpression(v1);
			
			f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
			f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
			f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
		}
		
		constraints.add(f0);
		constraints.add(f1);
		constraints.add(f2);
		
		if (conditionValue == -1) {
			analysis.decision(ti, instr, 0, constraints);
		} else if (conditionValue == 0) {
			analysis.decision(ti, instr, 1, constraints);
		} else {
			analysis.decision(ti, instr, 2, constraints);
		}
		
		if (isInstrument) addToStack(ti, instr, tree, conditionValue, formula.copy(), sym_v1, sym_v2);
		
		sf.push(conditionValue);
		return instr.getNext(ti);
	}
	
	public static Instruction getNextInstructionAndSetPCChoiceFloat(ThreadInfo ti,
			Instruction instr, Expression sym_v1, Expression sym_v2,
			Comparator fstComparator, Comparator sndComparator, Comparator trdComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		Config config = ti.getVM().getConfig();
		boolean isInstrument = Boolean.parseBoolean(config.getProperty("costar.instrument", "false"));
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		List<Formula> constraints = new ArrayList<Formula>();
		
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
		
		Formula f0 = formula.copy();
		Formula f1 = formula.copy();
		Formula f2 = formula.copy();
		
		if (sym_v1 != null) {
			if (sym_v2 != null) {
				f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
				f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
				f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
			} else {
				sym_v2 = new LiteralExpression(v2);
				
				f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
				f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
				f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
			}
		} else {
			sym_v1 = new LiteralExpression(v1);
			
			f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
			f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
			f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
		}
		
		constraints.add(f0);
		constraints.add(f1);
		constraints.add(f2);
		
		if (conditionValue == -1) {
			analysis.decision(ti, instr, 0, constraints);
		} else if (conditionValue == 0) {
			analysis.decision(ti, instr, 1, constraints);
		} else {
			analysis.decision(ti, instr, 2, constraints);
		}
		
		if (isInstrument) addToStack(ti, instr, tree, conditionValue, formula.copy(), sym_v1, sym_v2);
		
		sf.push(conditionValue);
		return instr.getNext(ti);
	}
	
	public static Instruction getNextInstructionAndSetPCChoiceDouble(ThreadInfo ti,
			Instruction instr, Expression sym_v1, Expression sym_v2,
			Comparator fstComparator, Comparator sndComparator, Comparator trdComparator) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		StackFrame sf = ti.getModifiableTopFrame();
		
		Config config = ti.getVM().getConfig();
		boolean isInstrument = Boolean.parseBoolean(config.getProperty("costar.instrument", "false"));
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		List<Formula> constraints = new ArrayList<Formula>();
		
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
		
		Formula f0 = formula.copy();
		Formula f1 = formula.copy();
		Formula f2 = formula.copy();
		
		if (sym_v1 != null) {
			if (sym_v2 != null) {
				f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
				f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
				f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
			} else {
				sym_v2 = new LiteralExpression(v2);
				
				f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
				f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
				f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);
			}
		} else {
			sym_v1 = new LiteralExpression(v1);
			
			f0.addComparisonTerm(fstComparator, sym_v1, sym_v2);
			f1.addComparisonTerm(sndComparator, sym_v1, sym_v2);
			f2.addComparisonTerm(trdComparator, sym_v1, sym_v2);	
		}
		
		constraints.add(f0);
		constraints.add(f1);
		constraints.add(f2);
		
		if (conditionValue == -1) {
			analysis.decision(ti, instr, 0, constraints);
		} else if (conditionValue == 0) {
			analysis.decision(ti, instr, 1, constraints);
		} else {
			analysis.decision(ti, instr, 2, constraints);
		}
				
		if (isInstrument) addToStack(ti, instr, tree, conditionValue, formula.copy(), sym_v1, sym_v2);
		
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
