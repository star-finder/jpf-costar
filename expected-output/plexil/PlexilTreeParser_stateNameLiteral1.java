package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_stateNameLiteral1 extends TestJPF {

	@Test
	public void test_stateNameLiteral0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.stateNameLiteral(_t,parent);
	}


	@Test
	public void test_stateNameLiteral1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode stateNameLiteral_AST_in_3 = _t_1;
		plexil.PlexilASTNode __t436_4 = _t_1;
		plexil.PlexilASTNode tmp200_AST_in_5 = _t_1;
		plexil.PlexilASTNode paramAST_6 = _t_1;
		int ttype_11 = 161;
		int paramInt_7 = 161;
		plexil.PlexilASTNode right_13 = null;
		plexil.PlexilASTNode down_12 = null;
		_t.ttype = ttype_11;
		_t.down = down_12;
		_t.right = right_13;
		obj.stateNameLiteral(_t,parent);
	}

	@Test
	public void test_stateNameLiteral2() throws Exception {
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
		obj.stateNameLiteral(_t,parent);
	}

//	@Test
//	public void test_stateNameLiteral3() throws Exception {
//		PlexilTreeParser obj = new PlexilTreeParser();
//		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
//		obj.ASTNULL = new antlr.ASTNULLType();
//		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
//		plexil.PlexilASTNode _t_1 = _t;
//		net.n3.nanoxml.XMLElement parent_2 = parent;
//		plexil.PlexilASTNode stateNameLiteral_AST_in_3 = _t_1;
//		plexil.PlexilASTNode __t436_4 = _t_1;
//		plexil.PlexilASTNode tmp200_AST_in_5 = _t_1;
//		plexil.PlexilASTNode paramAST_6 = _t_1;
//		net.n3.nanoxml.XMLElement parent_10 = parent_2;
//		plexil.PlexilASTNode _t_9 = obj.ASTNULL;
//		int ttype_27 = 161;
//		int paramInt_7 = 161;
//		plexil.PlexilASTNode _t_8 = _t_9;
//		plexil.PlexilASTNode down_28 = _t_8;
//		plexil.PlexilASTNode right_29 = null;
//		_t.ttype = ttype_27;
//		_t.down = down_28;
//		_t.right = right_29;
//		obj.stateNameLiteral(_t,parent);
//	}

}

