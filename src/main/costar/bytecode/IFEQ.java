package costar.bytecode;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

public class IFEQ extends gov.nasa.jpf.jvm.bytecode.IFEQ {
	
	public IFEQ(int index) {
		super(index);
	}
	
	public void addToStack(ThreadInfo ti, CoStarConstrainstTree tree,
			int conditionValue, Formula f, Expression sym_v1, Expression sym_v2) {
		Formula f0 = f.copy();
		Formula f1 = f.copy();
		
		f0.addComparisonTerm(Comparator.EQ, sym_v1, sym_v2);
		f1.addComparisonTerm(Comparator.NE, sym_v1, sym_v2);
		
		if (conditionValue == 0) {
			int index = IFInstrHelper.getIndex(ti, getNext(ti));
			if (index >= 0) {
				tree.addToStack(f1, index);
			}
		} else {
			int index = IFInstrHelper.getIndex(ti, getTarget());
			if (index >= 0) {
				tree.addToStack(f0, index);
			}
		}
	}
	
	public void addToStack(ThreadInfo ti, CoStarConstrainstTree tree,
			int conditionValue, Formula f0, Formula f1, Formula f2) {
		if (conditionValue == 0) {
			int index = IFInstrHelper.getIndex(ti, getNext(ti));
			if (index >= 0) {
				tree.addToStack(f0, index);
				tree.addToStack(f2, index);
			}
		} else {
			int index = IFInstrHelper.getIndex(ti, getTarget());
			if (index >= 0) {
				tree.addToStack(f1, index);
			}
		}
	}

	@Override
	public Instruction execute(ThreadInfo ti) {		
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);

		StackFrame sf = ti.getModifiableTopFrame();
		Expression exp = (Expression) sf.getOperandAttr();
		if (exp == null) {
			return super.execute(ti);
		}
	
		LiteralExpression litExp = new LiteralExpression(0);
		
		Instruction nxtInstr = IFInstrHelper.
				getNextInstructionAndSetPCChoice(ti, this, exp, litExp, Comparator.EQ, Comparator.NE);
		
		if (nxtInstr == getTarget())
			conditionValue = true;
		else
			conditionValue = false;
		return nxtInstr;
	}

}
