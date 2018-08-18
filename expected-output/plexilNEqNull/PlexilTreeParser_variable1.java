package plexilNEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_variable1 extends TestJPF {

	@Test
	public void test_variable1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		plexil.PlexilASTNode _t = new plexil.PlexilASTNode();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement parent = new net.n3.nanoxml.XMLElement();
		plexil.PlexilASTNode _t_1 = _t;
		net.n3.nanoxml.XMLElement parent_2 = parent;
		plexil.PlexilASTNode variable_AST_in_3 = _t_1;
		plexil.PlexilASTNode tmp69_AST_in_4 = _t_1;
		plexil.PlexilASTNode paramAST_5 = _t_1;
		int ttype_10 = 120;
		int paramInt_6 = 120;
		plexil.PlexilASTNode right_12 = null;
		plexil.PlexilASTNode down_11 = null;
		_t.ttype = ttype_10;
		_t.down = down_11;
		_t.right = right_12;
		obj.variable(_t,parent);
	}

	@Test
	public void test_variable2() throws Exception {
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
		obj.variable(_t,parent);
	}

}

