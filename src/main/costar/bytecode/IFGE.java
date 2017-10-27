package costar.bytecode;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

public class IFGE extends gov.nasa.jpf.jvm.bytecode.IFGE {
	
	private JPFLogger logger = JPF.getLogger("costar");

	public IFGE(int index) {
		super(index);
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
				getNextInstructionAndSetPCChoice(ti, this, exp, litExp, Comparator.GE, Comparator.LT);
		
		if (nxtInstr == getTarget())
			conditionValue = true;
		else
			conditionValue = false;
		return nxtInstr;
	}

}
