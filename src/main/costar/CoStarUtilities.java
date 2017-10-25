package costar;

import starlib.formula.Formula;
import starlib.formula.Utilities;
import starlib.formula.Variable;
import starlib.formula.heap.HeapTerm;
import starlib.formula.heap.PointToTerm;

public class CoStarUtilities {
	
	public static String toS2SATType(String type) {
		if (type.contains("."))
			type = type.replaceAll("\\.", "_");
		
		if (type.contains("$"))
			type = type.replaceAll("$", "__");
		
		return type;
	}
	
	public static String toJavaType(String type) {
		if (type.contains("__"))
			type = type.replaceAll("__", "$$");
		
		if (type.contains("_"))
			type = type.replaceAll("_", ".");
		
		return type;
	}
	
	public static Formula rename(Variable var, Variable[] fields, Formula f) {
		HeapTerm ht = Utilities.findHeapTerm(f, var.getName());
		if (ht instanceof PointToTerm) {
			Variable[] fromVars = ((PointToTerm) ht).getVarsNoRoot();
			Variable[] toVars = new Variable[fromVars.length];
			
			for (int i = 0; i < fields.length; i++) {
				toVars[i] = new Variable(var.getName() + "_" + fields[i].getName(), "");
			}
			
			return f.substitute(fromVars, toVars, null);
		} else {
			return f;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(toS2SATType("features.sll.Node"));
		System.out.println(toJavaType("features_sll_Node"));
	}

}
