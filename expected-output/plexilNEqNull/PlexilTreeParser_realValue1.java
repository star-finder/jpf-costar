package plexilNEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_realValue1 extends TestJPF {

	@Test
	public void test_realValue1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode realValue_AST_in_2 = _t_1;
		int ttype_56 = 108;
		plexil.PlexilASTNode right_58 = null;
		plexil.PlexilASTNode down_57 = null;
		_t.ttype = ttype_56;
		_t.down = down_57;
		_t.right = right_58;
		obj.realValue(_t);
	}

	@Test
	public void test_realValue2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.realValue(_t);
	}

	@Test
	public void test_realValue3() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode realValue_AST_in_2 = _t_1;
		int ttype_5 = 109;
		plexil.PlexilASTNode right_7 = null;
		plexil.PlexilASTNode down_6 = null;
		_t.ttype = ttype_5;
		_t.down = down_6;
		_t.right = right_7;
		obj.realValue(_t);
	}

	@Test
	public void test_realValue4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		antlr.collections.AST _t = null;
		obj.realValue(_t);
	}

}

