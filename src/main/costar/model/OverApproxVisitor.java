package costar.model;

import java.util.HashSet;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.JPFLogger;
import starlib.StarVisitor;
import starlib.formula.Formula;
import starlib.formula.HeapFormula;
import starlib.formula.PureFormula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.NullExpression;
import starlib.formula.heap.HeapTerm;
import starlib.formula.heap.PointToTerm;
import starlib.formula.pure.ComparisonTerm;
import starlib.formula.pure.PureTerm;

public class OverApproxVisitor extends StarVisitor {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	private Formula result;
	
	public Formula getOverApproximationFormula() {
		return result;
	}
	
	@Override
	public void visit(Formula formula) {
//		logger.info("Formula to overapproximation = " + formula);
		
		result = new Formula();
		
		HeapFormula hf = formula.getHeapFormula();
		PureFormula pf = formula.getPureFormula();
		
		hf.accept(this);
		pf.accept(this);
		
		HashSet<Variable> roots = new HashSet<Variable>();
		for (HeapTerm heapTerm : hf.getHeapTerms()) {
			if (heapTerm instanceof PointToTerm) {
				roots.add(((PointToTerm) heapTerm).getRoot());
			}
		}
		
		addSeparationTerm(roots);
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
		Variable root = term.getRoot();
		result.addComparisonTerm(Comparator.NE, root, new LiteralExpression(0));
	}
	
	@Override
	public void visit(ComparisonTerm term) {
		Expression exp1 = term.getExp1();
		Expression exp2 = term.getExp2();
		Comparator comp = term.getComparator();
		
		if (exp2 instanceof NullExpression) {
			result.addComparisonTerm(comp, exp1, new LiteralExpression(0));
		} else {
			result.addComparisonTerm(comp, exp1, exp2);
		}
	}
	
	private void addSeparationTerm(HashSet<Variable> roots) {
		for (Variable root1 : roots) {
			for (Variable root2 : roots) {
				if (!root1.equals(root2)) {
					result.addComparisonTerm(Comparator.NE, root1, root2);
				}
			}
		}
	}

}
