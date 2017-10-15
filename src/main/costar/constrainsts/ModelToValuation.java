package costar.constrainsts;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import starlib.formula.Formula;
import starlib.precondition.Precondition;
import starlib.precondition.PreconditionLexer;
import starlib.precondition.PreconditionParser;

public class ModelToValuation {

	public static Formula toValuation(String model) {
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
		
		return f;
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
