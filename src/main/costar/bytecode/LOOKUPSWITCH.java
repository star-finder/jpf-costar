package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;

// how to handle instrumentation
public class LOOKUPSWITCH extends gov.nasa.jpf.jvm.bytecode.LOOKUPSWITCH
		implements gov.nasa.jpf.vm.bytecode.LookupSwitchInstruction {

	public LOOKUPSWITCH(int defaultTarget, int numberOfTargets) {
		super(defaultTarget, numberOfTargets);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);

		StackFrame sf = ti.getModifiableTopFrame();
		Expression exp = (Expression) sf.getOperandAttr();
		if (exp == null) {
			return super.execute(ti);
		}
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> constraints = new ArrayList<Formula>();
		
		Formula formula = current.formula;
		
		for (int i = 0; i <= matches.length; i++) {
			Formula f = formula.copy();
				
			if (i == matches.length) {
				for (int j = 0; j < matches.length; j++) {
					f.addComparisonTerm(Comparator.NE, exp, new LiteralExpression(matches[j]));
				}
			} else {
				f.addComparisonTerm(Comparator.EQ, exp, new LiteralExpression(matches[i]));
			}
				
			constraints.add(f);
		}
		
		int v = sf.pop();
		
		for (int i = 0; i < matches.length; i++) {
			if (v == matches[i]) {
				lastIdx = i;
				analysis.decision(ti, this, i, constraints);
				return mi.getInstructionAt(targets[i]);
			}
		}
		
		lastIdx = DEFAULT;
		analysis.decision(ti, this, matches.length, constraints);
		return mi.getInstructionAt(target);	
	}

}
