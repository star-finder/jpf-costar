package costar.bytecode;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.JPFException;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LoadOnJPFRequired;
import gov.nasa.jpf.vm.ThreadInfo;

public class GETSTATIC extends gov.nasa.jpf.jvm.bytecode.GETSTATIC {

	public GETSTATIC(String fieldName, String clsDescriptor, String fieldDescriptor) {
		super(fieldName, clsDescriptor, fieldDescriptor);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);	
		
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
		
		return super.execute(ti);
	}

}
