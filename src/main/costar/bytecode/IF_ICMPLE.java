package costar.bytecode;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;

public class IF_ICMPLE extends gov.nasa.jpf.jvm.bytecode.IF_ICMPLE {
	
	public IF_ICMPLE(int index) {
		super(index);
	}

	@Override
	public Instruction execute(ThreadInfo ti) {		
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);

		StackFrame sf = ti.getModifiableTopFrame();
		
		Expression exp1 = (Expression) sf.getOperandAttr(1);
		Expression exp2 = (Expression) sf.getOperandAttr(0);
		
		if (exp1 == null && exp2 == null) {
			return super.execute(ti);
		}
		
		Instruction nxtInstr = IFInstrSymbHelper.
				getNextInstructionAndSetPCChoice(ti, this, exp1, exp2, Comparator.LE, Comparator.GT);
		
		if (nxtInstr == getTarget())
			conditionValue = true;
		else
			conditionValue = false;
		return nxtInstr;
	}

}
