package features.sll;

public class Input {
	
	public void travel(Node root) {
		if (root == null)
			return;
		else if (root.next == null)
			return;
		else
			return;
	}
	
	public void foo(int i) {
		if (i > 0)
			return;
		else
			return;
	}

	public static void main(String[] args) {
		Input in = new Input();
		Node root = new Node(0, null);
		in.travel(root);
		
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