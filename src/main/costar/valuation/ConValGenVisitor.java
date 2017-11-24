package costar.valuation;

import java.util.Set;

import gov.nasa.jpf.constraints.api.ValuationEntry;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import gov.nasa.jpf.constraints.types.Type;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.NullExpression;
import starlib.formula.heap.PointToTerm;
import starlib.formula.pure.ComparisonTerm;

public class ConValGenVisitor extends ValGenVisitor {

	public ConValGenVisitor(ValGenVisitor that) {
		super(that);
	}
	
	@Override
	public void visit(PointToTerm term) {
		genNewObjectValuation(term.getRoot());
	}

	@Override
	public void visit(ComparisonTerm term) {
		Comparator comp = term.getComparator();
		Expression exp1 = term.getExp1();
		Expression exp2 = term.getExp2();
		
		boolean isVar1 = exp1 instanceof Variable;
		boolean isVar2 = exp2 instanceof Variable;
		
		if (comp == Comparator.EQ) {
			if (isVar1 && isVar2) {
				// former EqTerm
				Variable var1 = (Variable) exp1;
				Variable var2 = (Variable) exp2;
				boolean constains1 = initVars.contains(var1);
				boolean constains2 = initVars.contains(var2);
				
				if (!constains1 && constains2) {
					initVars.add(var1);
					
					Type<?> type = getType(var1.getType());
					String name = var1.getName();
					Object value = valuation.getValue(var2.getName());
					
					ValuationEntry<?> e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
					valuation.addEntry(e);
				}
				
				if (constains1 && !constains2) {
					initVars.add(var2);
					
					Type<?> type = getType(var2.getType());
					String name = var2.getName();
					Object value = valuation.getValue(var1.getName());
					
					ValuationEntry<?> e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
					valuation.addEntry(e);
				}
				return;
			}
			if (isVar1 && exp2 instanceof NullExpression) {
				// former EqNullTerm
				Variable var1 = (Variable) exp1;
				if (!initVars.contains(var1)) {
					initVars.add(var1);
					
					Type<?> type = BuiltinTypes.REF;
					String name = var1.getName();
					Object value = new Integer(0);
					
					ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
					valuation.addEntry(e);
				}
				return;
			}
		}
		
		// former ComparisonTerm
		Set<Variable> vars1 = exp1.getVars();
		Set<Variable> vars2 = exp2.getVars();
		
		Variable var = null;
		Type type = null;
		String name = null, typeStr = null, valueStr = null;
		Object value = null;
		
		if (comp == Comparator.EQ && exp1 instanceof Variable && 
				!initVars.containsAll(vars1) && (vars2.isEmpty() || initVars.containsAll(vars2))) {
			var = (Variable) exp1;
			valueStr = exp2.toString();
		}
		
		if (comp == Comparator.EQ && exp2 instanceof Variable && 
				!initVars.containsAll(vars2) && (vars1.isEmpty() || initVars.containsAll(vars1))) {
			var = (Variable) exp1;
			valueStr = exp2.toString();
		}
		
		if (var != null) {
			initVars.add(var);
			name = var.getName();
			typeStr = var.getType();
		}
		
		if (typeStr != null) {
			type = getType(typeStr);
			
			if (type == BuiltinTypes.BOOL) {
				if (valueStr.equals("0"))
					value = new Boolean(false);
				else
					value = new Boolean(true);
			} else if (type == BuiltinTypes.SINT8) {
				value = new Byte(valueStr);
			} else if (type == BuiltinTypes.UINT16) {
				value = new Character(valueStr.charAt(0));
			} else if (type == BuiltinTypes.SINT16) {
				value = new Short(valueStr);
			} else if (type == BuiltinTypes.SINT32) {
				value = new Integer(valueStr);
			} else if (type == BuiltinTypes.SINT64) {
				value = new Long(valueStr);
			} else if (type == BuiltinTypes.FLOAT) {
				value = new Float(valueStr);
			} else if (type == BuiltinTypes.DOUBLE) {
				value = new Double(valueStr);
			}
		}
		
		if (type != null && name != null && value != null) {
			ValuationEntry<?> e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
			valuation.addEntry(e);
		}
	}

}
