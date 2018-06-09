package costar.bytecode;

import java.util.Map;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.JPFException;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LoadOnJPFRequired;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.NullExpression;

public class PUTSTATIC extends gov.nasa.jpf.jvm.bytecode.PUTSTATIC {

	public PUTSTATIC(String fieldName, String clsDescriptor, String fieldDescriptor) {
		super(fieldName, clsDescriptor, fieldDescriptor);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null || fname.contains("$bitMap"))
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
		
		Expression exp = null;
		
		if (fi.isLongField() || fi.isDoubleField()) {
			exp = (Expression) sf.getOperandAttr(1);
		} else {
			exp = (Expression) sf.getOperandAttr(0);
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
		
		if (exp != null) {
			String name = className + "." + fname;
			
			Variable var = new Variable(className + "." + fname);
//			Variable newVar = Utilities.freshVar(var);
//			
//			Map<String, String> nameMap = analysis.getNameMap();
//			nameMap.put(name, newVar.getName());
			
			CoStarConstrainstTree tree = analysis.getConstrainstTree();
			CoStarNode current = tree.getCurrent();
	
			Formula formula = current.formula;
			
			if (isReferenceField)
				formula.addComparisonTerm(Comparator.ARF, var, exp);
			else
				formula.addComparisonTerm(Comparator.ARV, var, exp);
		}

		return nextIns;
	}

}
