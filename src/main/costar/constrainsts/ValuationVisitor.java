package costar.constrainsts;

import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.api.ValuationEntry;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import starlib.formula.pure.ComparisonTerm;
import starlib.jpf.testsuites.PathFinderVisitor;

public class ValuationVisitor extends PathFinderVisitor {

	private Valuation val;

	public ValuationVisitor(PathFinderVisitor that) {
		super(that);
		val = ((PathFinderValuationGenerator) that).getValuation();
	}

	@Override
	public void visit(ComparisonTerm term) {
		ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(BuiltinTypes.SINT32, "i"),
				new Integer(-5));
		val.addEntry(e);
	}

}
