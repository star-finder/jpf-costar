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
		Input in = new Input();
//		Node root = new Node(0, new Node(1, null));
		in.travel(null);
		
		in.foo(1);
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