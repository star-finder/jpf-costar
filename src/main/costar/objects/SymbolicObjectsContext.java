package costar.objects;

import com.google.common.base.Predicate;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.jdart.objects.SymbolicObject;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Heap;

public class SymbolicObjectsContext extends gov.nasa.jpf.jdart.objects.SymbolicObjectsContext {

	private JPFLogger logger = JPF.getLogger("costar");

	public SymbolicObjectsContext(Heap heap, Predicate<? super String> exclude, Predicate<? super String> include,
			Predicate<? super ClassInfo> excludeSpecial) {
		super(heap, exclude, include, excludeSpecial);
	}

	@Override
	public void processField(ElementInfo ei, FieldInfo fi, String name) {
		super.processField(ei, fi, name);

		if (fi.isReference()) {
			SymbolicObject attr = ei.getObjectAttr(SymbolicObject.class);
			attr = new SymbolicObject(name);
			ei.setFieldAttr(fi, attr);
		}
	}

}
