package plexilEqNull;

import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;
import plexil.PlexilTreeParser;

public class PlexilTreeParser_typeName1 extends TestJPF {

	@Test
	public void test_typeName1() throws Exception {
		PlexilTreeParser obj = new PlexilTreeParser();
		obj.ASTNULL = new antlr.ASTNULLType();
		antlr.collections.AST _t = obj.ASTNULL;
		obj.typeName(_t);
	}

}

