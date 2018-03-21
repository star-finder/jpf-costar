package costar.constrainsts;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

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
	
	private MethodInfo methodInfo;
	
	private HashSet<String> models;
		
	public CoStarConstrainstTree(MethodInfo mi) {
		this.root = new CoStarNode(null, null, null, null, true);
		this.current = root;
		this.config = VM.getVM().getConfig();
		this.methodInfo = mi;
		
		ValuationGenerator.setClassAndMethodInfo(methodInfo.getClassInfo(), methodInfo, config);
		
		this.models = new HashSet<String>();
		
		
		try {
			FileHandler fh = new FileHandler("/Users/HongLongPham/Workspace/JPF_HOME/jpf-costar/log.txt");
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
					logger.info("New constraint = " + f.toString());
					
					Precondition pre = PreconditionMap.find(methodInfo.getName());
					Formula preF = new Formula();
					
					if (pre != null) {
						preF = pre.getFormula();
//						logger.info("Precondition = " + preF);
					}
					
//					String s = "newNode_1->rbt_TreeMap__Entry(key_2,value_3,left_4,right_5,parent_6,color_7) & this_root != null & key >= this_root.key & key != this_root.key & this_root.right != null & key >= this_root.right.key & key != this_root.right.key & this_root.right.right = null & this_modCount := (this_modCount + 1) & this_size := (this_size + 1) & newNode_1.left := null & newNode_1.right := null & newNode_1.color := 1 & newNode_1.key := key & newNode_1.value := value & newNode_1.parent := this_root.right & this_root.right.right := newNode_1 & this_root.right.right.color := 0 & this_root.right.right != null & this_root.right.right != this_root & this_root.right.right.parent.color = 0 & this_root.right.right != null & this_root.right.right != null & this_root.right.right.parent != null & this_root.right.right.parent.parent != null & this_root.right.right.parent != this_root.right.right.parent.parent.left & this_root.right.right != null & this_root.right.right.parent != null & this_root.right.right.parent.parent != null & this_root.right.right.parent.parent.left = null & this_root.right.right != null & this_root.right.right.parent != null & this_root.right.right != this_root.right.right.parent.left & this_root.right.right != null & this_root.right.right.parent != null & this_root.right.right.parent.color := 1 & this_root.right.right != null & this_root.right.right.parent != null & this_root.right.right.parent.parent != null & this_root.right.right.parent.parent.color := 0 & this_root.right.right != null & this_root.right.right.parent != null & this_root.right.right.parent.parent != null & this_root.right.right != null & this_root.right.right.parent != null & this_root.right.right.parent.parent.right := this_root.right.right.parent.parent.right.left & this_root.right.right.parent.parent.right.left != null";
//					String s = "this_root != null & key >= this_root.key & key != this_root.key & this_root.right != null & key < this_root.right.key & this_root.right.left != null & key < this_root.right.left.key & this_root.right.left.left != null & key < this_root.right.left.left.key & this_root.right.left.left.left = null";
					String s = "this_root != null & key >= this_root.key & key != this_root.key & this_root.right != null & key < this_root.right.key & this_root.right.left != null & key < this_root.right.left.key & this_root.right.left.left != null & key < this_root.right.left.left.key & this_root.right.left.left.left = null";
					if (f.toString().contains(s)) {
						int ii = 0;
						ii++;
					}
					
					Utilities.reset();
					boolean isSat = Solver.checkSat(Preprocessor.preprocess(preF, f));
					
					logger.info(isSat);
					
					if (isSat) {
						String model = Solver.getModel();
						addModel(model);
						Valuation val = ValuationGenerator.toValuation(model);
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
	}

}
