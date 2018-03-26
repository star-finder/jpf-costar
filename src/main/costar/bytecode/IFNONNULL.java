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
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.NullExpression;

public class IFNONNULL extends gov.nasa.jpf.jvm.bytecode.IFNONNULL {
	
	public IFNONNULL(int targetPc) {
		super(targetPc);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		Config config = ti.getVM().getConfig();
		boolean isInstrument = Boolean.parseBoolean(config.getProperty("costar.instrument", "false"));
		
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v = sf.getOperandAttr();
		
		if(sym_v == null) {
			return super.execute(ti);
		} else if (sym_v.toString().contains("newNode_") || sym_v.toString().contains("$bitMap")) {
			return super.execute(ti);
		} else {
			int objRef = sf.pop();
			
			CoStarConstrainstTree tree = analysis.getConstrainstTree();
			CoStarNode current = tree.getCurrent();
			
			Formula formula = current.formula;
			
			List<Formula> constraints = new ArrayList<Formula>();
			
			Formula f0 = formula.copy();
			Formula f1 = formula.copy();
				
			f0.addComparisonTerm(Comparator.EQ, new Variable(sym_v.toString()), NullExpression.getInstance());
			f1.addComparisonTerm(Comparator.NE, new Variable(sym_v.toString()), NullExpression.getInstance());
				
			constraints.add(f0);
			constraints.add(f1);
			
			if (objRef != 0) {
				if (isInstrument && !IFInstrSymbHelper.isExecuted(ti, getNext(ti))) {
					tree.addToStack(f0);
				}
				
				analysis.decision(ti, this, 1, constraints);
				return getTarget();
			} else {
				if (isInstrument && !IFInstrSymbHelper.isExecuted(ti, getTarget())) {
					tree.addToStack(f1);
				}
				
				analysis.decision(ti, this, 0, constraints);
				return getNext(ti);
			}
		}
	}

}
