package costar.bytecode;

import java.util.Map;

import costar.CoStarMethodExplorer;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Variable;

public class ALOAD extends gov.nasa.jpf.jvm.bytecode.ALOAD {
	
	public ALOAD(int index) {
		super(index);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		
//		Object sym_v = sf.getLocalAttr(index);
//		if (sym_v == null)
//			return super.execute(ti);
//		
//		starlib.formula.expression.Expression var = null;
//		if (sym_v instanceof Expression<?>) {
//			var = new Variable(((Expression<?>)sym_v).toString(0));
//			sf.setLocalAttr(index, var);
//		}
//		
//		if (var == null)
//			var = (starlib.formula.expression.Expression) sf.getLocalAttr(index);
//		
//		if (var.toString().contains("newNode_"))
//			return super.execute(ti);
//		
//		int objRef = sf.getSlot(index);
//		if (objRef != MJIEnv.NULL && var != null) {
//			ElementInfo ei = ti.getModifiableElementInfo(objRef);
//			for (int i = 0; i < ei.getNumberOfFields(); i++) {
//				FieldInfo fi = ei.getFieldInfo(i);
//				if (ei.getFieldAttr(fi) == null)
//					ei.setFieldAttr(fi, new Variable(var + "." + fi.getName()));
//			}
//		}
		
		Instruction nextIns = super.execute(ti);
		
		LocalVarInfo lvi = sf.getLocalVarInfo(index);
		
		if (lvi != null) {
			String name = lvi.getName();
			
			Map<String,String> nameMap = analysis.getNameMap();
			if (nameMap.containsKey(name)) {
				name = nameMap.get(name);
			} else {
				nameMap.put(name, name);
			}
			
			sf.setOperandAttr(new Variable(name));
		}
		
		return nextIns;
	}

}
