package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.jdart.ConcolicUtil;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.VariableExpression;

public class IFLE extends gov.nasa.jpf.jvm.bytecode.IFLE {

	private JPFLogger logger = JPF.getLogger("costar");

	public IFLE(int index) {
		super(index);
	}

	@Override
	public Instruction execute(ThreadInfo ti) {		
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);

		StackFrame sf = ti.getModifiableTopFrame();
		Expression<?> exp = (Expression<?>) sf.getOperandAttr();
		if (exp == null) {
			return super.execute(ti);
		}
	
		ConcolicUtil.Pair<Integer> v1 = ConcolicUtil.popInt(sf);
		
		Variable var = new Variable(exp.toString(0), "");
		VariableExpression varExp = new VariableExpression(var);
		LiteralExpression litExp = new LiteralExpression(0);
		
		Integer i1 = v1.conc;
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // <= formulas
		constraints.add(new ArrayList<Formula>()); // > formulas
		
		for (Formula formula : formulas) {
			Formula f0 = formula.copy();
			Formula f1 = formula.copy();
			
			f0.addComparisonTerm(Comparator.LE, varExp, litExp);
			f1.addComparisonTerm(Comparator.GT, varExp, litExp);
			
			constraints.get(0).add(f0);
			constraints.get(1).add(f1);
		}
		
		if (i1 <= 0) {
			analysis.decision(ti, this, 0, constraints);
			return getTarget();
		} else {
			analysis.decision(ti, this, 1, constraints);
			return getNext();
		}
	}

}
