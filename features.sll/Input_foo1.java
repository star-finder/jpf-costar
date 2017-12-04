import org.junit.Test;
import gov.nasa.jpf.util.test.TestJPF;

public class Input_foo1 extends TestJPF {

	@Test
	public void test_foo1() throws Exception {
		Input obj = new Input();
		int i = -3;
		obj.foo(i);
	}

}

