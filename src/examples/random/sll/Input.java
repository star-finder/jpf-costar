package random.sll;

public class Input {
	
	public boolean isPrime(int n) {
		if (n < 2) return false;
		
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		
		return true;
	}
	
	public boolean isContainPrime(Node root) {
		while (root != null) {
			if (isPrime(root.elem)) return true;
			root = root.next;
		}
		
		return false;
	}

	public static void main(String[] args) {
		if (args.length < 1)
			return;
		Input in = new Input();
		switch (args[0]) {
		case "isContainPrime":
			in.isContainPrime(new Node());
			break;
		default:
			break;
		}
	}
	
}

class Node {
	
	public int elem;
	
	public Node next;
	
	public Node() {
		this(0, null);
	}
	
	public Node(int elem, Node next) {
		this.elem = elem;
		this.next = next;
	}
	
}