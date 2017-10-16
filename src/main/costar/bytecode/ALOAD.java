package costar.bytecode;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.jdart.ConcolicUtil;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.VariableExpression;

public class ALOAD extends gov.nasa.jpf.jvm.bytecode.ALOAD {
	
	private JPFLogger logger = JPF.getLogger("costar");

	public ALOAD(int index) {
		super(index);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);	
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		Expression<?> exp = (Expression<?>) sf.getLocalAttr(index);
		if (exp == null)
			return super.execute(ti);
		
		ConcolicUtil.Pair<Integer> v1 = ConcolicUtil.popInt(sf);
		
		Variable var = new Variable(exp.toString(0), "");
		
		Integer i1 = v1.conc;
		Formula[] constraints = new Formula[2];
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		if (current.formula == null) {
			constraints[0] = new Formula();
			constraints[1] = new Formula();
		}
		else {
			constraints[0] = current.formula.copy();
			constraints[1] = current.formula.copy();
		}
		
		constraints[0].addEqNullTerm(var);
		constraints[1].addNEqNullTerm(var);
		
		if (i1 == -1) {
			analysis.decision(ti, this, 0, constraints);
		} else {
			analysis.decision(ti, this, 1, constraints);
		}
		
		return super.execute(ti);
	}

}
