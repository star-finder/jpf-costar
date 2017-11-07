package costar;

import costar.testgeneration.TestGenerator;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.listener.Perturbator;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ThreadInfo;

public class CoStarListener extends Perturbator {

	private JPFLogger logger = JPF.getLogger("costar");

	public CoStarListener(Config conf) {
		super(conf);
	}
	
	@Override
	public void searchFinished(Search search) {
		ThreadInfo ti = search.getVM().getCurrentThread();
	    CoStarMethodExplorer ca = CoStarMethodExplorer.getCurrentAnalysis(ti);
	    TestGenerator.generateTestSuites(ca.getAllValuations());
	}

}
