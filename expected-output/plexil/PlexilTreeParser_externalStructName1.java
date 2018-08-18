package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_externalStructName1 extends TestJPF {

	@Test
	public void test_externalStructName0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.externalStructName(_t);
	}


	@Test
	public void test_externalStructName1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode externalStructName_AST_in_2 = _t_1;
		plexil.PlexilASTNode tmp60_AST_in_3 = _t_1;
		plexil.PlexilASTNode paramAST_4 = _t_1;
		int ttype_9 = 111;
		int paramInt_5 = 111;
		plexil.PlexilASTNode right_11 = null;
		plexil.PlexilASTNode down_10 = null;
		_t.ttype = ttype_9;
		_t.down = down_10;
		_t.right = right_11;
		obj.externalStructName(_t);
	}

	@Test
	public void test_externalStructName2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.externalStructName(_t);
	}

}

