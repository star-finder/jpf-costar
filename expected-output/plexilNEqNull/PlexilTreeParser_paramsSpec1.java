package plexilNEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_paramsSpec1 extends TestJPF {

	@Test
	public void test_paramsSpec1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode paramsSpec_AST_in_3 = _t_1;
		plexil.PlexilASTNode __t20_4 = _t_1;
		plexil.PlexilASTNode tmp10_AST_in_5 = _t_1;
		plexil.PlexilASTNode paramAST_6 = _t_1;
		int ttype_12 = 117;
		int paramInt_7 = 117;
		plexil.PlexilASTNode _t_8 = new plexil.PlexilASTNode();
		plexil.PlexilASTNode down_13 = _t_8;
		plexil.PlexilASTNode right_14 = null;
		_t.ttype = ttype_12;
		_t.down = down_13;
		_t.right = right_14;
		obj.paramsSpec(_t,parent);
	}

	@Test
	public void test_paramsSpec2() throws Exception {
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
		obj.paramsSpec(_t,parent);
	}

	@Test
	public void test_paramsSpec3() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode paramsSpec_AST_in_3 = _t_1;
		plexil.PlexilASTNode __t20_4 = _t_1;
		plexil.PlexilASTNode tmp10_AST_in_5 = _t_1;
		plexil.PlexilASTNode paramAST_6 = _t_1;
		int ttype_11 = 117;
		int paramInt_7 = 117;
		plexil.PlexilASTNode right_13 = null;
		plexil.PlexilASTNode down_12 = null;
		_t.ttype = ttype_11;
		_t.down = down_12;
		_t.right = right_13;
		obj.paramsSpec(_t,parent);
	}

}

