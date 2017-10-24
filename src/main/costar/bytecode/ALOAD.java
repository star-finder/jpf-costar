package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.CoStarUtilities;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.jdart.ConcolicUtil;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import starlib.data.DataNode;
import starlib.data.DataNodeMap;
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
		
		Object exp = sf.getLocalAttr(index);
		if (exp == null)
			return super.execute(ti);
		
		if (exp instanceof Expression<?>) {
			Variable var = new Variable(((Expression<?>)exp).toString(0), "");
			sf.setLocalAttr(index, var);
		}
		
		Variable var = (Variable) sf.getLocalAttr(index);
		
		ConcolicUtil.Pair<Integer> v1 = ConcolicUtil.popInt(sf);
		Integer i1 = v1.conc;
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // null formulas
		constraints.add(new ArrayList<Formula>()); // not null formulas
		
		String typeOfLocalVar = super.getLocalVariableType();
		DataNode dn = DataNodeMap.find(CoStarUtilities.toS2SATType(typeOfLocalVar));
		Variable[] fields = dn.getFields();
			
		for (Formula formula : formulas) {
			Formula f = formula.copy();
			
			if (Utilities.isNull(f, var.getName())) {
				constraints.get(0).add(f);
			} else {
				HeapTerm ht = Utilities.findHeapTerm(f, var.getName());
				if (ht instanceof PointToTerm) {
					constraints.get(1).add(rename(var, fields, f));
				} else if (ht instanceof InductiveTerm) {
					InductiveTerm it = (InductiveTerm) ht;
					Formula[] fs = it.unfold();
					
					for (int i = 0; i < fs.length; i++) {
						Formula cf = f.copy();
						cf.unfold(it, i);
						
						if (Utilities.isNull(cf, var.getName())) {
							constraints.get(0).add(cf);
						} else {
							constraints.get(1).add(rename(var, fields, cf));
						}
					}
				}	
			}
		}
		
		if (!constraints.get(0).isEmpty() && !constraints.get(1).isEmpty()) {
			if (i1 == 0) {
				analysis.decision(ti, this, 0, constraints);
			} else {
				analysis.decision(ti, this, 1, constraints);
			}
		}
		
		return super.execute(ti);
	}
	
	public Formula rename(Variable var, Variable[] fields, Formula f) {
		HeapTerm ht = Utilities.findHeapTerm(f, var.getName());
		if (ht instanceof PointToTerm) {
			Variable[] fromVars = ((PointToTerm) ht).getVarsNoRoot();
			Variable[] toVars = new Variable[fromVars.length];
			
			for (int i = 0; i < fields.length; i++) {
				toVars[i] = new Variable(var.getName() + "_" + fields[i].getName(), "");
			}
			
			return f.substitute(fromVars, toVars, null);
		} else {
			return f;
		}
	}

}
