package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
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
		
		// is pop here correct
//		ConcolicUtil.Pair<Integer> v = ConcolicUtil.popInt(sf);
		int objRef = sf.peek();
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // null formulas
		constraints.add(new ArrayList<Formula>()); // not null formulas
		
		String typeOfLocalVar = super.getLocalVariableType();
		DataNode dn = DataNodeMap.find(PathFinderUtils.toS2SATType(typeOfLocalVar));
		Variable[] fields = null;
		if(dn != null)
			fields = dn.getFields();
			
		// big bug
		for (Formula formula : formulas) {
			Formula f = formula.copy();
			
			if (Utilities.isNull(f, var.getName())) {
				constraints.get(0).add(f);
			} else {
				HeapTerm ht = Utilities.findHeapTerm(f, var.getName());
				if (ht instanceof PointToTerm) {
					constraints.get(1).add(f.rename(var, fields));
				} else if (ht instanceof InductiveTerm) {
					InductiveTerm it = (InductiveTerm) ht;
					Formula[] fs = it.unfold();
					
					for (int i = 0; i < fs.length; i++) {
						Formula cf = f.copy();
						cf.unfold(it, i);
						
						if (Utilities.isNull(cf, var.getName())) {
							constraints.get(0).add(cf);
						} else {
							constraints.get(1).add(cf.rename(var, fields));
						}
					}
				}	
			}
		}
		
		if (!constraints.get(0).isEmpty() && !constraints.get(1).isEmpty()) {
			if (objRef == 0) {
				analysis.decision(ti, this, 0, constraints);
			} else {
				ElementInfo ei = ti.getModifiableElementInfo(objRef);
				
				Formula f = constraints.get(1).get(0);
				HeapTerm ht = Utilities.findHeapTerm(f, var.getName());
				
				Variable[] vars = ht.getVarsNoRoot();
				for (int i = 0; i < vars.length; i++) {
					FieldInfo fi = ei.getFieldInfo(i);
					ei.setFieldAttr(fi, vars[i]);
				}
				
				analysis.decision(ti, this, 1, constraints);
			}
		}
		
		return super.execute(ti);
	}

}
