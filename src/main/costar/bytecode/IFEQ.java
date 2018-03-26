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
			int conditionValue, Formula f0, Formula f1, Formula f2) {
		if (conditionValue == 0) {
			if (!IFInstrSymbHelper.isExecuted(ti, getNext(ti))) {
				tree.addToStack(f0);
				tree.addToStack(f2);
			}
		} else {
			if (!IFInstrSymbHelper.isExecuted(ti, getTarget())) {
				tree.addToStack(f1);
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
		
		Instruction nxtInstr = IFInstrSymbHelper.
				getNextInstructionAndSetPCChoice(ti, this, exp, litExp, Comparator.EQ, Comparator.NE);
		
		if (nxtInstr == getTarget())
			conditionValue = true;
		else
			conditionValue = false;
		return nxtInstr;
	}

}
