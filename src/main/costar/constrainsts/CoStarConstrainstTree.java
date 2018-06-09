package costar.constrainsts;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import costar.CoStarMethodExplorer;
import costar.valuation.ValuationGenerator;
import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.precondition.Precondition;
import starlib.precondition.PreconditionMap;
import starlib.solver.Preprocessor;
import starlib.solver.Solver;

public class CoStarConstrainstTree {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	private CoStarNode root;
	
	private CoStarNode current;
			
	private Config config;
	
	private CoStarMethodExplorer explorer;
	
	private MethodInfo methodInfo;
	
	private Queue<String> initModels;
	
	private HashSet<String> models;
	
	private Stack<Formula> formulaStack;
	
	private Stack<Integer> indexStack;
	
	private StringBuilder currentSequence;
	
	private Stack<String> sequenceStack;
	
	private Set<String> executedSequences;
	
	private Set<String> invalidSequences;
			
	public CoStarConstrainstTree(CoStarMethodExplorer explorer, MethodInfo mi) {
		this.root = new CoStarNode(null, null, null, null, true);
		this.formulaStack = new Stack<Formula>();
		this.indexStack = new Stack<Integer>();
		
		this.sequenceStack = new Stack<String>();
		this.executedSequences = new HashSet<String>();
		this.invalidSequences = new HashSet<String>();
		
		this.current = root;
		this.currentSequence = new StringBuilder("");
		this.config = VM.getVM().getConfig();
		
		this.explorer = explorer;
		this.methodInfo = mi;
		
		ValuationGenerator.setClassAndMethodInfo(methodInfo.getClassInfo(), methodInfo, config);
		
		this.initModels = new LinkedList<String>();
		this.models = new HashSet<String>();
		
		try {
			FileHandler fh = new FileHandler("log.txt");
			logger.addHandler(fh);
			logger.setUseParentHandlers(false);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public CoStarNode getCurrent() {
		return current;
	}
	
	public StringBuilder getCurrentSequence() {
		return currentSequence;
	}
	
	public boolean addInitModel(String model) {
		return initModels.add(model);
	}
	
	public Queue<String> getInitModels() {
		return initModels;
	}
	
	public boolean addModel(String model){
		return models.add(model);
	}
	
	public HashSet<String> getModels(){
		return models;
	}

	public Valuation findNext() {
		boolean isInstrument = Boolean.parseBoolean(config.getProperty("costar.instrument", "false"));
		
		if (!initModels.isEmpty()) {
			if (isInstrument)
				executedSequences.add(new String(currentSequence));
			
			String model = initModels.poll();
			addModel(model);
			Valuation val = ValuationGenerator.toValuation(model);
			return val;
		}
		
		if (isInstrument)
			return findNextFromStack();
		else
			return findNextFromTree();		
	}
	
	public Valuation findNextFromTree() {
		Precondition pre = PreconditionMap.find(methodInfo.getName());
		Formula preF = new Formula();
		
		if (pre != null) {
			preF = pre.getFormula();
//			logger.info("Precondition = " + preF);
		}
		
		while (current != null) {
			if (current.childrend == null) {
				current = current.parent;
				continue;
			}
			
			for (int i = 0; i < current.childrend.length; i++) {
				if (!current.childrend[i].hasVisited) {
					current.childrend[i].hasVisited = true;
					
					Formula f = current.childrend[i].formula;
					logger.info("New constraint = " + f.toString());
					
//					Utilities.reset();
					boolean isSat = Solver.checkSat(Preprocessor.preprocess(preF, f));
					
					logger.info(isSat);
					
					if (isSat) {
						String model = Solver.getModel();
						addModel(model);
						Valuation val = ValuationGenerator.toValuation(model);
						
						// build new valuation based on the model
						logger.info("New model = " + model);
//						logger.info("New constraint = " + f.toString());
//						logger.info("New valuation = " + val);
						
						return val;
					} else {
						continue;
					}
				}	
			}
			
			current = current.parent;
		}
		
		return null;
	}
	
	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx, List<Formula> constraints) {		
//		System.out.println(constraints);
		
		if (current.childrend == null) {
			int length = constraints.size();
			current.childrend = new CoStarNode[length];
			
			for (int i = 0; i < length; i++) {
				current.childrend[i] = new CoStarNode(current, null, constraints.get(i), inst, false);
			}
		}
		
		current.childrend[chosenIdx].hasVisited = true;
		current = current.childrend[chosenIdx];
	}
	
	public void reset() {
		current = root;
		current.formula = new Formula();
		currentSequence = new StringBuilder("");
	}
	
	public void addToStack(Formula f, int index) {
		formulaStack.push(f);
		indexStack.push(index);
		sequenceStack.push(new String(currentSequence) + ";" + index);
	}
	
	public void addIndex(int index) {
		currentSequence.append(";" + index);
	}
	
	public boolean shouldExecute(String sequence) {
//		if (executedSequences.contains(sequence)) return false;
		
		for (String executedSequence : executedSequences) {
			if (executedSequence.startsWith(sequence)) return false;
		}
		
		for (String invalidSequence : invalidSequences) {
			if (sequence.startsWith(invalidSequence)) return false;
		}
		
		return true;
	}
	
	public Valuation findNextFromStack() {
		executedSequences.add(new String(currentSequence));
		
		Precondition pre = PreconditionMap.find(methodInfo.getName());
		Formula preF = new Formula();
		
		if (pre != null) {
			preF = pre.getFormula();
//			logger.info("Precondition = " + preF);
		}
		
		while (!formulaStack.isEmpty()) {
			Formula f = formulaStack.pop();
			int index = indexStack.pop();
			String sequence = sequenceStack.pop();
			
			logger.info("New constraint = " + f.toString());
			
			if (!shouldExecute(sequence)) continue;
			
//			Utilities.reset();
			boolean isSat = Solver.checkSat(Preprocessor.preprocess(preF, f));
			
			logger.info(isSat);
			
			if (isSat) {
				String model = Solver.getModel();
				addModel(model);
				Valuation val = ValuationGenerator.toValuation(model);
				
				// build new valuation based on the model
//				logger.info("New model = " + model);
//				logger.info("New constraint = " + f.toString());
//				logger.info("New valuation = " + val);
				
				return val;
			} else {
				invalidSequences.add(sequence);
				continue;
			}
		}
		
		return null;
	}

}
