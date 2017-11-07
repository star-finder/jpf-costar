package costar.testgeneration;

import java.util.ArrayList;

import gov.nasa.jpf.constraints.api.Valuation;

public class TestGenerator {
	
	public static void generateTestSuites(ArrayList<Valuation> allValuations) {
		allValuations.forEach(valuation->{
			valuation.forEach(ve->{
				gov.nasa.jpf.constraints.api.Variable var = ve.getVariable();
				System.out.println("\n\n================ Test case");
				System.out.println(var.getType() + " " + var.getName() + " = " + ve.getValue().toString() );
			});
		});
	}

}
