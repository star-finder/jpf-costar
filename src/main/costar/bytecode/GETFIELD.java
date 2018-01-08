package costar.bytecode;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.constraints.api.Expression;
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
				
		Object sym_v = ei.getFieldAttr(fi);
		if (sym_v == null)
			return super.execute(ti);
		
		starlib.formula.expression.Expression var = null;
		if (sym_v instanceof Expression<?>) {
			var = new Variable(((Expression<?>)sym_v).toString(0));
			ei.setFieldAttr(fi, var);
		}
		
		if (var == null) {
			System.out.println(ei.getFieldAttr(fi));
			var = (starlib.formula.expression.Expression) ei.getFieldAttr(fi);
		}
		
		if (var.toString().contains("newNode_"))
			return super.execute(ti);
		
		if (fi.isReference()) {
			int fiRef = ei.getReferenceField(fi);
			if (fiRef != MJIEnv.NULL && var != null) {
				ElementInfo eei = ti.getModifiableElementInfo(fiRef);
				for (int i = 0; i < eei.getNumberOfFields(); i++) {
					FieldInfo ffi = eei.getFieldInfo(i);
					if (eei.getFieldAttr(ffi) == null)
						eei.setFieldAttr(ffi, new Variable(var + "." + ffi.getName()));
				}
			}
		}

		return super.execute(ti);
	}
	
}
