package costar;

import java.util.ArrayList;
import java.util.List;

import costar.config.CoStarConfig;
import costar.constrainsts.CoStarConstrainstTree;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.api.Variable;
import gov.nasa.jpf.constraints.types.Type;
import gov.nasa.jpf.jdart.ConcolicUtil;
import gov.nasa.jpf.jdart.SymbolicParam;
import gov.nasa.jpf.jdart.SymbolicVariable;
import gov.nasa.jpf.jdart.config.AnalysisConfig;
import gov.nasa.jpf.jdart.config.ConcolicMethodConfig;
import gov.nasa.jpf.jdart.config.ParamConfig;
import gov.nasa.jpf.jdart.objects.SymbolicObjectsContext;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.Types;

public class CoStarMethodExplorer {

	private JPFLogger logger = JPF.getLogger("costar");

	private AnalysisConfig anaConf;

	private SymbolicObjectsContext symContext;

	private CoStarConstrainstTree constraintsTree;

	private Valuation initValuation;

	private boolean nextValuation;

	private MethodInfo methodInfo;

	private ConcolicMethodConfig methodConfig;

	private Object[] initParams;

	public CoStarMethodExplorer(CoStarConfig cc, String id, MethodInfo mi) {
		this.methodInfo = mi;
		this.methodConfig = cc.getMethodConfig(id);
		this.anaConf = methodConfig.getAnalysisConfig();

		this.constraintsTree = new CoStarConstrainstTree();
	}

	public boolean hasMoreChoices() {
		if (initValuation == null) {
			return true;
		}

		if (!nextValuation)
			nextValuation = constraintsTree.findNext();
		return nextValuation;
	}

	public static CoStarMethodExplorer getCurrentAnalysis(ThreadInfo ti) {
		return ti.getAttr(CoStarMethodExplorer.class);
	}

	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx, String[] constraints) {
		constraintsTree.decision(ti, inst, chosenIdx, constraints);
	}

	public void newPath(StackFrame sf) {
		if (initValuation == null) {
			prepareFirstExecution(sf);
		} else {
			prepareReExecution(sf);
		}
	}

	private void prepareFirstExecution(StackFrame sf) {
		initValuation = new Valuation();
		constraintsTree.reset();
		for (SymbolicVariable<?> sv : symContext.getSymbolicVars())
			sv.readInitial(initValuation, sf);
	}

	private void prepareReExecution(StackFrame sf) {
		constraintsTree.reset();
		nextValuation = false;
//		for (SymbolicVariable<?> sv : symContext.getSymbolicVars())
//			sv.apply(currValuation, sf);
	}

	public void makeCurrentAnalysis(ThreadInfo ti) {
		ti.setAttr(this);
	}

	public void initializeMethod(ThreadInfo ti, StackFrame sf) {
		logger.info("Initializing concolic execution of " + methodInfo.getFullName());

		// mark root frame
		sf.setFrameAttr(RootFrame.getInstance());

		symContext = new SymbolicObjectsContext(ti.getHeap(), anaConf.getSymbolicFieldsExclude(),
				anaConf.getSymbolicFieldsInclude(), anaConf.getSpecialExclude());

		initializeSymbolicStatic(ti);
		initializeSymbolicParams(ti, sf);

		List<Variable<?>> vlist = new ArrayList<>();
		logger.info("Symbolic variables:");
		logger.info("===================");
		for (SymbolicVariable<?> var : symContext.getSymbolicVars()) {
			logger.info(var.getVariable().getName());
			vlist.add(var.getVariable());
		}
		logger.info();
	}

	private void initializeSymbolicStatic(ThreadInfo ti) {
		List<String> symbStatics = anaConf.getSymbolicStatics();
		for (String clazz : symbStatics) {
			ClassInfo ci = ClassInfo.getInitializedClassInfo(clazz, ti);
			ElementInfo ei = ci.getStaticElementInfo();
			symContext.processObject(ei, ci.getName());
		}
	}

	private void initializeSymbolicParams(ThreadInfo ti, StackFrame sf) {
		List<ParamConfig> pconfig = methodConfig.getParams();
		int argSize = pconfig.size();
		this.initParams = new Object[argSize];
		int stackIdx = methodInfo.getArgumentsSize();

		Heap heap = ti.getHeap();

		if (!methodInfo.isStatic()) {
			stackIdx--;
			int thisRef = sf.peek(stackIdx);
			ElementInfo thisEi = heap.get(thisRef);
			symContext.processObject(thisEi, "this", true);
		}

		byte[] argTypes = methodInfo.getArgumentTypes();

		for (int i = 0; i < argSize; i++) {
			ParamConfig pc = pconfig.get(i);
			String name = pc.getName();

			byte tc = argTypes[i];
			stackIdx--;
			if (tc == Types.T_LONG || tc == Types.T_DOUBLE)
				stackIdx--;

			this.initParams[i] = getVal(sf, stackIdx, tc);

			if (name == null)
				continue; // null name indicates non-symbolic param

			if (tc == Types.T_REFERENCE || tc == Types.T_ARRAY) {
				int ref = sf.peek(stackIdx);
				ElementInfo ei = heap.get(ref);
				if (ei != null)
					symContext.processObject(ei, name, true);
			} else { // primitive type
				Type<?> t = ConcolicUtil.forTypeCode(tc);
				Variable<?> var = Variable.create(t, name);
				SymbolicParam<?> sp = new SymbolicParam<>(var, stackIdx);
				symContext.addStackVar(sp);
			}
		}
	}

	private static Object getVal(StackFrame sf, int offset, byte type) {
		switch (type) {
		case Types.T_LONG:
			return sf.peekLong(offset);
		case Types.T_DOUBLE:
			return sf.peekDouble(offset);
		case Types.T_FLOAT:
			return sf.peekFloat(offset);
		case Types.T_INT:
		default:
			return sf.peek(offset);
		}
	}

}
