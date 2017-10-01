package costar;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.jdart.JDart;
import gov.nasa.jpf.jdart.config.ConcolicConfig;

public class CoStar extends JDart {

	public CoStar(Config conf) {
		super(conf);
	}

	public CoStar(Config conf, boolean init) {
		super(conf, new ConcolicConfig(conf), init);
	}

	public CoStar(Config conf, ConcolicConfig cc) {
		super(conf, cc, false);
	}

	public CoStar(ConcolicConfig cc) {
		super(cc);
	}

	public CoStar(Config conf, ConcolicConfig cc, boolean init) {
		super(conf, cc, init);
	}

	@Override
	public void start(String[] strings) {
		System.out.println("ConStar!!!");
		run();
	}

}
