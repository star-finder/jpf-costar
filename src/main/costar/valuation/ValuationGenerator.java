package costar.valuation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.MethodInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.jpf.PathFinderUtils;
import starlib.solver.Model;

public class ValuationGenerator {
		
	private static ClassInfo ci;
	
	private static MethodInfo mi;
	
	private static boolean first = true;
		
	public static void setClassAndMethodInfo(ClassInfo ci, MethodInfo mi, Config conf) {
		if(first) {
			ValuationGenerator.ci = ci;
			ValuationGenerator.mi = mi;
			first = false;
		}
	}
	
	public static void reset() {
		first = true;
	}

	public static Valuation toValuation(String model) {
		Model m = new Model(model);
		return toValuation(m.getFormula(), m.getPure());
	}
	
	private static Valuation toValuation(Formula f, String pure) {
		String objName = "obj";
		String clsName = ci.getSimpleName();
		
		FieldInfo[] insFields = ci.getInstanceFields();
		FieldInfo[] staFields = ci.getDeclaredStaticFields();
		
		HashMap<String,String> knownTypeVars = PathFinderUtils.initTypeVarMap(ci,mi);
		
		f.updateType(knownTypeVars);
		f.removeTerm();
		
		if (pure.length() > 0) {
			String[] pureAssigns = pure.split(";");
			for (String pureAssign : pureAssigns) {
				pureAssign = pureAssign.replaceAll("\\(", "");
				pureAssign = pureAssign.replaceAll("\\)", "");
				
				String[] nameAndValue = pureAssign.split(",");
				String name = nameAndValue[0];
				String value = nameAndValue[1];
				
				for(Entry<String, String> entry : knownTypeVars.entrySet()) {
					Variable var = new Variable(entry.getKey(), entry.getValue());
					if (var.isPrim() && var.getName().equals(name)) {
						Expression exp1 = new Variable(name, var.getType());
						Expression exp2 = new LiteralExpression(value);
						f.addComparisonTerm(Comparator.EQ, exp1, exp2);
					}
				}
			}
		}
				
		HashSet<Variable> initVars = new HashSet<Variable>();
		
		for (FieldInfo field : insFields) {
			if (field.isFinal() || field.isPrivate() || field.isProtected()) {
				String name = "this_" + field.getName();
				String type = PathFinderUtils.toS2SATType(field.getType());
				
				initVars.add(new Variable(name, type));
			}
		}
		
		for (FieldInfo field : staFields) {
			if (field.isFinal() || field.isPrivate() || field.isProtected()) {
				String name = clsName + "_" + field.getName();
				String type = PathFinderUtils.toS2SATType(field.getType());
				
				initVars.add(new Variable(name, type));
			}
		}
		
		HashSet<Variable> formulaVars = new HashSet<Variable>();
		
		VarCollectVisitor varCollector = new VarCollectVisitor(formulaVars);
		varCollector.visit(f);
				
		java.util.Iterator<Variable> it = initVars.iterator();
		
		while (it.hasNext()) {
			Variable var = it.next();
			if (formulaVars.contains(var)) {
				it.remove();
			}
		}
		
		Valuation valuation = new Valuation();
		
		ValGenVisitor jpfGen = new ValGenVisitor(knownTypeVars, initVars, objName, clsName, insFields, staFields, valuation);
		jpfGen.visit(f);
		
		return valuation;
	}

}
