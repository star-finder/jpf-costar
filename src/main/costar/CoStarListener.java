package costar;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.PropertyListenerAdapter;
import gov.nasa.jpf.listener.Perturbator;
import gov.nasa.jpf.report.ConsolePublisher;
import gov.nasa.jpf.report.Publisher;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.StackFrame;

public class CoStarListener extends Perturbator {

	private JPFLogger logger = JPF.getLogger("costar");

	public CoStarListener(Config conf) {
		super(conf);
	}

}
