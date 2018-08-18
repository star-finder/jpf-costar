package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_nodeDeclaration1 extends TestJPF {

	@Test
	public void test_nodeDeclaration0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.nodeDeclaration(_t,node);
	}


	@Test
	public void test_nodeDeclaration1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement node_2 = node;
		plexil.PlexilASTNode nodeDeclaration_AST_in_3 = _t_1;
		plexil.PlexilASTNode _t_4 = _t_1;
		plexil.PlexilASTNode variableDeclaration_AST_in_5 = _t_4;
		plexil.PlexilASTNode __t99_6 = _t_4;
		plexil.PlexilASTNode tmp29_AST_in_7 = _t_4;
		plexil.PlexilASTNode paramAST_8 = _t_4;
		int paramInt_9 = 121;
		int ttype_15 = 121;
		plexil.PlexilASTNode _t_10 = new plexil.PlexilASTNode();
		plexil.PlexilASTNode down_16 = _t_10;
		plexil.PlexilASTNode right_17 = null;
		_t.ttype = ttype_15;
		_t.down = down_16;
		_t.right = right_17;
		obj.nodeDeclaration(_t,node);
	}

	@Test
	public void test_nodeDeclaration2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement node_2 = node;
		plexil.PlexilASTNode nodeDeclaration_AST_in_3 = _t_1;
		int ttype_14 = 32;
		plexil.PlexilASTNode right_16 = null;
		plexil.PlexilASTNode down_15 = null;
		_t.ttype = ttype_14;
		_t.down = down_15;
		_t.right = right_16;
		obj.nodeDeclaration(_t,node);
	}

	@Test
	public void test_nodeDeclaration3() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = null;
		obj.nodeDeclaration(_t,node);
	}

	@Test
	public void test_nodeDeclaration4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		int ttype_1 = 0;
		plexil.PlexilASTNode right_3 = null;
		plexil.PlexilASTNode down_2 = null;
		_t.ttype = ttype_1;
		_t.down = down_2;
		_t.right = right_3;
		obj.nodeDeclaration(_t,node);
	}

	@Test
	public void test_nodeDeclaration5() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement node_2 = node;
		plexil.PlexilASTNode nodeDeclaration_AST_in_3 = _t_1;
		plexil.PlexilASTNode _t_4 = _t_1;
		plexil.PlexilASTNode interfaceDeclaration_AST_in_5 = _t_4;
		plexil.PlexilASTNode _t_6 = _t_4;
		plexil.PlexilASTNode inOut_AST_in_7 = _t_6;
		plexil.PlexilASTNode __t94_9 = _t_6;
		plexil.PlexilASTNode tmp39_AST_in_10 = _t_6;
		plexil.PlexilASTNode paramAST_11 = _t_6;
		int ttype_21 = 32;
		int paramInt_12 = 32;
		plexil.PlexilASTNode _t_13 = new plexil.PlexilASTNode();
		plexil.PlexilASTNode down_22 = _t_13;
		plexil.PlexilASTNode right_23 = null;
		_t.ttype = ttype_21;
		_t.down = down_22;
		_t.right = right_23;
		obj.nodeDeclaration(_t,node);
	}

	@Test
	public void test_nodeDeclaration6() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement node_2 = node;
		plexil.PlexilASTNode nodeDeclaration_AST_in_3 = _t_1;
		int ttype_6 = 121;
		plexil.PlexilASTNode right_8 = null;
		plexil.PlexilASTNode down_7 = null;
		_t.ttype = ttype_6;
		_t.down = down_7;
		_t.right = right_8;
		obj.nodeDeclaration(_t,node);
	}

}

