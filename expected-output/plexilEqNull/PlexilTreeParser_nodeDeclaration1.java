package plexilEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_nodeDeclaration1 extends TestJPF {

	@Test
	public void test_nodeDeclaration1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		net.n3.nanoxml.XMLElement node = new net.n3.nanoxml.XMLElement();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.nodeDeclaration(_t,node);
	}

}

