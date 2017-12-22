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
import gov.nasa.jpf.vm.MJIEnv;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.data.DataNode;
import starlib.data.DataNodeMap;
import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.heap.HeapTerm;
import starlib.formula.heap.InductiveTerm;
import starlib.formula.heap.PointToTerm;
import starlib.jpf.PathFinderUtils;

public class GETFIELD extends gov.nasa.jpf.jvm.bytecode.GETFIELD {
	
	public GETFIELD(String fieldName, String classType, String fieldDescriptor) {
		super(fieldName, classType, fieldDescriptor);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);	
		
		StackFrame sf = ti.getModifiableTopFrame();
		
		int objRef = sf.peek(); // don't pop yet, we might re-enter
		lastThis = objRef;

		// --- check for obvious exceptions
		if (objRef == MJIEnv.NULL) {
			ti.getVM().getSystemState().setIgnored(true);
			return getNext(ti);
		}
		
		ElementInfo ei = ti.getModifiableElementInfo(objRef);
		FieldInfo fi = getFieldInfo();
		if (fi == null) {
			return ti.createAndThrowException("java.lang.NoSuchFieldError",
					"referencing field '" + fname + "' in " + ei);
		}

		Object sym_v = ei.getFieldAttr(fi);
		if (sym_v == null)
			return super.execute(ti);
		
		Variable fiVar = null;
		if (sym_v instanceof Expression<?>) {
			fiVar = new Variable(((Expression<?>)sym_v).toString(0));
			ei.setFieldAttr(fi, fiVar);
		}
		
		if (!fi.isReference())
			return super.execute(ti);
		
		if (fiVar == null)
			fiVar = (Variable) ei.getFieldAttr(fi);
		
		if (fiVar.getName().contains("newNode"))
			return super.execute(ti);
		
		int fiRef = ei.getReferenceField(fi);
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		Formula formula = current.formula;
		
		List<Formula> constraints = new ArrayList<Formula>();
		
		String typeOfLocalVar = fi.getType();
		DataNode dn = DataNodeMap.find(PathFinderUtils.toS2SATType(typeOfLocalVar));
		Variable[] fields = null;
		if(dn != null)
			fields = dn.getFields();
		
		Formula f = formula.copy();
		HeapTerm ht = Utilities.findHeapTerm(f, fiVar.getName());
		
		if (ht != null && ht instanceof InductiveTerm) {
			InductiveTerm it = (InductiveTerm) ht;
			Formula[] fs = it.unfold();
			
			for (int i = 0; i < fs.length; i++) {
				Formula cf = f.copy();
				cf.unfold(it, i);
				
				if (Utilities.isNull(cf,fiVar)) {
					constraints.add(cf);
				} else {
					PointToTerm pt = (PointToTerm) Utilities.findHeapTerm(cf, fiVar.getName());
					if (pt.getRoot().equals(fiVar))
						cf = cf.rename(fiVar, fields);
					
					constraints.add(cf);
				}
			}
		} else {
			constraints.add(f);
		}
		
		int index = -1;
		
		if (constraints.size() > 1) {
			ModelChecker mc = new ModelChecker();
			index = mc.getChosenIndex(constraints, analysis.getCurrValuation(), analysis.getValuationFormula());
			
			if (index == -1) {
				ti.getVM().getSystemState().setIgnored(true);
				return getNext(ti);
			}
		} else {
			index = 0;
		}
		
		if (constraints.size() > 1)
			analysis.decision(ti, this, index, constraints);
		
		Formula tmp = constraints.get(index);
		if (!Utilities.isNull(tmp, fiVar.getName())) {
			PointToTerm pt = (PointToTerm) Utilities.findHeapTerm(tmp, fiVar.getName());
			if (pt.getRoot().equals(fiVar)) {
				ElementInfo eei = ti.getModifiableElementInfo(fiRef);
				Variable[] vars = pt.getVarsNoRoot();
				
				for (int i = 0; i < vars.length; i++) {
					FieldInfo ffi = eei.getFieldInfo(i);
					eei.setFieldAttr(ffi, new Variable(vars[i].getName(), vars[i].getType()));
				}
			}	
		}
		
		return super.execute(ti);
	}
	
}
