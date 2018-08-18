package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.Config;
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
		
		Config config = ti.getVM().getConfig();
		boolean isInstrument = Boolean.parseBoolean(config.getProperty("costar.instrument", "false"));
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> constraints = new ArrayList<Formula>();
		
		Formula formula = current.formula;
		
		int[] indexes = new int[matches.length + 1];
		
		if (isInstrument) {
			for (int i = 0; i <= matches.length; i++) {
				if (i == matches.length) {
					int index = IFInstrHelper.getIndex(ti, mi.getInstructionAt(target));
					indexes[i] = index;
				} else {
					int index = IFInstrHelper.getIndex(ti, mi.getInstructionAt(targets[i]));
					indexes[i] = index;
				}
			}
		}
		
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
				if (isInstrument) {
					for (int j = 0; j <= matches.length; j++) {
						if (j != i) {
							int index = indexes[j];
							Formula f = constraints.get(j);
							if (index >= 0) tree.addToStack(f, index);
						}
					}
				}
				
				lastIdx = i;
				analysis.decision(ti, this, i, constraints);
				return mi.getInstructionAt(targets[i]);
			}
		}
		
		if (isInstrument) {
			for (int j = 0; j < matches.length; j++) {
				int index = indexes[j];
				Formula f = constraints.get(j);
				if (index >= 0) tree.addToStack(f, index);
			}
		}
		
		lastIdx = DEFAULT;
		analysis.decision(ti, this, matches.length, constraints);
		return mi.getInstructionAt(target);	
	}

}
