package costar.constrainsts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import starlib.StarVisitor;
import starlib.formula.Formula;
import starlib.formula.PureFormula;
import starlib.formula.Variable;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.PureTerm;

public class CollectVarsVisitor extends StarVisitor {
		
	private List<Variable> vars;
	
	public CollectVarsVisitor(List<Variable> vars) {
		this.vars = vars;
	}
	
	@Override
	public void visit(Formula formula) {
		PureFormula pf = formula.getPureFormula();
		pf.accept(this);
	}
	
	@Override
	public void visit(PureFormula formula) {
		for (PureTerm pt : formula.getPureTerms()) {
			pt.accept(this);
		}
	}
	
	@Override 
	public void visit(ComparisonTerm term) {
		List<Variable> tmp = new ArrayList<Variable>();
			
		tmp.addAll(term.getExp2().getVarsList());
		tmp.addAll(term.getExp1().getVarsList());
					
		Iterator<Variable> it = tmp.iterator();
		while (it.hasNext()) {
			Variable var = it.next();
			vars.add(var);
		}
	}

}
