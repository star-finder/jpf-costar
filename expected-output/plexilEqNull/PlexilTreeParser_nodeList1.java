package plexilEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_nodeList1 extends TestJPF {

	@Test
	public void test_nodeList1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		net.n3.nanoxml.XMLElement nodeBody = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.nodeList(_t,node,nodeBody);
	}

}

