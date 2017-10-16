package costar.constrainsts;

import java.util.List;

import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.api.ValuationEntry;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import gov.nasa.jpf.constraints.types.Type;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.VariableExpression;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.EqNullTerm;
import starlib.jpf.PathFinderUtils;
import starlib.jpf.testsuites.PathFinderVisitor;

public class ValuationVisitor extends PathFinderVisitor {

	private Valuation val;

	public ValuationVisitor(PathFinderVisitor that) {
		super(that);
		val = ((PathFinderValuationGenerator) that).getValuation();
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
