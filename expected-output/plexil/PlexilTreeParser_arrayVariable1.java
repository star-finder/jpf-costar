package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_arrayVariable1 extends TestJPF {

	@Test
	public void test_arrayVariable0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.arrayVariable(_t);
	}


	@Test
	public void test_arrayVariable1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.arrayVariable(_t);
	}

	@Test
	public void test_arrayVariable2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode arrayVariable_AST_in_2 = _t_1;
		plexil.PlexilASTNode n_4 = _t_1;
		plexil.PlexilASTNode paramAST_5 = _t_1;
		int ttype_10 = 120;
		int paramInt_6 = 120;
		plexil.PlexilASTNode right_12 = null;
		plexil.PlexilASTNode down_11 = null;
		_t.ttype = ttype_10;
		_t.down = down_11;
		_t.right = right_12;
		obj.arrayVariable(_t);
	}

}

