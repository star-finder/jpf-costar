package costar.bytecode;

import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class ATHROW extends gov.nasa.jpf.jvm.bytecode.ATHROW {
	
	@Override
	public Instruction execute(ThreadInfo ti) {
//		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
//		
//		if (analysis == null)
//			return super.execute(ti);
//		
//		Config conf = ti.getVM().getConfig();
//		
//		CoStarConstrainstTree tree = analysis.getConstrainstTree();
//		CoStarNode current = tree.getCurrent();
//		
//		Formula formula = current.formula;
		
		// FIXME
		// Sang: I don't think we need to check sat here, since this is concolic
		// can we assume that the exception is always thrown?
//		if (Solver.checkSat(formulas)) {
//			VM vm = ti.getVM();
//			vm.getSearch().error(new NoErrorProperty("Throw Exception"), vm.getClonedPath(), vm.getThreadList());
//		}
		
		ti.getVM().getSystemState().setIgnored(true);
		return getNext(ti);
	}

}
