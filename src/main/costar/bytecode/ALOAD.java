package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.jdart.ConcolicUtil;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.heap.HeapTerm;
import starlib.formula.heap.InductiveTerm;
import starlib.formula.heap.PointToTerm;

public class ALOAD extends gov.nasa.jpf.jvm.bytecode.ALOAD {
	
	private JPFLogger logger = JPF.getLogger("costar");

	public ALOAD(int index) {
		super(index);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);	
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		Expression<?> exp = (Expression<?>) sf.getLocalAttr(index);
		if (exp == null)
			return super.execute(ti);
		
		ConcolicUtil.Pair<Integer> v1 = ConcolicUtil.popInt(sf);
		
		Variable var = new Variable(exp.toString(0), "");
		
		Integer i1 = v1.conc;
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula f = current.formula.copy();
			
		if (Utilities.isNull(f, var.getName())) {
			if (i1 != 0) {
				// throw error here
			} else {
				// no need to do anything
			}
		} else {
			HeapTerm ht = Utilities.findHeapTerm(f, var.getName());
			if (ht instanceof PointToTerm) {
				if (i1 == 0) {
					// throw error here
				} else {
					// no need to do anything
				}
			} else if (ht instanceof InductiveTerm) {
				InductiveTerm it = (InductiveTerm) ht;
				Formula[] fs = it.unfold();

				List<List<Formula>> constraints = new ArrayList<List<Formula>>();
				constraints.add(new ArrayList<Formula>()); // null formulas
				constraints.add(new ArrayList<Formula>()); // not null formulas
				
				for (int i = 0; i < fs.length; i++) {
					Formula cf = f.copy();
					cf.unfold(it, i);
					
					if (Utilities.isNull(cf, var.getName())) {
						// add to null
						constraints.get(0).add(cf);
					} else {
						// should be not null, add to not null
						constraints.get(1).add(cf);
					}
				}
				
				if (i1 == 0) {
					analysis.decision(ti, this, 0, constraints);
				} else {
					analysis.decision(ti, this, 1, constraints);
				}
			}	
		}
		
		return super.execute(ti);
	}

}
