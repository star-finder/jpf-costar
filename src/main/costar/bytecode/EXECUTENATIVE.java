package costar.bytecode;

import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.NativeMethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.jpf.NoErrorProperty;
import starlib.solver.Solver;

public class EXECUTENATIVE extends gov.nasa.jpf.jvm.bytecode.EXECUTENATIVE {

	public EXECUTENATIVE(NativeMethodInfo mi) {
		super(mi);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		if (mi.getClassName().equals("java.lang.Math")) {
			Config conf = ti.getVM().getConfig();
			
			CoStarConstrainstTree tree = analysis.getConstrainstTree();
			CoStarNode current = tree.getCurrent();
			
			List<Formula> formulas = current.formulas;
			
			// FIXME
			// Sang: I don't think we need to check sat here, since this is concolic
			// can we assume that the exception is always thrown?
			if (Solver.checkSat(formulas)) {
				VM vm = ti.getVM();
				vm.getSearch().error(new NoErrorProperty("Skip native method"), vm.getClonedPath(), vm.getThreadList());
			}
			
			ti.getVM().getSystemState().setIgnored(true);
			return getNext(ti);
		} else {
			return super.execute(ti);
		}
	}

}
