package costar.valuation;

import gov.nasa.jpf.constraints.api.ValuationEntry;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import gov.nasa.jpf.constraints.types.Type;
import starlib.formula.Variable;
import starlib.formula.pure.EqTerm;
import starlib.formula.pure.NEqNullTerm;
import starlib.formula.pure.NEqTerm;

public class NoConValGenVisitor extends ValGenVisitor {
	
	public NoConValGenVisitor(ValGenVisitor that) {
		super(that);
	}
	
	@Override
	public void visit(NEqNullTerm term) {
		genNewObjectValuation(term.getVar());
	}
	
	@Override
	public void visit(NEqTerm term) {
		genNewObjectValuation(term.getVar1());
		genNewObjectValuation(term.getVar2());
	}	

	@Override
	public void visit(EqTerm term) {
		super.visit(term);
		Variable var1 = term.getVar1();
		Variable var2 = term.getVar2();
		
		if (!initVars.contains(var1) && !initVars.contains(var2)) {
			initVars.add(var1);
			initVars.add(var2);
			
			genNewObjectValuation(var1);
			
			Type type = BuiltinTypes.SINT32;
			String name = var2.getName();
			Object value = valuation.getValue(var1.getName());
			
			ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
			valuation.addEntry(e);
		}
	}

}
