package costar.bytecode;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;

public class ALOAD extends gov.nasa.jpf.jvm.bytecode.ALOAD {

	public ALOAD(int index) {
		super(index);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		Config conf = ti.getVM().getConfig();
		StackFrame sf = ti.getModifiableTopFrame();
		
		int objRef = sf.peek();
		ElementInfo ei = ti.getElementInfo(objRef);
		Object sym_v = sf.getLocalAttr(index);
		
		if (sym_v != null)
			System.out.println(sym_v);
		
		return super.execute(ti);
	}

}
