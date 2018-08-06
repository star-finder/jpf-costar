package plexil.parser;

import plexil.PlexilASTNode;
import plexil.PlexilTreeParser;

public class Driver {

	public static void main(String[] args) throws Exception {
		if (args.length < 1)
			return;
		
		PlexilTreeParser tree = new PlexilTreeParser();
		
		switch (args[0]) {
		case "booleanValue":
			PlexilASTNode tBV = new PlexilASTNode();
			tree.booleanValue(tBV);
			
			break;
		case "booleanTerm":
			PlexilASTNode tBT = new PlexilASTNode();
			tree.booleanTerm(tBT, null);
			
			break;
		case "booleanExpression":
			PlexilASTNode tBE = new PlexilASTNode();
			tree.booleanExpression(tBE, null);
			
			break;
		case "booleanComparison":
			PlexilASTNode tBC = new PlexilASTNode();
			tree.booleanComparison(tBC, null);
			
			break;
		case "not":
			PlexilASTNode tNot = new PlexilASTNode();
			tree.not(tNot, null);
			
			break;
		case "integerValue":
			PlexilASTNode tIV = new PlexilASTNode();
			tree.integerValue(tIV);
			
			break;
		case "realValue":
			PlexilASTNode tRV = new PlexilASTNode();
			tree.realValue(tRV);
			
			break;
		case "numericTerm":
			PlexilASTNode tNT = new PlexilASTNode();
			tree.numericTerm(tNT, null);
			
			break;
		case "numericExpression":
			PlexilASTNode tNE = new PlexilASTNode();
			tree.numericExpression(tNE, null);
			
			break;
		case "numericUnaryOperation":
			PlexilASTNode tNUO = new PlexilASTNode();
			tree.numericUnaryOperation(tNUO, null);
			
			break;
		case "absValue":
			PlexilASTNode tAV = new PlexilASTNode();
			tree.absValue(tAV, null);
			
			break;
		case "sqrt":
			PlexilASTNode tSQRT = new PlexilASTNode();
			tree.sqrt(tSQRT, null);
			
			break;
		case "add":
			PlexilASTNode tAdd = new PlexilASTNode();
			tree.add(tAdd, null);
			
			break;
		case "sub":
			PlexilASTNode tSub = new PlexilASTNode();
			tree.sub(tSub, null);
			
			break;
		case "mul":
			PlexilASTNode tMul = new PlexilASTNode();
			tree.mul(tMul, null);
			
			break;
		case "div":
			PlexilASTNode tDiv = new PlexilASTNode();
			tree.div(tDiv, null);
			
			break;
		case "stringValue":
			PlexilASTNode tSV = new PlexilASTNode();
			tree.stringValue(tSV);
			
			break;
		case "pointsTo":
			PlexilASTNode tPt = new PlexilASTNode();
			tree.pointsTo(tPt);
			
			break;
		case "booleanVariable":
			PlexilASTNode tBVar = new PlexilASTNode();
			tree.booleanVariable(tBVar, null);
			
			break;
		case "integerVariable":
			PlexilASTNode tIVar = new PlexilASTNode();
			tree.integerVariable(tIVar, null);
			
			break;
		case "realVariable":
			PlexilASTNode tRVar = new PlexilASTNode();
			tree.realVariable(tRVar, null);
			
			break;
		case "stringVariable":
			PlexilASTNode tSVar = new PlexilASTNode();
			tree.stringVariable(tSVar, null);
			
			break;
		case "arrayVariable":
			PlexilASTNode tAVar = new PlexilASTNode();
			tree.arrayVariable(tAVar);
			
			break;
		case "variableName":
			PlexilASTNode tVN = new PlexilASTNode();
			tree.variableName(tVN);
			
			break;
		default:
			// do nothing
		}
	}

}
