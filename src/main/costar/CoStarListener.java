package costar;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.listener.Perturbator;
import gov.nasa.jpf.util.JPFLogger;

public class CoStarListener extends Perturbator {

	private JPFLogger logger = JPF.getLogger("costar");

	public CoStarListener(Config conf) {
		super(conf);
	}

}
