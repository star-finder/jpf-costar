package costar.valuation;

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
import starlib.formula.pure.EqTerm;
import starlib.formula.pure.NEqNullTerm;
import starlib.formula.pure.NEqTerm;
import starlib.jpf.PathFinderUtils;

public class NoConcreteValuationGeneratorVisitor extends ValuationGeneratorVisitor {
	
	public NoConcreteValuationGeneratorVisitor(ValuationGeneratorVisitor that) {
		super(that);
	}
	
	@Override
	public void visit(NEqTerm term) {
		genNewObjectValuation(term.getVar1());
		genNewObjectValuation(term.getVar2());
	}	

	@Override
	public void visit(NEqNullTerm term) {
		genNewObjectValuation(term.getVar());
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
