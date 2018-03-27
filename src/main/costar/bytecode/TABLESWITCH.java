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
import starlib.formula.expression.BinaryExpression;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.Operator;

//how to handle instrumentation
public class TABLESWITCH extends gov.nasa.jpf.jvm.bytecode.TABLESWITCH
		implements gov.nasa.jpf.vm.bytecode.TableSwitchInstruction {

	public TABLESWITCH(int defaultTarget, int min, int max) {
		super(defaultTarget, min, max);
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
		
		for (int i = 0; i <= targets.length; i++) {
			Formula f = formula.copy();
			
			if (i == targets.length) {
				for (int j = 0; j < targets.length; j++) {
					f.addComparisonTerm(Comparator.NE,
							new BinaryExpression(Operator.MINUS, exp, new LiteralExpression(getMin())),
							new LiteralExpression(i));
				}
			} else {
				f.addComparisonTerm(Comparator.EQ,
						new BinaryExpression(Operator.MINUS, exp, new LiteralExpression(getMin())),
						new LiteralExpression(i));
			}
			
			constraints.add(f);
		}
		
		int v = sf.pop();
		
		for (int i = 0; i < targets.length; i++) {
			if (v - getMin() == i) {
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
