package costar;

import java.util.ArrayList;
import java.util.List;

import costar.config.CoStarConfig;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.precondition.Precondition;
import starlib.precondition.PreconditionMap;

public class CoStarExplorer {
	
	private JPFLogger logger = JPF.getLogger("costar");

	private CoStarMethodExplorer analysis;

	private CoStarConfig cc;

	public boolean hasMoreChoices() {
		if (analysis == null)
			throw new IllegalStateException("CoStarExplorer asked for more choices, but no analysis is running");

		return analysis.hasMoreChoices();
	}

	public void newAnalysis(String id, StackFrame sf, MethodInfo mi) {
		String key = id.substring(id.lastIndexOf('.') + 1, id.indexOf('('));
		analysis = new CoStarMethodExplorer(cc, key, mi);
		
		Formula f = new Formula();
//		Precondition pre = PreconditionMap.find(mi.getName());
//		
//		if (pre != null) {
//			logger.info("Precondition = " + pre);	
//			f = pre.getFormula();
//		}
		
		analysis.getConstrainstTree().getCurrent().formula = f;

		ThreadInfo ti = VM.getVM().getCurrentThread();
		analysis.initializeMethod(ti, sf);

		analysis.makeCurrentAnalysis(ti);
	}

	public void newPath(StackFrame sf) {
		analysis.newPath(sf);
	}

	public void configure(CoStarConfig cc) {
		this.cc = cc;
	}

	boolean isConfigured() {
		return this.cc != null;
	}

}
