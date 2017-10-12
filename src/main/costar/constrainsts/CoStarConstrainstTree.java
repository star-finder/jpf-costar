package costar.constrainsts;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.solver.Solver;

public class CoStarConstrainstTree {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	private CoStarNode root;
	
	private CoStarNode current;
	
	private Solver solver;
	
	private Config config;
	
	public CoStarConstrainstTree() {
		this.root = new CoStarNode(null, null, null, null, true);
		this.current = root;
		this.solver = new Solver();
		this.config = VM.getVM().getConfig();
	}
	
	public CoStarNode getCurrent() {
		return current;
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
					
					Formula formula = current.childrend[i].formula;
					logger.info(current.childrend[i].formula);
					boolean isSat = solver.checkSat(formula, config);
					
					if (isSat) {
						Valuation newVal = new Valuation();
						
						String model = solver.getModel();
						// build new valuation based on the model
						logger.info(model);
						
						return newVal;
					} else {
						continue;
					}
				}	
			}
			
			current = current.parent;
		}
		
		return null;
	}

	public void decision(ThreadInfo ti, Instruction inst, int chosenIdx, Formula[] constraints) {
		if (current.childrend == null) {
			int length = constraints.length;
			current.childrend = new CoStarNode[length];
			
			for (int i = 0; i < length; i++) {
				current.childrend[i] = new CoStarNode(current, null, constraints[i], inst, false);
			}
			
			current.childrend[chosenIdx].hasVisited = true;
			current = current.childrend[chosenIdx];
		}
	}
	
	public void reset() {
		current = root;
	}

}
