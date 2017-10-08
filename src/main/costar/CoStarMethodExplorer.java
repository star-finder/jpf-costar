package costar;

import costar.constrainsts.CoStarConstrainstTree;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;

public class CoStarMethodExplorer {

	CoStarConstrainstTree constraintsTree;

	boolean initValuation;

	boolean nextValuation;

	public CoStarMethodExplorer() {
		this.constraintsTree = new CoStarConstrainstTree();
	}

	public boolean hasMoreChoices() {
		if (!initValuation) {
			initValuation = true;
			return true;
		}

		if (!nextValuation)
			nextValuation = constraintsTree.findNext();
		return nextValuation;
	}

	public static CoStarMethodExplorer getCurrentAnalysis(ThreadInfo ti) {
		return ti.getAttr(CoStarMethodExplorer.class);
	}
	
	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx) {
		constraintsTree.decision(ti, inst, chosenIdx);
	}

}
