package costar;

import costar.constrainsts.CoStarConstrainstTree;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.listener.Perturbator;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import star.testgeneration.TestGenerator;

public class CoStarListener extends Perturbator {
	
	private JPFLogger logger = JPF.getLogger("costar");

	private boolean first = true;

	public CoStarListener(Config conf) {
		super(conf);
	}
	
	@Override
	public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction,
			Instruction executedInstruction) {
		if (!vm.getSystemState().isIgnored()) {
			Config conf = vm.getConfig();
			if (first) {
				MethodInfo mi = executedInstruction.getMethodInfo();
				ClassInfo ci = mi.getClassInfo();
				if (ci != null) {
					CoStarMethodExplorer ca = CoStarMethodExplorer.getCurrentAnalysis(currentThread);
					if (ca == null)
						return;
					// if this is the concolic method
					if(mi.getFullName().equals(ca.getFullName())) {
						TestGenerator.setClassAndMethodInfo(ci, mi, conf);
						first = false;
					}
				}
			}
		}
	}
	
	@Override
	public void searchFinished(Search search) {
		ThreadInfo ti = search.getVM().getCurrentThread();
	    CoStarMethodExplorer ca = CoStarMethodExplorer.getCurrentAnalysis(ti);
	    if(ca == null)
	    	return;
	    CoStarConstrainstTree tree = ca.getConstrainstTree();
	    TestGenerator.addModels(tree.getModels());
	    TestGenerator.generateTests();
		logger.info("Test generation completed.");	
	}

}
