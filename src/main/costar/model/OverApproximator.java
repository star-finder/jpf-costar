package costar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import starlib.formula.Formula;

public class OverApproximator {
	
	private OverApproxVisitor visitor = new OverApproxVisitor();
	
	public void overApprox(HashMap<Formula, List<Formula>> overApproximationFormulas, Formula f) {
		visitor.visit(f);
		Formula of = visitor.getOverApproximationFormula();
		
		if (overApproximationFormulas.containsKey(of)) {
			overApproximationFormulas.get(of).add(f);
		} else {
			List<Formula> list = new ArrayList<Formula>();
			list.add(f);
			overApproximationFormulas.put(of, list);
		}
	}

}
