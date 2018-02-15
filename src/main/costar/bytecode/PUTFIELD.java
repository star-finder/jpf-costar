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
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.NullExpression;

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
		
		int objRef = sf.peek(size); // don't pop yet, we might re-enter
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
		
		if (exp == null) {
			if (isReferenceField) {
				exp = NullExpression.getInstance();
			} else {
				int value = sf.peek(size - 1);
				exp = new LiteralExpression(value + "");
			}
		}
		
		Instruction nextIns = super.execute(ti);
		
		if (objVar != null) {
			String objName= objVar.getName();
			String name = null;
			
			if (objName.equals("this")) {
				name = objName + "_" + fname;
			} else {
				name = objName + "." + fname;
			}
			
			Variable var = new Variable(name);
//			Variable newVar = Utilities.freshVar(var);
//			
//			Map<String, String> nameMap = analysis.getNameMap();
//			nameMap.put(var.getName(), newVar.getName());
			
			CoStarConstrainstTree tree = analysis.getConstrainstTree();
			CoStarNode current = tree.getCurrent();
	
			Formula formula = current.formula;
			
			if (isReferenceField)
				formula.addComparisonTerm(Comparator.AF, var, exp);
			else
				formula.addComparisonTerm(Comparator.AS, var, exp);
		}
		
//		if (objVar != null && exp != null) {
//			String objName = objVar.getName();
//			String tmp = "";
//			
//			if (objName.contains("this_")) {
//				objName = objName.substring(5, objName.length());
//				tmp = "this_";
//			}
//			
//			if (objName.contains("_")) {
//				objName = objName.substring(0, objName.lastIndexOf('_'));
//			}
//			
//			objName = tmp + objName;
//			
//			String name = objName.equals("this") ? objName + "_" + fname : objName + "." + fname;
//			
//			Variable var = null;
//			if (objName.equals("this"))
//				var = new Variable(name);
//			else
//				var = new Variable(objVar.getName() + "." + fname);
//					
//			Variable newVar = Utilities.freshVar(var);
//			
//			Map<String, String> nameMap = analysis.getNameMap();
//			nameMap.put(var.getName(), newVar.getName());
//			
//			CoStarConstrainstTree tree = analysis.getConstrainstTree();
//			CoStarNode current = tree.getCurrent();
//	
//			Formula formula = current.formula;
//			formula.addComparisonTerm(Comparator.EQ, newVar, exp);
//		}

		return nextIns;
	}

}
