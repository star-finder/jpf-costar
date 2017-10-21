package costar;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import costar.config.CoStarConfig;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.precondition.Precondition;
import starlib.precondition.PreconditionLexer;
import starlib.precondition.PreconditionParser;

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
		
		Config conf = VM.getVM().getConfig();
		String pre = conf.getProperty("costar.precondition");
		
		if (pre != null) {
			ANTLRInputStream in = new ANTLRInputStream(pre);
			PreconditionLexer lexer = new PreconditionLexer(in);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);
	        PreconditionParser parser = new PreconditionParser(tokens);
	        
	        Precondition[] ps = parser.pres().ps;
			
			logger.info("Precondition = " + ps[0].getFormula());
				
			Formula f = ps[0].getFormula();
			
			analysis.getConstrainstTree().getCurrent().formula = f;
			conf.setProperty("costar.precondition", null);
		}

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
