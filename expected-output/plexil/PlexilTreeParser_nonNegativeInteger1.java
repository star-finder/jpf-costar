package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_nonNegativeInteger1 extends TestJPF {

	@Test
	public void test_nonNegativeInteger0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.nonNegativeInteger(_t);
	}


	@Test
	public void test_nonNegativeInteger1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.nonNegativeInteger(_t);
	}

	@Test
	public void test_nonNegativeInteger2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode nonNegativeInteger_AST_in_2 = _t_1;
		plexil.PlexilASTNode tmp36_AST_in_3 = _t_1;
		plexil.PlexilASTNode paramAST_4 = _t_1;
		int paramInt_5 = 108;
		int ttype_9 = 108;
		plexil.PlexilASTNode right_11 = null;
		plexil.PlexilASTNode down_10 = null;
		_t.ttype = ttype_9;
		_t.down = down_10;
		_t.right = right_11;
		obj.nonNegativeInteger(_t);
	}

}

