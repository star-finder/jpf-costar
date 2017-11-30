package costar.model;

import java.util.HashMap;
import java.util.List;

import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.api.Variable;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.formula.PureFormula;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.PureTerm;
import starlib.solver.Solver;

public class ModelChecker {
	
	public int getChosenIndex(HashMap<Formula, List<Formula>> overApproxFormulas, Valuation currValuation) {
		Formula valF = new Formula();
		
		for (Variable<?> v : currValuation.getVariables()) {
			String value = currValuation.getValue(v).toString();
			valF.addComparisonTerm(Comparator.EQ, new starlib.formula.Variable(v.getName()), new LiteralExpression(value));
		}
		
		int i = 0;
		for (Formula of : overApproxFormulas.keySet()) {
			Formula tmp = of.copy();
			
			PureFormula pf = valF.getPureFormula();
			for (PureTerm pt : pf.getPureTerms()) {
				ComparisonTerm ct = (ComparisonTerm) pt;
				tmp.addComparisonTerm(ct.getComparator(), ct.getExp1(), ct.getExp2());
			}
			
			boolean isSat = Solver.checkSat(tmp, VM.getVM().getConfig());
			if (isSat) return i;
			
			i++;
		}
		
		return -1;
	}

}
