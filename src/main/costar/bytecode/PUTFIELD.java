package costar.bytecode;

import java.util.Map;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;

public class PUTFIELD extends gov.nasa.jpf.jvm.bytecode.PUTFIELD {

	public PUTFIELD(String fieldName, String clsDescriptor, String fieldDescriptor) {
		super(fieldName, clsDescriptor, fieldDescriptor);
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
		
		Variable objVar = null;
		Expression exp = null;
		
		if (fi.isLongField() || fi.isDoubleField()) {
			exp = (Expression) sf.getOperandAttr(1);
			objVar = (Variable) sf.getOperandAttr(2);
		} else {
			exp = (Expression) sf.getOperandAttr(0);
			objVar = (Variable) sf.getOperandAttr(1);
		}
		
		Instruction nextIns = super.execute(ti);
		
		String objName = objVar.getName();
		if (objName.contains("_")) {
			objName = objName.substring(0, objName.indexOf('_'));
		}
		
		String name = objName + "." + fname;
		
		Variable var = new Variable(objVar.getName() + "." + fname);
		Variable newVar = Utilities.freshVar(var);
		
		Map<String, String> nameMap = analysis.getNameMap();
		nameMap.put(name, newVar.getName());
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();

		Formula formula = current.formula;
		formula.addComparisonTerm(Comparator.EQ, newVar, exp);

		return nextIns;
	}

}
