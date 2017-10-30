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
import starlib.formula.Variable;

public class IF_ACMPEQ extends gov.nasa.jpf.jvm.bytecode.IF_ACMPEQ {

	public IF_ACMPEQ(int targetPc) {
		super(targetPc);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		Object sym_v1 = sf.getOperandAttr(1);
		Object sym_v2 = sf.getOperandAttr(0);
		
		if (sym_v1 == null && sym_v2 == null) {
			return super.execute(ti);
		} else if (sym_v1.toString().contains("newNode_") || sym_v2.toString().contains("newNode_")) {
			return super.execute(ti);
		} else {
			int objRef1 = sf.pop();
			int objRef2 = sf.pop();
			
			CoStarConstrainstTree tree = analysis.getConstrainstTree();
			CoStarNode current = tree.getCurrent();
			
			List<Formula> formulas = current.formulas;
			
			List<List<Formula>> constraints = new ArrayList<List<Formula>>();
			constraints.add(new ArrayList<Formula>()); // eq formulas
			constraints.add(new ArrayList<Formula>()); // not eq formulas
			
			for (Formula formula : formulas) {
				Formula f0 = formula.copy();
				Formula f1 = formula.copy();
				
				f0.addEqTerm(new Variable(sym_v1.toString(), ""), new Variable(sym_v2.toString(), ""));
				f0.addNEqTerm(new Variable(sym_v1.toString(), ""), new Variable(sym_v2.toString(), ""));
				
				constraints.get(0).add(f0);
				constraints.get(1).add(f1);
			}
			
			if (objRef1 == objRef2) {
				analysis.decision(ti, this, 0, constraints);
				return getTarget();
			} else {
				analysis.decision(ti, this, 1, constraints);
				return getNext(ti);
			}
		}
		
	}

}
