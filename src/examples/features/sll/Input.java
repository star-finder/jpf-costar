package features.sll;

public class Input {
	
	public void travel(Node root) {
		while (root != null) {
			root = root.next;
		}
		
		return;
	}
	
	public void foo(int i) {
		System.out.println("Input i = " + i);
		
		if (i + 5 > 2) {
			return;
		}
		else {
			return;
		}
	}

	public static void main(String[] args) {
		if (args.length > 0) {
			Input in = new Input();
			String str = args[0];
			// method equals only works in JPF with string models.
			if ("travel".equals(str)) {
				in.travel(null);
			}
			if (args[0].equals("foo")) {
				in.foo(1);
			}
		}
	}
	
}

class Node {
	
	int elem;
	
	Node next;
	
	public Node(int elem, Node next) {
		this.elem = elem;
		this.next = next;
	}
	
}