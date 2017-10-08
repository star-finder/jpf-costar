package costar;

import costar.constrainsts.CoStarConstrainstTree;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;

public class CoStarMethodExplorer {

	CoStarConstrainstTree constraintsTree;

	boolean initValuation;

	boolean nextValuation;

	public CoStarMethodExplorer() {
		this.constraintsTree = new CoStarConstrainstTree();
	}

	public boolean hasMoreChoices() {
		if (!initValuation) {
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
		if (!initValuation) {
			prepareFirstExecution(sf);
		} else {
			prepareReexecution(sf);
		}
	}
	
	private void prepareFirstExecution(StackFrame sf) {
		initValuation = true;
	}

	private void prepareReexecution(StackFrame sf) {
		nextValuation = false;
	}

	public void makeCurrentAnalysis(ThreadInfo ti) {
		ti.setAttr(this);
	}

}
