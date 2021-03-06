package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_nodeNameRef1 extends TestJPF {

	@Test
	public void test_nodeNameRef0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.nodeNameRef(_t,parent);
	}


	@Test
	public void test_nodeNameRef1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode nodeNameRef_AST_in_3 = _t_1;
		plexil.PlexilASTNode n_5 = _t_1;
		plexil.PlexilASTNode paramAST_6 = _t_1;
		int ttype_11 = 112;
		int paramInt_7 = 112;
		plexil.PlexilASTNode right_13 = null;
		plexil.PlexilASTNode down_12 = null;
		_t.ttype = ttype_11;
		_t.down = down_12;
		_t.right = right_13;
		obj.nodeNameRef(_t,parent);
	}

	@Test
	public void test_nodeNameRef2() throws Exception {
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
		obj.nodeNameRef(_t,parent);
	}

}

