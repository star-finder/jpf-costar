package costar.constrainsts;

import java.util.List;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.FieldInfo;
import starlib.formula.Formula;
import starlib.formula.PureFormula;
import starlib.formula.Variable;
import starlib.jpf.testsuites.PathFinderVisitor;

public class PathFinderValuationGenerator extends PathFinderVisitor {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	private Valuation val;
	
	public PathFinderValuationGenerator(List<Variable> knownTypeVars, List<Variable> initVars, StringBuffer test,
			String objName, String clsName, FieldInfo[] insFields, FieldInfo[] staFields) {
		super(knownTypeVars, initVars, test, objName, clsName, insFields, staFields);
		val = new Valuation();
	}
	
	@Override
	public void visit(Formula formula) {
		logger.info("Formula to valuation = " + formula);
		
		ValuationVisitor visitor = new ValuationVisitor(this);
		PureFormula pf = formula.getPureFormula();
		
		pf.accept(visitor);
	} 

	public Valuation getValuation() {
		return val;
	}
	
}
