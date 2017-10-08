package costar;

public class CoStarExplorer {

	private CoStarMethodExplorer analysis;

	public boolean hasMoreChoices() {
		if (analysis == null)
			throw new IllegalStateException("CoStarExplorer asked for more choices, but no analysis is running");

		return analysis.hasMoreChoices();
	}

	public void newAnalysis() {
		analysis = new CoStarMethodExplorer();
	}

}
