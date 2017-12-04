package costar.bytecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import costar.model.ModelChecker;
import costar.model.OverApproximator;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
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
import starlib.jpf.PathFinderUtils;

public class ALOAD extends gov.nasa.jpf.jvm.bytecode.ALOAD {
	
	public ALOAD(int index) {
		super(index);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		Object sym_v = sf.getLocalAttr(index);
		if (sym_v == null)
			return super.execute(ti);
		
		Variable var = null;
		if (sym_v instanceof Expression<?>) {
			var = new Variable(((Expression<?>)sym_v).toString(0));
			sf.setLocalAttr(index, var);
		}
		
		if(var == null)
			var = (Variable) sf.getLocalAttr(index);
		
		if (var.getName().contains("newNode"))
			return super.execute(ti);
		
		int objRef = sf.getSlot(index);
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		
		String typeOfLocalVar = super.getLocalVariableType();
		DataNode dn = DataNodeMap.find(PathFinderUtils.toS2SATType(typeOfLocalVar));
		Variable[] fields = null;
		if(dn != null)
			fields = dn.getFields();
			
		HashMap<Formula, List<Formula>> overApproxFormulas = new HashMap<Formula, List<Formula>>();
		OverApproximator oa = new OverApproximator();
		
		for (Formula formula : formulas) {
			Formula f = formula.copy();
			
			if (Utilities.isNull(f, var.getName())) {
				oa.overApprox(overApproxFormulas, f);
			} else {
				HeapTerm ht = Utilities.findHeapTerm(f, var.getName());
				if (ht instanceof PointToTerm) {
					PointToTerm pt = (PointToTerm) ht;
					if (pt.getRoot().equals(var))
						f.rename(var, fields);
					
					oa.overApprox(overApproxFormulas, f);
				} else if (ht instanceof InductiveTerm) {
					InductiveTerm it = (InductiveTerm) ht;
					Formula[] fs = it.unfold();
					
					for (int i = 0; i < fs.length; i++) {
						Formula cf = f.copy();
						cf.unfold(it, i);
						
						if (Utilities.isNull(cf, var.getName())) {
							oa.overApprox(overApproxFormulas, cf);
						} else {
							PointToTerm pt = (PointToTerm) Utilities.findHeapTerm(cf, var.getName());
							if (pt.getRoot().equals(var))
								cf.rename(var, fields);
							
							oa.overApprox(overApproxFormulas, cf);
						}
					}
				}	
			}
		}
		
		int index = -1;
		
		if (overApproxFormulas.size() == 0) {
			return super.execute(ti);
		} else if (overApproxFormulas.size() == 1)
			index = 0;
		else {
			ModelChecker mc = new ModelChecker();
			index = mc.getChosenIndex(overApproxFormulas, analysis.getCurrValuation());
		}
		
		if (index == -1) {
			ti.getVM().getSystemState().setIgnored(true);
			return getNext(ti);
		}
		
		for (Formula of : overApproxFormulas.keySet()) {
			List<Formula> fs = overApproxFormulas.get(of);
			constraints.add(new ArrayList<Formula>(fs));
		}
		
		if (overApproxFormulas.size() > 1)
			analysis.decision(ti, this, index, constraints);
		
		Formula tmp = constraints.get(index).get(0);
		if (!Utilities.isNull(tmp, var.getName())) {
			PointToTerm pt = (PointToTerm) Utilities.findHeapTerm(tmp, var.getName());
			if (pt.getRoot().equals(var)) {
				ElementInfo ei = ti.getModifiableElementInfo(objRef);
				Variable[] vars = pt.getVarsNoRoot();
				
				for (int i = 0; i < vars.length; i++) {
					FieldInfo fi = ei.getFieldInfo(i);
					ei.setFieldAttr(fi, new Variable(vars[i].getName(), vars[i].getType()));
				}
			}	
		}
		
		return super.execute(ti);
	}

}
