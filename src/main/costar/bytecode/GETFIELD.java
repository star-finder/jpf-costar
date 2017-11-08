package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
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

		if (!fi.isReference()) {
			return super.execute(ti);
		}
		
		Variable fiVar = (Variable) ei.getFieldAttr(fi);
		if (fiVar == null) {
			return super.execute(ti);
		}
		
		int fiRef = ei.getReferenceField(fi);
		
		CoStarConstrainstTree tree = analysis.getConstrainstTree();
		CoStarNode current = tree.getCurrent();
		
		List<Formula> formulas = current.formulas;
		
		List<List<Formula>> constraints = new ArrayList<List<Formula>>();
		constraints.add(new ArrayList<Formula>()); // null formulas
		constraints.add(new ArrayList<Formula>()); // not null formulas
		
		String typeOfLocalVar = fi.getType();
		DataNode dn = DataNodeMap.find(PathFinderUtils.toS2SATType(typeOfLocalVar));
		Variable[] fields = dn.getFields();
		
		for (Formula formula : formulas) {
			Formula f = formula.copy();
			
			if (f.isNull(fiVar.toString())) {
				constraints.get(0).add(f);
			} else {
				HeapTerm ht = Utilities.findHeapTerm(f, fiVar.getName());
				if (ht instanceof PointToTerm) {
					constraints.get(1).add(f.rename(fiVar, fields));
				} else if (ht instanceof InductiveTerm) {
					InductiveTerm it = (InductiveTerm) ht;
					Formula[] fs = it.unfold();
					
					for (int i = 0; i < fs.length; i++) {
						Formula cf = f.copy();
						cf.unfold(it, i);
						
						if (cf.isNull(fiVar.toString())) {
							constraints.get(0).add(cf);
						} else {
							constraints.get(1).add(cf.rename(fiVar, fields));
						}
					}
				}	
			}
		}
		
		if (!constraints.get(0).isEmpty() && !constraints.get(1).isEmpty()) {
			if (fiRef == 0) {
				analysis.decision(ti, this, 0, constraints);
			} else {
				ElementInfo fiInfo = VM.getVM().getHeap().getModifiable(fiRef);
				
				Formula f = constraints.get(1).get(0);
				HeapTerm ht = Utilities.findHeapTerm(f, fiVar.getName());
				
				Variable[] vars = ht.getVarsNoRoot();
				for (int i = 0; i < vars.length; i++) {
					FieldInfo ffi = fiInfo.getFieldInfo(i);
					fiInfo.setFieldAttr(ffi, vars[i]);
				}
				
				analysis.decision(ti, this, 1, constraints);
			}
		}
		
		return super.execute(ti);
	}
	
}
