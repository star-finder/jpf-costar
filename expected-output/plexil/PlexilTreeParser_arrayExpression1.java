package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_arrayExpression1 extends TestJPF {

	@Test
	public void test_arrayExpression0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.arrayExpression(_t,parent);
	}


	@Test
	public void test_arrayExpression1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode arrayExpression_AST_in_3 = _t_1;
		plexil.PlexilASTNode _t_4 = _t_1;
		net.n3.nanoxml.XMLElement parent_5 = parent_2;
		plexil.PlexilASTNode lookupExpr_AST_in_6 = _t_4;
		int ttype_9 = 78;
		plexil.PlexilASTNode right_11 = null;
		plexil.PlexilASTNode down_10 = null;
		_t.ttype = ttype_9;
		_t.down = down_10;
		_t.right = right_11;
		obj.arrayExpression(_t,parent);
	}

	@Test
	public void test_arrayExpression2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode arrayExpression_AST_in_3 = _t_1;
		plexil.PlexilASTNode _t_4 = _t_1;
		net.n3.nanoxml.XMLElement parent_5 = parent_2;
		plexil.PlexilASTNode lookupExpr_AST_in_6 = _t_4;
		int ttype_20 = 77;
		plexil.PlexilASTNode right_22 = null;
		plexil.PlexilASTNode down_21 = null;
		_t.ttype = ttype_20;
		_t.down = down_21;
		_t.right = right_22;
		obj.arrayExpression(_t,parent);
	}

	@Test
	public void test_arrayExpression3() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode arrayExpression_AST_in_3 = _t_1;
		plexil.PlexilASTNode _t_4 = _t_1;
		net.n3.nanoxml.XMLElement parent_5 = parent_2;
		plexil.PlexilASTNode lookupExpr_AST_in_6 = _t_4;
		int ttype_22 = 6;
		plexil.PlexilASTNode right_24 = null;
		plexil.PlexilASTNode down_23 = null;
		_t.ttype = ttype_22;
		_t.down = down_23;
		_t.right = right_24;
		obj.arrayExpression(_t,parent);
	}

	@Test
	public void test_arrayExpression4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.arrayExpression(_t,parent);
	}

	@Test
	public void test_arrayExpression5() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = null;
		obj.arrayExpression(_t,parent);
	}

}

