package costar.valuation;

import gov.nasa.jpf.constraints.api.ValuationEntry;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import gov.nasa.jpf.constraints.types.Type;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.NullExpression;
import starlib.formula.pure.ComparisonTerm;

public class NoConValGenVisitor extends ValGenVisitor {
	
	public NoConValGenVisitor(ValGenVisitor that) {
		super(that);
	}
	
	@Override
	public void visit(ComparisonTerm term) {
		Expression exp1 = term.getExp1();
		Expression exp2 = term.getExp2();
		Comparator comp = term.getComparator();
		boolean isVar1 = exp1 instanceof Variable;
		boolean isVar2 = exp2 instanceof Variable;
		boolean isNull2 = exp2 instanceof NullExpression;
		
		if(comp == Comparator.NE) {
			if(isVar1 && isVar2) {
				// NEqTerm: what happens if x = 5?
				genNewObjectValuation((Variable)exp1);
				genNewObjectValuation((Variable)exp2);
			}
			if(isVar1 && isNull2) {
				// NEqNullTerm
				genNewObjectValuation((Variable)exp1);
			}
			return;
		}
		
		//EqTerm
		if(comp == Comparator.EQ && isVar1 && isVar2) {
			Variable var1 = (Variable) exp1;
			Variable var2 = (Variable) exp2;
			
			// TODO: re-factor
			boolean constains1 = initVars.contains(var1);
			boolean constains2 = initVars.contains(var2);
			
			if (!constains1 && constains2) {
				Type<?> type = getType(var1.getType());
				String name = var1.getName();
				Object value = valuation.getValue(var2.getName());
				
				ValuationEntry<?> e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
				valuation.addEntry(e);
				
				initVars.add(var1);
			}
			
			if (constains1 && !constains2) {
				Type<?> type = getType(var2.getType());
				String name = var2.getName();
				Object value = valuation.getValue(var1.getName());
				
				ValuationEntry<?> e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
				valuation.addEntry(e);
				
				initVars.add(var2);
			}
			
			if (!constains1 && !constains2) {
				genNewObjectValuation(var1);
				
				Type type = BuiltinTypes.REF;
				String name = var2.getName();
				Object value = valuation.getValue(var1.getName());
				
				ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
				valuation.addEntry(e);
				
				initVars.add(var1);
				initVars.add(var2);
			}
		}
	}

}
