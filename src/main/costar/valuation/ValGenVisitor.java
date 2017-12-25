package costar.valuation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import gov.nasa.jpf.JPF;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.constraints.api.ValuationEntry;
import gov.nasa.jpf.constraints.types.BuiltinTypes;
import gov.nasa.jpf.constraints.types.Type;
import gov.nasa.jpf.util.JPFLogger;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.ClassLoaderInfo;
import gov.nasa.jpf.vm.ElementInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.Heap;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import starlib.formula.Formula;
import starlib.formula.HeapFormula;
import starlib.formula.PureFormula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.NullExpression;
import starlib.formula.heap.HeapTerm;
import starlib.jpf.PathFinderUtils;
import starlib.jpf.testsuites.InitVarsVisitor;

public class ValGenVisitor extends InitVarsVisitor {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	protected Valuation valuation;
	
	protected Formula valFormula;
	
	public ValGenVisitor(HashMap<String,String> knownTypeVars, HashSet<Variable> initVars,
			String objName, String clsName, FieldInfo[] insFields, FieldInfo[] staFields,
			Valuation valuation, Formula valFormula) {
		super(knownTypeVars, initVars, objName, clsName, insFields, staFields);
		this.valuation = valuation;
		this.valFormula = valFormula;
	}
	
	public ValGenVisitor(ValGenVisitor that) {
		super(that);
		this.valuation = that.valuation;
		this.valFormula = that.valFormula;
	}
	
	@Override
	public void visit(Formula formula) {
//		logger.info("Formula to valuation = " + formula);
		HeapFormula hf = formula.getHeapFormula();
		PureFormula pf = formula.getPureFormula();
				
		ConValGenVisitor conVisitor = new ConValGenVisitor(this);
		NoConValGenVisitor noConVisitor = new NoConValGenVisitor(this);
		SetFieldValGenVisitor setFieldVisitor = new SetFieldValGenVisitor(this);
		
		hf.accept(conVisitor);
		pf.accept(conVisitor);
		pf.accept(noConVisitor);
		
		genDefaultVars();
		
		hf.accept(setFieldVisitor);
	}
	
	@Override
	public void visit(HeapFormula formula) {
		for (HeapTerm heapTerm : formula.getHeapTerms()) {
			heapTerm.accept(this);
		}
	}
	
	protected void genNewObjectValuation(Variable var) {
		if (!initVars.contains(var)) {
			initVars.add(var);
			
			Type type = BuiltinTypes.REF;
			String typeStr = var.getType();
			String name = var.getName();
			
			ClassInfo ci = ClassLoaderInfo.getCurrentResolvedClassInfo(typeStr);
			ThreadInfo ti = VM.getVM().getCurrentThread();
			Heap heap = ti.getHeap();
			ElementInfo ei = heap.newObject(ci, ti);
			
			Object value = new Integer(ei.getObjectRef());
			
			ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
			valuation.addEntry(e);
			
			HeapTerm ht = Utilities.findHeapTerm(valFormula, var.getName());
			if (ht == null) valFormula.addPointToTerm(var, PathFinderUtils.toS2SATType(typeStr));
		}
	}
	
	protected Type getType(String typeStr) {
		if (typeStr.equals("boolean")) {
			return BuiltinTypes.BOOL;
		} else if (typeStr.equals("byte")) {
			return BuiltinTypes.SINT8;
		} else if (typeStr.equals("char")) {
			return BuiltinTypes.UINT16;
		} else if (typeStr.equals("short")) {
			return BuiltinTypes.SINT16;
		} else if (typeStr.equals("int")) {
			return BuiltinTypes.SINT32;
		} else if (typeStr.equals("long")) {
			return BuiltinTypes.SINT64;
		} else if (typeStr.equals("float")) {
			return BuiltinTypes.FLOAT;
		} else if (typeStr.equals("double")) {
			return BuiltinTypes.DOUBLE;
		} else {
			// reference type
			return BuiltinTypes.REF;
		}
	}
	
	private void genDefaultVars() {
		if (knownTypeVars.size() == initVars.size())
			return;
		
		// for (Variable var : knownTypeVars) {
		for(Entry<String, String> entry : knownTypeVars.entrySet()) {
			String name = entry.getKey(); // name is key, type is value
			if (name.startsWith("Anon_")) continue;

			String type = entry.getValue();
			Variable var = new Variable(name, type);			
			if (!initVars.contains(var)) {
				Type builtinType = getType(type);
				
				ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(builtinType, name), builtinType.getDefaultValue());
				valuation.addEntry(e);
				
				if (builtinType == BuiltinTypes.REF) {
					valFormula.addComparisonTerm(Comparator.EQ, var, NullExpression.getInstance());
				} else {
					valFormula.addComparisonTerm(Comparator.EQ, var, new LiteralExpression(e.getValue().toString()));
				}
			}
		}
	}
	
}
