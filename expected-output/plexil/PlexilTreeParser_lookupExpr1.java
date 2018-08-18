package plexil;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_lookupExpr1 extends TestJPF {

	@Test
	public void test_lookupExpr0() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.lookupExpr(_t,parent);
	}


	@Test
	public void test_lookupExpr1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode lookupExpr_AST_in_3 = _t_1;
		int ttype_6 = 78;
		plexil.PlexilASTNode right_8 = null;
		plexil.PlexilASTNode down_7 = null;
		_t.ttype = ttype_6;
		_t.down = down_7;
		_t.right = right_8;
		obj.lookupExpr(_t,parent);
	}

	@Test
	public void test_lookupExpr2() throws Exception {
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
		obj.lookupExpr(_t,parent);
	}

	@Test
	public void test_lookupExpr3() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode lookupExpr_AST_in_3 = _t_1;
		int ttype_17 = 77;
		plexil.PlexilASTNode right_19 = null;
		plexil.PlexilASTNode down_18 = null;
		_t.ttype = ttype_17;
		_t.down = down_18;
		_t.right = right_19;
		obj.lookupExpr(_t,parent);
	}

	@Test
	public void test_lookupExpr4() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = null;
		obj.lookupExpr(_t,parent);
	}

	@Test
	public void test_lookupExpr5() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode lookupExpr_AST_in_3 = _t_1;
		int ttype_19 = 6;
		plexil.PlexilASTNode down_20 = null;
		plexil.PlexilASTNode right_21 = null;
		_t.ttype = ttype_19;
		_t.down = down_20;
		_t.right = right_21;
		obj.lookupExpr(_t,parent);
	}

}

