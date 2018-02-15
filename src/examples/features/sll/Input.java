package features.sll;

public class Input {
	
	public Node x;
	
	public Node y;
	
	public void bar0(int n) {
		x.elem = 1;
		if (x.elem < 0) {
			return;
		} else {
			return;
		}
	}
	
	public void bar1(int n) {
		x.elem = x.elem + y.elem + n;
		if (x.elem == y.elem) {
			return;
		} else {
			return;
		}
	}
	
	public void bar2(int n) {
		x = new Node(0, null);
		if (x.elem < y.elem) {
			return;
		} else {
			return;
		}
	}
	
//	public void bar2(int n, Node x, Node y) {
//		Node z = x;
//		if (z.elem == y.elem) {
//			return;
//		} else {
//			return;
//		}
//	}
//	
//	public void bar3(int n, Node x, Node y) {
//		x.next = y;
//		x.elem = x.elem + x.next.elem + n;
//		if (x.elem == y.elem) {
//			return;
//		} else {
//			return;
//		}
//	}
//	
//	public void bar4(int n) {
//		x.next = y;
//		x.elem = x.elem + x.next.elem + n;
//		if (x.elem == y.elem) {
//			return;
//		} else {
//			return;
//		}
//	}
	
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
			if ("bar0".equals(str)) {
				in.x = new Node(2, null);
				in.y = in.x;
				in.bar0(1);
			}
			if ("bar1".equals(str)) {
				in.x = new Node(2, null);
				in.y = in.x;
				in.bar1(1);
			}
			if ("bar2".equals(str)) {
				in.x = new Node(2, null);
				in.y = in.x;
				in.bar2(1);
			}
//			if ("bar3".equals(str)) {
//				Node x = new Node(2, null);
//				Node y = x;
//				in.bar3(1, x, y);
//			}
//			if ("bar4".equals(str)) {
//				in.x = new Node(2, null);
//				in.y = in.x;
//				in.bar4(1);
//			}
		}
	}
	
}

class Node {
	
	int elem;
	
	Node next;
	
	public Node() {
		this(0, null);
	}
	
	public Node(int elem, Node next) {
		this.elem = elem;
		this.next = next;
	}
	
}