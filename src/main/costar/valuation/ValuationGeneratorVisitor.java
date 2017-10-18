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
import starlib.StarVisitor;
import starlib.formula.Formula;
import starlib.formula.HeapFormula;
import starlib.formula.PureFormula;
import starlib.formula.Variable;
import starlib.formula.pure.PureTerm;
import starlib.jpf.PathFinderUtils;

public class ValuationGeneratorVisitor extends StarVisitor {
	
	private JPFLogger logger = JPF.getLogger("costar");
	
	protected HashMap<String,String> knownTypeVars;
	protected HashSet<Variable> initVars;
	protected String objName;
	protected String clsName;
	protected FieldInfo[] insFields;
	protected FieldInfo[] staFields;
	
	protected Valuation valuation;
	
	public ValuationGeneratorVisitor(HashMap<String,String> knownTypeVars, HashSet<Variable> initVars,
			String objName, String clsName, FieldInfo[] insFields, FieldInfo[] staFields) {
		this.knownTypeVars = knownTypeVars;
		this.initVars = initVars;
		this.objName = objName;
		this.clsName = clsName;
		this.insFields = insFields;
		this.staFields = staFields;
		this.valuation = new Valuation();
	}
	
	public ValuationGeneratorVisitor(ValuationGeneratorVisitor other) {
		this.knownTypeVars = other.knownTypeVars;
		this.initVars = other.initVars;
		this.objName = other.objName;
		this.clsName = other.clsName;
		this.insFields = other.insFields;
		this.staFields = other.staFields;
		this.valuation = other.valuation;
	}
	
	@Override
	public void visit(Formula formula) {
		logger.info("Formula to valuation = " + formula);
		HeapFormula hf = formula.getHeapFormula();
		PureFormula pf = formula.getPureFormula();
		
		ConcreteValuationGeneratorVisitor conVisitor = new ConcreteValuationGeneratorVisitor(this);
		NoConcreteValuationGeneratorVisitor noConVisitor = new NoConcreteValuationGeneratorVisitor(this);
		SetFieldValuationGeneratorVisitor setFieldVisitor = new SetFieldValuationGeneratorVisitor(this);
		
		hf.accept(conVisitor);
		pf.accept(conVisitor);
		pf.accept(noConVisitor);
		hf.accept(setFieldVisitor);
	}
	
	@Override
	public void visit(PureFormula formula) {
		int oldLength = initVars.size();
		while (true) {
			
			for (PureTerm pureTerm : formula.getPureTerms()) {
				pureTerm.accept(this);
			}
			
			int newLength = initVars.size();
			
			if (newLength == oldLength) break;
			else oldLength = newLength;
		}
	}
	
	protected void genNewObjectValuation(Variable var) {
		if (!initVars.contains(var)) {
			initVars.add(var);
			
			Type type = BuiltinTypes.SINT32;
			String typeStr = var.getType();
			typeStr = typeStr.replaceAll("__", "$");
			typeStr = typeStr.replaceAll("_", ".");
			String name = var.getName();
			
			ClassInfo ci = ClassLoaderInfo.getCurrentResolvedClassInfo(typeStr);
			ThreadInfo ti = VM.getVM().getCurrentThread();
			Heap heap = ti.getHeap();
			ElementInfo ei = heap.newObject(ci, ti);
			
			Object value = new Integer(ei.getObjectRef());
			
			ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), value);
			valuation.addEntry(e);
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
			return BuiltinTypes.SINT32;
		}
	}
	
	private void genDefaultVars() {
		if (knownTypeVars.size() == initVars.size())
			return;
		
		// for (Variable var : knownTypeVars) {
		for(Entry<String, String> entry : knownTypeVars.entrySet()) {
			String name = entry.getKey(); // name is key, type is value
			
			if (name.startsWith("Anon_")) continue;
			
			Type type = getType(entry.getValue());
			
			ValuationEntry e = new ValuationEntry(new gov.nasa.jpf.constraints.api.Variable(type, name), type.getDefaultValue());
			valuation.addEntry(e);
		}
	}
	
	public Valuation getValuation() {
		return valuation;
	}
	
}
