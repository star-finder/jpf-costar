package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_timeValue1 extends TestJPF {

	@Test
	public void test_timeValue1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode timeValue_AST_in_2 = _t_1;
		plexil.PlexilASTNode __t164_3 = _t_1;
		plexil.PlexilASTNode tmp67_AST_in_4 = _t_1;
		plexil.PlexilASTNode paramAST_5 = _t_1;
		int ttype_15 = 153;
		int paramInt_6 = 153;
		plexil.PlexilASTNode _t_7 = new plexil.PlexilASTNode();
		plexil.PlexilASTNode down_16 = _t_7;
		plexil.PlexilASTNode _t_8 = _t_7;
		plexil.PlexilASTNode integerValue_AST_in_9 = _t_8;
		plexil.PlexilASTNode tmp57_AST_in_10 = _t_8;
		plexil.PlexilASTNode paramAST_11 = _t_8;
		plexil.PlexilASTNode right_17 = null;
		_t.ttype = ttype_15;
		_t.down = down_16;
		_t.right = right_17;
		obj.timeValue(_t);
	}

//	@Test
//	public void test_timeValue2() throws Exception {
//		PlexilTreeParser obj = new PlexilTreeParser();
//		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
//		obj.ASTNULL = new antlr.ASTNULLType();
//		plexil.PlexilASTNode _t_1 = _t;
//		plexil.PlexilASTNode timeValue_AST_in_2 = _t_1;
//		plexil.PlexilASTNode __t164_3 = _t_1;
//		plexil.PlexilASTNode tmp67_AST_in_4 = _t_1;
//		plexil.PlexilASTNode paramAST_5 = _t_1;
//		plexil.PlexilASTNode _t_8 = obj.ASTNULL;
//		int ttype_16 = 153;
//		int paramInt_6 = 153;
//		plexil.PlexilASTNode _t_7 = _t_8;
//		plexil.PlexilASTNode down_17 = _t_7;
//		plexil.PlexilASTNode right_18 = null;
//		_t.ttype = ttype_16;
//		_t.down = down_17;
//		_t.right = right_18;
//		obj.timeValue(_t);
//	}

	@Test
	public void test_timeValue3() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.timeValue(_t);
	}

	@Test
	public void test_timeValue4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		plexil.PlexilASTNode _t_1 = _t;
		plexil.PlexilASTNode timeValue_AST_in_2 = _t_1;
		plexil.PlexilASTNode __t164_3 = _t_1;
		plexil.PlexilASTNode tmp67_AST_in_4 = _t_1;
		plexil.PlexilASTNode paramAST_5 = _t_1;
		int ttype_10 = 153;
		int paramInt_6 = 153;
		plexil.PlexilASTNode right_12 = null;
		plexil.PlexilASTNode down_11 = null;
		_t.ttype = ttype_10;
		_t.down = down_11;
		_t.right = right_12;
		obj.timeValue(_t);
	}

}

