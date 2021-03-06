package plexil.parser2;

import plexil.PlexilTreeParser;

public class Driver {

	public static void main(String[] args) throws Exception {
		if (args.length < 1)
			return;
		
		PlexilTreeParser tree = new PlexilTreeParser();
		
		switch (args[0]) {
		case "absValue":
			tree.absValue(null, null);
			break;
		case "add":
			tree.add(null, null);
			break;
		case "argument":
			tree.argument(null, null);
			break;
		case "arrayAssignment":
			tree.arrayAssignment(null, null);
			break;
		case "arrayExpression":
			tree.arrayExpression(null, null);
			break;
		case "arrayRHS":
			tree.arrayRHS(null, null);
			break;
		case "arrayVariable":
			tree.arrayVariable(null);
			break;
		case "blobVariable":
			tree.blobVariable(null, null);
			break;
		case "booleanComparison":
			tree.booleanComparison(null, null);
			break;
		case "booleanValue":
			tree.booleanValue(null);
			break;
		case "booleanVariable":
			tree.booleanVariable(null, null);
			break;
		case "comment":
			tree.comment(null, null);
			break;
		case "comparison":
			tree.comparison(null, null);
			break;
		case "constAlias":
			tree.constAlias(null, null);
			break;
		case "div":
			tree.div(null, null);
			break;
		case "endCondition":
			tree.endCondition(null, null);
			break;
		case "externalStructName":
			tree.externalStructName(null);
			break;
		case "globalDeclaration":
			tree.globalDeclaration(null, null);
			break;
		case "ifBody":
			tree.ifBody(null, null);
			break;
		case "integerValue":
			tree.integerValue(null);
			break;
		case "integerVariable":
			tree.integerVariable(null, null);
			break;
		case "interfaceDeclaration":
			tree.interfaceDeclaration(null);
			break;
		case "invariantCondition":
			tree.invariantCondition(null,null);
			break;
		case "libraryNodeDeclaration":
			tree.libraryNodeDeclaration(null);
			break;
		case "libraryNodeIdRef":
			tree.libraryNodeIdRef(null, null);
			break;
		case "libraryParamSpec":
			tree.libraryParamSpec(null);
			break;
		case "lookupExpr":
			tree.lookupExpr(null, null);
			break;
		case "loopVariableDeclaration":
			tree.loopVariableDeclaration(null, null);
			break;
		case "messageReceivedExp":
			tree.messageReceivedExp(null, null);
			break;
		case "name":
			tree.name(null, null);
			break;
		case "nameExp":
			tree.nameExp(null, null);
			break;
		case "nameLiteral":
			tree.nameLiteral(null, null);
			break;
		case "nodeCommandHandle":
			tree.nodeCommandHandle(null, null);
			break;
		case "nodeCommandHandleValue":
			tree.nodeCommandHandleValue(null, null);
			break;
		case "nodeCommandHandleVariable":
			tree.nodeCommandHandleVariable(null, null);
			break;
		case "nodeDeclaration":
			tree.nodeDeclaration(null, null);
			break;
		case "nodeFailure":
			tree.nodeFailure(null, null);
			break;
		case "nodeFailureValue":
			tree.nodeFailureValue(null, null);
			break;
		case "nodeFailureVariable":
			tree.nodeFailureVariable(null, null);
			break;
		case "nodeIdRef":
			tree.nodeIdRef(null, null);
			break;
		case "nodeList":
			tree.nodeList(null, null, null);
			break;
		case "nodeNameRef":
			tree.nodeNameRef(null, null);
			break;
		case "nodeOutcome":
			tree.nodeOutcome(null, null);
			break;
		case "nodeOutcomeValue":
			tree.nodeOutcomeValue(null, null);
			break;
		case "nodeOutcomeVariable":
			tree.nodeOutcomeVariable(null, null);
			break;
		case "nodeParameter":
			tree.nodeParameter(null, null);
			break;
		case "nodeRef":
			tree.nodeRef(null, null);
			break;
		case "nodeState":
			tree.nodeState(null, null);
			break;
		case "nodeStatePredicateExp":
			tree.nodeStatePredicateExp(null, null);
			break;
		case "nodeStateValue":
			tree.nodeStateValue(null, null);
			break;
		case "nodeStateVariable":
			tree.nodeStateVariable(null, null);
			break;
		case "nodeTimepointValue":
			tree.nodeTimepointValue(null, null);
			break;
		case "nonNegativeInteger":
			tree.nonNegativeInteger(null);
			break;
		case "not":
			tree.not(null, null);
			break;
		case "numericRHS":
			tree.numericRHS(null, null);
			break;
		case "numericUnaryOperation":
			tree.numericUnaryOperation(null, null);
			break;
		case "onMessageBody":
			tree.onMessageBody(null, null);
			break;
		case "paramName":
			tree.paramName(null);
			break;
		case "paramsSpec":
			tree.paramsSpec(null, null);
			break;
		case "permissions":
			tree.permissions(null, null);
			break;
		case "pointerInitialValue":
			tree.pointerInitialValue(null);
			break;
		case "pointsTo":
			tree.pointsTo(null);
			break;
		case "postCondition":
			tree.postCondition(null, null);
			break;
		case "preCondition":
			tree.preCondition(null, null);
			break;
		case "realValue":
			tree.realValue(null);
			break;
		case "realVariable":
			tree.realVariable(null, null);
			break;
		case "repeatCondition":
			tree.repeatCondition(null, null);
			break;
		case "resourcePriority":
			tree.resourcePriority(null);
			break;
		case "skipCondition":
			tree.skipCondition(null, null);
			break;
		case "sqrt":
			tree.sqrt(null, null);
			break;
		case "startCondition":
			tree.startCondition(null, null);
			break;
		case "stateNameLiteral":
			tree.stateNameLiteral(null, null);
			break;
		case "stringExpression":
			tree.stringExpression(null, null);
			break;
		case "stringRHS":
			tree.stringRHS(null, null);
			break;
		case "stringValue":
			tree.stringValue(null);
			break;
		case "stringVariable":
			tree.stringVariable(null, null);
			break;
		case "sub":
			tree.sub(null, null);
			break;
		case "timeExpression":
			tree.timeExpression(null, null);
			break;
		case "timeRHS":
			tree.timeRHS(null, null);
			break;
		case "timeValue":
			tree.timeValue(null);
			break;
		case "timeVariable":
			tree.timeVariable(null, null);
			break;
		case "timepoint":
			tree.timepoint(null, null);
			break;
		case "tolerance":
			tree.tolerance(null, null);
			break;
		case "typeName":
			tree.typeName(null);
			break;
		case "varAlias":
			tree.varAlias(null, null);
			break;
		case "variable":
			tree.variable(null, null);
			break;
		case "variableName":
			tree.variableName(null);
			break;
		case "whileBody":
			tree.whileBody(null, null);
			break;
		default:
			// do nothing
		}
	}

}
