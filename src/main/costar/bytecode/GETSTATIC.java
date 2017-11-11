package costar.bytecode;

import java.util.ArrayList;
import java.util.List;

import costar.CoStarMethodExplorer;
import costar.constrainsts.CoStarConstrainstTree;
import costar.constrainsts.CoStarNode;
import gov.nasa.jpf.JPFException;
import gov.nasa.jpf.constraints.api.Expression;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LoadOnJPFRequired;
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

public class GETSTATIC extends gov.nasa.jpf.jvm.bytecode.GETSTATIC {

	public GETSTATIC(String fieldName, String clsDescriptor, String fieldDescriptor) {
		super(fieldName, clsDescriptor, fieldDescriptor);
	}
	
	@Override
	public Instruction execute(ThreadInfo ti) {
		CoStarMethodExplorer analysis = CoStarMethodExplorer.getCurrentAnalysis(ti);
		
		if (analysis == null)
			return super.execute(ti);	
		
		FieldInfo fi;

		try {
			fi = getFieldInfo();
		} catch (LoadOnJPFRequired lre) {
			return ti.getPC();
		}

		if (fi == null) {
			return ti.createAndThrowException("java.lang.NoSuchFieldError",
					(className + '.' + fname));
		}
		
		ClassInfo ci = fi.getClassInfo();

		if (!mi.isClinit(ci) && ci.initializeClass(ti)) {
			return ti.getPC();
		}

		ElementInfo ei = ci.getModifiableStaticElementInfo();

		if (ei == null) {
			throw new JPFException("attempt to access field: " +
					fname + " of uninitialized class: " + ci.getName());
		}
		
		Object sym_v = ei.getFieldAttr(fi);
		if (sym_v == null)
			return super.execute(ti);
		
		if (sym_v instanceof Expression<?>) {
			Variable var = new Variable(((Expression<?>)sym_v).toString(0));
			ei.setFieldAttr(fi, var);
		}
		
		if (!fi.isReference()) {
			return super.execute(ti);
		}
		
		Variable fiVar = (Variable) ei.getFieldAttr(fi);
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
			
			if (Utilities.isNull(f,fiVar)) {
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
						
						if (Utilities.isNull(cf,fiVar)) {
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
