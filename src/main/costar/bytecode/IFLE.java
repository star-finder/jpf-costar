package costar.bytecode;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.jdart.ConcolicUtil;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;

public class IFLE extends gov.nasa.jpf.jvm.bytecode.IFLE {

	private JPFLogger logger = JPF.getLogger("costar");

	public IFLE(int index) {
		super(index);
	}

	@Override
	public Instruction execute(ThreadInfo ti) {		
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);

		if (analysis == null)
			return super.execute(ti);

		StackFrame sf = ti.getModifiableTopFrame();
//		Expression<?> exp = (Expression<?>) sf.getOperandAttr();
//		if (exp == null) {
//			return super.execute(ti);
//		}

		ConcolicUtil.Pair<Integer> v1 = ConcolicUtil.popInt(sf);
		
		Integer i1 = v1.conc;
		String[] constraints = new String[2];
		constraints[0] = v1.symb.toString() + " <= 0";
		constraints[1] = v1.symb.toString() + " > 0";
		
		if (i1 <= 0) {
			analysis.decision(ti, this, 0, constraints);
			return getTarget();
		} else {
			analysis.decision(ti, this, 1, constraints);
			return getNext();
		}
	}

}
