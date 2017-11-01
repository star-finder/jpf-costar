package costar.valuation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.constraints.api.Valuation;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.FieldInfo;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.MethodInfo;
import starlib.formula.Formula;
import starlib.formula.Variable;
import starlib.formula.expression.Comparator;
import starlib.formula.expression.Expression;
import starlib.formula.expression.LiteralExpression;
import starlib.formula.expression.VariableExpression;
import starlib.jpf.PathFinderUtils;
import starlib.precondition.Precondition;
import starlib.precondition.PreconditionLexer;
import starlib.precondition.PreconditionParser;

public class ValuationGenerator {
		
	private static ClassInfo ci;
	
	private static MethodInfo mi;
	
	private static Config conf;
	
	private static boolean first = true;
	
	public static void setClassAndMethodInfo(ClassInfo ci, MethodInfo mi, Config conf) {
		if(first) {
			ValuationGenerator.ci = ci;
			ValuationGenerator.mi = mi;
			ValuationGenerator.conf = conf;
			first = false;
		}
	}
	
	public static void reset() {
		first = true;
	}

	public static Valuation toValuation(String model) {
		model = model.replaceAll("FLOAT 0.", "0");
		String[] tmp = model.split(";");

		model = tmp[0];
		String pure = tmp[1];

		if (pure.contains("Sat")) {
			pure = pure.substring(tmp[1].indexOf('[') + 1, tmp[1].length() - 1);
			pure = pure.replaceAll("\\),", ");");
		} else {
			pure = "";
		}

		model = standarizeModel(model);
		model = "pre temp == " + model;

		ANTLRInputStream in = new ANTLRInputStream(model);
		PreconditionLexer lexer = new PreconditionLexer(in);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		PreconditionParser parser = new PreconditionParser(tokens);

		Precondition[] ps = parser.pres().ps;
		Formula f = ps[0].getFormula();
		
		return toValuation(f, pure);
	}
	
	private static Valuation toValuation(Formula f, String pure) {
		String objName = "obj";
		String clsName = ci.getSimpleName();
		
		LocalVarInfo[] args = mi.getArgumentLocalVars();
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
						Expression exp1 = new VariableExpression(new Variable(name, var.getType()));
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
		
		Valuation valuation = new Valuation();
		
		ValGenVisitor jpfGen = new ValGenVisitor(knownTypeVars, initVars, objName, clsName, insFields, staFields, valuation);
		jpfGen.visit(f);
		
		return valuation;
	}

	private static String standarizeModel(String model) {
		String ret = model;

		ret = ret.substring(8, model.length());
		ret = ret.replaceAll("[\\[\\]]", "");

		if (ret.endsWith("@M")) {
			ret = ret.replaceAll("@M,", " *");
			ret = ret.replaceAll("@M", "");
		} else {
			ret = ret.replaceAll("@M,", " *");
			ret = ret.replaceAll("@M", " &");
		}

		return ret.substring(1);
	}

}
