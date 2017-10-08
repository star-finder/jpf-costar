package costar;

import gov.nasa.jpf.jdart.ConcolicMethodExplorer;
import gov.nasa.jpf.jdart.termination.TerminationStrategy;

public class CoStarExplorer {

	private CoStarMethodExplorer analysis;

	public boolean hasMoreChoices() {
		if (analysis == null)
			throw new IllegalStateException("ConcolicExplorer asked for more choices, but no analysis is running");

		return analysis.hasMoreChoices();
	}

}
