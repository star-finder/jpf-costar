package costar.bytecode;

import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.jpf.NoErrorProperty;
import starlib.solver.Solver;

public class ATHROW extends gov.nasa.jpf.jvm.bytecode.ATHROW {
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		Config conf = ti.getVM().getConfig();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		if (Solver.checkSat(formulas, conf)) {
			VM vm = ti.getVM();
			vm.getSearch().error(new NoErrorProperty("Throw Exception"), vm.getClonedPath(), vm.getThreadList());
		}
		
		ti.getVM().getSystemState().setIgnored(true);
		return getNext(ti);
	}

}
