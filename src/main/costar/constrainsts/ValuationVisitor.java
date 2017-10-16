package costar.constrainsts;

import java.util.List;

import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.api.ValuationEntry;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import gov.nasa.jpf.constraints.types.Type;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.VariableExpression;
import starlib.formula.heap.PointToTerm;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.EqNullTerm;
import starlib.jpf.testsuites.PathFinderVisitor;

public class ValuationVisitor extends PathFinderVisitor {

	private Valuation val;

	public ValuationVisitor(PathFinderVisitor that) {
		super(that);
		val = ((PathFinderValuationGenerator) that).getValuation();
	}
	
	@Override
	public void visit(PointToTerm term) {
		Variable var = term.getRoot();
		
		if (!initVars.contains(var)) {
			initVars.add(var);
			
			Type type = BuiltinTypes.SINT32;
			String typeStr = "features.sll.Node"; //var.getType();
			String name = var.getName();
			
			ClassInfo ci = ClassLoaderInfo.getCurrentResolvedClassInfo(typeStr);
			ThreadInfo ti = VM.getVM().getCurrentThread();
			Heap heap = ti.getHeap();
			ElementInfo ei = heap.newObject(ci, ti);
			
			Object value = new Integer(ei.getObjectRef());
			
			ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
			val.addEntry(e);
		}
	}
	
	@Override
	public void visit(EqNullTerm term) {
		Variable var = term.getVar();
		
		if (!initVars.contains(var)) {
			initVars.add(var);
			
			Type type = BuiltinTypes.SINT32;
			String name = var.getName();
			Object value = new Integer(0);
			
			ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
			val.addEntry(e);
		}
	}

	@Override
	public void visit(ComparisonTerm term) {
		Comparator comp = term.getComparator();
		Expression exp1 = term.getExp1();
		Expression exp2 = term.getExp2();
		
		List<Variable> vars1 = exp1.getVars();
		List<Variable> vars2 = exp2.getVars();
		
		Variable var = null;
		Type type = null;
		String name = null, typeStr = null, valueStr = null;
		Object value = null;
		
		if (comp == Comparator.EQ && exp1 instanceof VariableExpression && 
				!initVars.containsAll(vars1) && (vars2.isEmpty() || initVars.containsAll(vars2))) {
			var = ((VariableExpression) exp1).getVar();
			valueStr = exp2.toString();
		}
		
		if (comp == Comparator.EQ && exp2 instanceof VariableExpression && 
				!initVars.containsAll(vars2) && (vars1.isEmpty() || initVars.containsAll(vars1))) {
			var = ((VariableExpression) exp1).getVar();
			valueStr = exp2.toString();
		}
		
		if (var != null) {
			initVars.add(var);
			name = var.getName();
			typeStr = var.getType();
		}
		
		if (typeStr != null) {
			if (typeStr.equals("boolean")) {
				if (valueStr.equals("0"))
					valueStr = "false";
				else
					valueStr = "true";
				
				type = BuiltinTypes.BOOL;
				value = new Boolean(valueStr);
			} else if (typeStr.equals("int")) {
				type = BuiltinTypes.SINT32;
				value = new Integer(valueStr);
			}
		}
		
		if (type != null && name != null && value != null) {
			ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
			val.addEntry(e);
		}
	}

}
