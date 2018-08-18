package plexilNEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_arrayAssignment1 extends TestJPF {

	@Test
	public void test_arrayAssignment1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode arrayAssignment_AST_in_3 = _t_1;
		plexil.PlexilASTNode __t240_5 = _t_1;
		plexil.PlexilASTNode tmp103_AST_in_6 = _t_1;
		plexil.PlexilASTNode paramAST_7 = _t_1;
		int ttype_19 = 125;
		int paramInt_8 = 125;
		plexil.PlexilASTNode _t_9 = new plexil.PlexilASTNode();
		plexil.PlexilASTNode down_20 = _t_9;
		plexil.PlexilASTNode var_10 = _t_9;
		plexil.PlexilASTNode _t_11 = _t_9;
		plexil.PlexilASTNode arrayVariable_AST_in_12 = _t_11;
		plexil.PlexilASTNode n_14 = _t_11;
		plexil.PlexilASTNode paramAST_15 = _t_11;
		plexil.PlexilASTNode right_21 = null;
		_t.ttype = ttype_19;
		_t.down = down_20;
		_t.right = right_21;
		obj.arrayAssignment(_t,parent);
	}

//	@Test
//	public void test_arrayAssignment2() throws Exception {
//		PlexilTreeParser obj = new PlexilTreeParser();
//		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
//		obj.ASTNULL = new antlr.ASTNULLType();
//		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
//		plexil.PlexilASTNode _t_1 = _t;
//		net.n3.nanoxml.XMLElement parent_2 = parent;
//		plexil.PlexilASTNode arrayAssignment_AST_in_3 = _t_1;
//		plexil.PlexilASTNode __t240_5 = _t_1;
//		plexil.PlexilASTNode tmp103_AST_in_6 = _t_1;
//		plexil.PlexilASTNode paramAST_7 = _t_1;
//		plexil.PlexilASTNode _t_9 = obj.ASTNULL;
//		int ttype_20 = 125;
//		int paramInt_8 = 125;
//		plexil.PlexilASTNode down_21 = _t_9;
//		plexil.PlexilASTNode right_22 = null;
//		_t.ttype = ttype_20;
//		_t.down = down_21;
//		_t.right = right_22;
//		obj.arrayAssignment(_t,parent);
//	}

	@Test
	public void test_arrayAssignment3() throws Exception {
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
		obj.arrayAssignment(_t,parent);
	}

	@Test
	public void test_arrayAssignment4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode arrayAssignment_AST_in_3 = _t_1;
		plexil.PlexilASTNode __t240_5 = _t_1;
		plexil.PlexilASTNode tmp103_AST_in_6 = _t_1;
		plexil.PlexilASTNode paramAST_7 = _t_1;
		int ttype_12 = 125;
		int paramInt_8 = 125;
		plexil.PlexilASTNode right_14 = null;
		plexil.PlexilASTNode down_13 = null;
		_t.ttype = ttype_12;
		_t.down = down_13;
		_t.right = right_14;
		obj.arrayAssignment(_t,parent);
	}

}

