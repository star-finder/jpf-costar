package plexilNEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_nodeState1 extends TestJPF {

	@Test
	public void test_nodeState1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode nodeState_AST_in_3 = _t_1;
		int ttype_39 = 59;
		plexil.PlexilASTNode down_40 = null;
		plexil.PlexilASTNode right_41 = null;
		_t.ttype = ttype_39;
		_t.down = down_40;
		_t.right = right_41;
		obj.nodeState(_t,parent);
	}

	@Test
	public void test_nodeState2() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode nodeState_AST_in_3 = _t_1;
		int ttype_6 = 154;
		plexil.PlexilASTNode right_8 = null;
		plexil.PlexilASTNode down_7 = null;
		_t.ttype = ttype_6;
		_t.down = down_7;
		_t.right = right_8;
		obj.nodeState(_t,parent);
	}

	@Test
	public void test_nodeState3() throws Exception {
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
		obj.nodeState(_t,parent);
	}

	@Test
	public void test_nodeState4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = null;
		obj.nodeState(_t,parent);
	}

}

