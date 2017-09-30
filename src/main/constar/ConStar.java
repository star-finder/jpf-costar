package constar;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.jdart.JDart;
import gov.nasa.jpf.jdart.config.ConcolicConfig;

public class ConStar extends JDart {

	public ConStar(Config conf) {
		super(conf);
	}

	public ConStar(Config conf, boolean init) {
		super(conf, new ConcolicConfig(conf), init);
	}

	public ConStar(Config conf, ConcolicConfig cc) {
		super(conf, cc, false);
	}

	public ConStar(ConcolicConfig cc) {
		super(cc);
	}

	public ConStar(Config conf, ConcolicConfig cc, boolean init) {
		super(conf, cc, init);
	}

	@Override
	public void start(String[] strings) {
		System.out.println("ConStar!!!");
		run();
	}

}
