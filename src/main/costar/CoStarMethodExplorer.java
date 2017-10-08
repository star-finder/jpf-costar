package costar;

import costar.constrainsts.CoStarConstrainstTree;

public class CoStarMethodExplorer {

	CoStarConstrainstTree constraintsTree;
	
	boolean initValuation;
	
	boolean nextValuation;

	public boolean hasMoreChoices() {
		if (!initValuation) {
			initValuation = true;
			return true;
		}

		if (!nextValuation)
			nextValuation = constraintsTree.findNext();
		return nextValuation;
	}

}
