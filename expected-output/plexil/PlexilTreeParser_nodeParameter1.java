package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_nodeParameter1 extends TestJPF {

	@Test
	public void test_nodeParameter0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.nodeParameter(_t,parent);
	}


	@Test
	public void test_nodeParameter1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode nodeParameter_AST_in_3 = _t_1;
		plexil.PlexilASTNode vn_5 = _t_1;
		plexil.PlexilASTNode _t_6 = _t_1;
		plexil.PlexilASTNode variableName_AST_in_7 = _t_6;
		plexil.PlexilASTNode tmp53_AST_in_8 = _t_6;
		plexil.PlexilASTNode paramAST_9 = _t_6;
		int ttype_14 = 111;
		int paramInt_10 = 111;
		plexil.PlexilASTNode right_16 = null;
		plexil.PlexilASTNode down_15 = null;
		_t.ttype = ttype_14;
		_t.down = down_15;
		_t.right = right_16;
		obj.nodeParameter(_t,parent);
	}

	@Test
	public void test_nodeParameter2() throws Exception {
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
		obj.nodeParameter(_t,parent);
	}

}

