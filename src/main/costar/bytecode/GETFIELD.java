package costar.bytecode;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Variable;

public class GETFIELD extends gov.nasa.jpf.jvm.bytecode.GETFIELD {
	
	public GETFIELD(String fieldName, String classType, String fieldDescriptor) {
		super(fieldName, classType, fieldDescriptor);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);	
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		int objRef = sf.peek(); // don't pop yet, we might re-enter
		lastThis = objRef;

		// --- check for obvious exceptions
		if (objRef == MJIEnv.NULL) {
			return ti.createAndThrowException("java.lang.NullPointerException",
		              "referencing field '" + fname + "' on null object");
		}
		
		ElementInfo ei = ti.getModifiableElementInfo(objRef);
		FieldInfo fi = getFieldInfo();
		if (fi == null) {
			return ti.createAndThrowException("java.lang.NoSuchFieldError",
					"referencing field '" + fname + "' in " + ei);
		}
		
		Variable objVar = (Variable) sf.getOperandAttr();
		
		Instruction nextIns = super.execute(ti);
		
		if (objVar != null) {
			String objName = objVar.getName();
			String name = null;
			
			if (objName.equals("this")) {
				name = objName + "_" + fname;
			} else {
				name = objName + "." + fname;
			}
			
			if (fi.isLongField() || fi.isDoubleField()) {
				sf.setLongOperandAttr(new Variable(name));
			} else {
				sf.setOperandAttr(new Variable(name));
			}
		}

		return nextIns;
	}
	
}
