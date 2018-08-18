package plexilNEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_booleanValue1 extends TestJPF {

	@Test
	public void test_booleanValue1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode booleanValue_AST_in_2 = _t_1;
		plexil.PlexilASTNode i_3 = _t_1;
		int ttype_6 = 108;
		plexil.PlexilASTNode right_8 = null;
		plexil.PlexilASTNode down_7 = null;
		_t.ttype = ttype_6;
		_t.down = down_7;
		_t.right = right_8;
		obj.booleanValue(_t);
	}

	@Test
	public void test_booleanValue2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode booleanValue_AST_in_2 = _t_1;
		plexil.PlexilASTNode i_3 = _t_1;
		int ttype_8 = 40;
		plexil.PlexilASTNode right_10 = null;
		plexil.PlexilASTNode down_9 = null;
		_t.ttype = ttype_8;
		_t.down = down_9;
		_t.right = right_10;
		obj.booleanValue(_t);
	}

	@Test
	public void test_booleanValue3() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.booleanValue(_t);
	}

	@Test
	public void test_booleanValue4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode booleanValue_AST_in_2 = _t_1;
		plexil.PlexilASTNode i_3 = _t_1;
		int ttype_57 = 39;
		plexil.PlexilASTNode right_59 = null;
		plexil.PlexilASTNode down_58 = null;
		_t.ttype = ttype_57;
		_t.down = down_58;
		_t.right = right_59;
		obj.booleanValue(_t);
	}

	@Test
	public void test_booleanValue5() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		antlr.collections.AST _t = null;
		obj.booleanValue(_t);
	}

}

