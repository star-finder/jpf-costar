package costar.bytecode;

import java.util.Map;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.JPFException;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LoadOnJPFRequired;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Variable;

public class GETSTATIC extends gov.nasa.jpf.jvm.bytecode.GETSTATIC {

	public GETSTATIC(String fieldName, String clsDescriptor, String fieldDescriptor) {
		super(fieldName, clsDescriptor, fieldDescriptor);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		FieldInfo fi;

		try {
			fi = getFieldInfo();
		} catch (LoadOnJPFRequired lre) {
			return ti.getPC();
		}

		if (fi == null) {
			return ti.createAndThrowException("java.lang.NoSuchFieldError",
					(className + '.' + fname));
		}
		
		ClassInfo ci = fi.getClassInfo();

		if (!mi.isClinit(ci) && ci.initializeClass(ti)) {
			return ti.getPC();
		}

		ElementInfo ei = ci.getModifiableStaticElementInfo();

		if (ei == null) {
			throw new JPFException("attempt to access field: " +
					fname + " of uninitialized class: " + ci.getName());
		}
		
//		Object sym_v = ei.getFieldAttr(fi);
//		if (sym_v == null)
//			return super.execute(ti);
//		
//		starlib.formula.expression.Expression var = null;
//		if (sym_v instanceof Expression<?>) {
//			var = new Variable(((Expression<?>)sym_v).toString(0));
//			ei.setFieldAttr(fi, var);
//		}
//		
//		if (var == null)
//			var = (starlib.formula.expression.Expression) ei.getFieldAttr(fi);
//		
//		if (var.toString().contains("newNode_"))
//			return super.execute(ti);
//		
//		if (fi.isReference()) {
//			int fiRef = ei.getReferenceField(fi);
//			if (fiRef != MJIEnv.NULL && var != null) {
//				ElementInfo eei = ti.getModifiableElementInfo(fiRef);
//				for (int i = 0; i < eei.getNumberOfFields(); i++) {
//					FieldInfo ffi = eei.getFieldInfo(i);
//					if (eei.getFieldAttr(ffi) == null)
//						eei.setFieldAttr(ffi, new Variable(var + "." + ffi.getName()));
//				}
//			}
//		}
		
		Instruction nextIns = super.execute(ti);
		
		String name = className + "." + fname;
		
		Map<String,String> nameMap = analysis.getNameMap();
		if (nameMap.containsKey(name)) {
			name = nameMap.get(name);
		} else {
			nameMap.put(name, name);
		}
			
		sf.setOperandAttr(new Variable(name));
		
		return nextIns;
	}

}
