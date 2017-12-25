package costar.constrainsts;

import java.util.HashSet;
import java.util.List;

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
import starlib.solver.Solver;

public class CoStarConstrainstTree {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	private CoStarNode root;
	
	private CoStarNode current;
	
	private Formula valFormula;
		
	private Config config;
	
	private MethodInfo methodInfo;
	
	private HashSet<String> models;
		
	public CoStarConstrainstTree(MethodInfo mi) {
		this.root = new CoStarNode(null, null, null, null, true);
		this.current = root;
		this.config = VM.getVM().getConfig();
		this.methodInfo = mi;
		
		ValuationGenerator.setClassAndMethodInfo(methodInfo.getClassInfo(), methodInfo, config);
		
		this.models = new HashSet<String>();
	}
	
	public CoStarNode getCurrent() {
		return current;
	}
	
	public boolean addModel(String model){
		return models.add(model);
	}
	
	public HashSet<String> getModels(){
		return models;
	}

	public Valuation findNext() {
		while (current != null) {
			if (current.childrend == null) {
				current = current.parent;
				continue;
			}
			
			for (int i = 0; i < current.childrend.length; i++) {
				if (!current.childrend[i].hasVisited) {
					current.childrend[i].hasVisited = true;
					
					Formula f = current.childrend[i].formula;
//					logger.info("New constraint = " + fs.toString());
					boolean isSat = Solver.checkSat(f);
					
					if (isSat) {
						String model = Solver.getModel();
						addModel(model);
						Valuation val = ValuationGenerator.toValuation(model);
						valFormula = ValuationGenerator.getValuationFormula();
						// build new valuation based on the model
//						logger.info("New model = " + model);
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
	}
	
	public Formula getValuationFormula() {
		return valFormula;
	}

}
