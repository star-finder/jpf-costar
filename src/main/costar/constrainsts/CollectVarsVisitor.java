package costar.constrainsts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import starlib.StarVisitor;
import starlib.formula.Formula;
import starlib.formula.PureFormula;
import starlib.formula.Variable;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.PureTerm;

public class CollectVarsVisitor extends StarVisitor {
	
	private Set<Variable> vars;
	
	private List<Variable> varsList;
	
	public CollectVarsVisitor(Set<Variable> vars) {
		this.vars = vars;
	}
	
	public CollectVarsVisitor(List<Variable> varsList) {
		this.varsList = varsList;
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
		if (vars != null) {
			Set<Variable> tmp = new HashSet<Variable>();
					
			tmp.addAll(term.getExp1().getVars());
			tmp.addAll(term.getExp2().getVars());
			
			Iterator<Variable> it = tmp.iterator();
			while (it.hasNext()) {
				Variable var = it.next();
				if (var.getName().contains(".") || var.getName().startsWith("this_")) {
					vars.add(var);
				}
			}
		} else if (varsList != null) {
			List<Variable> tmp = new ArrayList<Variable>();
			
			tmp.addAll(term.getExp2().getVarsList());
			tmp.addAll(term.getExp1().getVarsList());
					
			Iterator<Variable> it = tmp.iterator();
			while (it.hasNext()) {
				Variable var = it.next();
				if (var.getName().contains(".") || var.getName().startsWith("this_")) {
					varsList.add(var);
				}
			}
		}
	}

}
