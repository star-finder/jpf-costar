package costar.valuation;

import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Variable;
import starlib.formula.heap.PointToTerm;

public class SetFieldValGenVisitor extends ValGenVisitor {
	
	public SetFieldValGenVisitor(ValGenVisitor that) {
		super(that);
	}
	
	@Override
	public void visit(PointToTerm term) {
		Variable root = term.getRoot();
		Variable[] vars = term.getVarsNoRoot();
		
		Object value = valuation.getValue(root.getName());
		
		ThreadInfo ti = VM.getVM().getCurrentThread();
		Heap heap = ti.getHeap();
		ElementInfo ei = heap.get((Integer) value);
		
		if (ei == null) return;
		
		for (int i = 0; i < vars.length; i++) {
			FieldInfo fi = ei.getFieldInfo(i);
			String fiType = fi.getType();
			String name = vars[i].getName();
			
//			Object attr = null;
			
			if (fiType.equals("boolean")) {
				ei.setBooleanField(fi, (Boolean) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else if (fiType.equals("byte")) {
				ei.setByteField(fi, (Byte) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else if (fiType.equals("char")) {
				ei.setCharField(fi, (Character) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else if (fiType.equals("short")) {
				ei.setShortField(fi, (Short) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else if (fiType.equals("int")) {
				ei.setIntField(fi, (Integer) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else if (fiType.equals("long")) {
				ei.setLongField(fi, (Long) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else if (fiType.equals("float")) {
				ei.setFloatField(fi, (Float) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else if (fiType.equals("double")) {
				ei.setDoubleField(fi, (Double) valuation.getValue(name));
//				attr = gov.nasa.jpf.constraints.api.Variable.create(getType(fiType), name);
			} else {
				// reference type
				ei.setReferenceField(fi, (Integer) valuation.getValue(name));
//				attr = new SymbolicObject(name);
			}
			
//			ei.setFieldAttr(fi, attr);
		}
	}

}
