package plexilNEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_endCondition1 extends TestJPF {

	@Test
	public void test_endCondition1() throws Exception {
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
		obj.endCondition(_t,node);
	}

}

