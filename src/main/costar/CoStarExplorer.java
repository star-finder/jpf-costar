package costar;

import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;

public class CoStarExplorer {

	private CoStarMethodExplorer analysis;

	public boolean hasMoreChoices() {
		if (analysis == null)
			throw new IllegalStateException("CoStarExplorer asked for more choices, but no analysis is running");

		return analysis.hasMoreChoices();
	}

	public void newAnalysis() {
		analysis = new CoStarMethodExplorer();
		
		ThreadInfo ti = VM.getVM().getCurrentThread();
		analysis.makeCurrentAnalysis(ti);
	}

	public void newPath(StackFrame sf) {
		analysis.newPath(sf);
	}

}
