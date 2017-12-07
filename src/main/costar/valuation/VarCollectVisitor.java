package costar.valuation;

import java.util.Arrays;
import java.util.HashSet;

import starlib.StarVisitor;
import starlib.formula.Formula;
import starlib.formula.HeapFormula;
import starlib.formula.PureFormula;
import starlib.formula.Variable;
import starlib.formula.expression.Expression;
import starlib.formula.heap.HeapTerm;
import starlib.formula.heap.PointToTerm;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.PureTerm;

public class VarCollectVisitor extends StarVisitor {
	
	private HashSet<Variable> formulaVars;
	
	public VarCollectVisitor(HashSet<Variable> formulaVars) {
		this.formulaVars = formulaVars;
	}

	@Override
	public void visit(Formula formula) {
		HeapFormula hf = formula.getHeapFormula();
		PureFormula pf = formula.getPureFormula();
		
		hf.accept(this);
		pf.accept(this);
	}
	
	@Override
	public void visit(HeapFormula formula) {
		for (HeapTerm heapTerm : formula.getHeapTerms()) {
			heapTerm.accept(this);
		}
	}
	
	@Override
	public void visit(PureFormula formula) {
		for (PureTerm pureTerm : formula.getPureTerms()) {
			pureTerm.accept(this);
		}
	}
	
	@Override
	public void visit(PointToTerm term) {
		formulaVars.addAll(Arrays.asList(term.getVars()));
	}

	@Override
	public void visit(ComparisonTerm term) {
		Expression e1 = term.getExp1();
		Expression e2 = term.getExp2();
		
		if (e1 instanceof Variable) formulaVars.add((Variable) e1);
		if (e2 instanceof Variable) formulaVars.add((Variable) e2);
	}

}
