package costar;

import java.util.ArrayList;
import java.util.List;

import costar.config.AnalysisConfig;
import costar.config.CoStarConfig;
import costar.config.ConcolicMethodConfig;
import costar.config.ParamConfig;
import costar.constrainsts.CoStarConstrainstTree;
import costar.objects.SymbolicObjectsContext;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.api.Variable;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import gov.nasa.jpf.constraints.types.Type;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Fields;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.Types;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.formula.Utilities;

public class CoStarMethodExplorer {

	private JPFLogger logger = JPF.getLogger("costar");

	private AnalysisConfig anaConf;

	private SymbolicObjectsContext symContext;

	private CoStarConstrainstTree constraintsTree;

	private Valuation initValuation;
	
	private Valuation currValuation;

	private Valuation nextValuation;

	private MethodInfo methodInfo;

	private ConcolicMethodConfig methodConfig;

	private Object[] initParams;
	
//	private Map<String,String> nameMap;

	public CoStarMethodExplorer(CoStarConfig cc, String id, MethodInfo mi) {
		this.methodInfo = mi;
		this.methodConfig = cc.getMethodConfig(id);
		this.anaConf = methodConfig.getAnalysisConfig();

		this.constraintsTree = new CoStarConstrainstTree(mi);
//		this.nameMap = new HashMap<String,String>();
	}

	public boolean hasMoreChoices() {
		ClassInfo ciTop = VM.getVM().getCurrentThread().getTopFrame().getClassInfo();
	    ClassInfo ci = ciTop.resolveReferencedClass("avl.AvlTree");
	    FieldInfo fi = ci.getStaticField("$bitMap");
	    
	    ElementInfo ei = ci.getClassObject();
	    Fields fs = ei.getFields();
	    
	    System.out.println(ei);
		System.out.println(fi.getValueObject(fs));
		
		if (initValuation == null) {
			return true;
		}
		
		if (nextValuation == null)
			nextValuation = constraintsTree.findNext();
				
		return nextValuation != null;
	}

	public static CoStarMethodExplorer getCurrentAnalysis(ThreadInfo ti) {
		return ti.getAttr(CoStarMethodExplorer.class);
	}
	
	public Valuation getCurrValuation() {
		return currValuation;
	}
	
	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx, List<Formula> constraints) {
		constraintsTree.decision(ti, inst, chosenIdx, constraints);
	}

	public void newPath(StackFrame sf) {
		if (initValuation == null) {
			prepareFirstExecution(sf);
		} else {
			advanceValuation();
			prepareReExecution(sf);
		}
	}

	private void prepareFirstExecution(StackFrame sf) {
		initValuation = new Valuation();
		constraintsTree.reset();

		for (SymbolicVariable<?> sv : symContext.getSymbolicVars()) {
			if (sv.getVariable().getType() != null) {
				sv.readInitial(initValuation, sf);
			}
		}
		
		currValuation = initValuation;
	}

	public boolean advanceValuation() {
		if (nextValuation == null)
			nextValuation = constraintsTree.findNext();

//		if (nextValuation != null) {
//			for (Variable<?> v : currValuation.getVariables()) {
//				if (!nextValuation.containsValueFor(v)) {
//					nextValuation.addEntry(new ValuationEntry(v, nextValuation.getValue(v)));
//				}
//			}
//		}
		
		currValuation = nextValuation;
		nextValuation = null;

		return currValuation != null;
	}

	private void prepareReExecution(StackFrame sf) {
		constraintsTree.reset();
		Utilities.reset();
//		nameMap = new HashMap<String,String>();
		
		for (SymbolicVariable<?> sv : symContext.getSymbolicVars())
			sv.apply(currValuation, sf);
	}

	public void makeCurrentAnalysis(ThreadInfo ti) {
		ti.setAttr(this);
	}

	public void initializeMethod(ThreadInfo ti, StackFrame sf) {
		logger.info("Initializing concolic execution of " + methodInfo.getFullName());

		symContext = new SymbolicObjectsContext(ti.getHeap(), anaConf.getSymbolicFieldsExclude(),
				anaConf.getSymbolicFieldsInclude(), anaConf.getSpecialExclude());

		initializeSymbolicStatic(ti);
		initializeSymbolicParams(ti, sf);

		List<Variable<?>> vlist = new ArrayList<>();
//		logger.info("Symbolic variables:");
//		logger.info("===================");
//		for (SymbolicVariable<?> sv : symContext.getSymbolicVars()) {
//			logger.info(sv.getVariable().getName());
//			vlist.add(sv.getVariable());
//		}
//		logger.info();
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
//			symContext.processObject(thisEi, "this");
			
			int numOfFields = thisEi.getNumberOfFields();
			for (int i = 0; i < numOfFields; i++) {
				FieldInfo fi = thisEi.getFieldInfo(i);
				String name = "this_" + fi.getName();
				starlib.formula.Variable attr = new starlib.formula.Variable(name);
				thisEi.setFieldAttr(fi, attr);
				
				byte tc = fi.getTypeCode();
				Type<?> t = ConcolicUtil.forTypeCode(tc);
				
				Variable<?> var = Variable.create(t, name);
				SymbolicField<?> symf = new SymbolicField<>(var, thisEi, fi);
				symContext.addSymbolicVar(symf);
			}
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
//				if (ei != null)
//					symContext.processObject(ei, name);
				Variable<?> var = Variable.create(BuiltinTypes.REF, name);
				SymbolicParam<?> sp = new SymbolicParam<>(var, stackIdx);
				symContext.addSymbolicVar(sp);
			} else { // primitive type
				Type<?> t = ConcolicUtil.forTypeCode(tc);
				Variable<?> var = Variable.create(t, name);
				SymbolicParam<?> sp = new SymbolicParam<>(var, stackIdx);
				symContext.addSymbolicVar(sp);
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

	public CoStarConstrainstTree getConstrainstTree() {
		return constraintsTree;
	}

	public String getFullName() {
		return this.methodInfo.getFullName();
	}
	
//	public Map<String,String> getNameMap() {
//		return nameMap;
//	}

}
