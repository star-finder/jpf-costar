package features.sll;

public class Input {
	
	public void travel(Node root) {
		if (root == null) {
			System.out.println("root = null");
			return;
		}	
		else if (root.next == null ){
			System.out.println("root != null");
			System.out.println("root.next == null");
			return;
		} else {
			System.out.println("root != null");
			System.out.println("root.next != null");
			return;
		}
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
//		in.travel(root);
		
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