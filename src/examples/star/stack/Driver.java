package star.stack;

import stack.StackLi;
import stack.Underflow;

public class Driver {
	
	public static void main(String[] args) {
		if (args.length < 1)
			return;
		StackLi stack = new StackLi();
		switch (args[0]) {
		case "contains":
			stack.contains(null);
			break;
		case "isEmpty":
			stack.isEmpty();
			break;
		case "isFull":
			stack.isFull();
			break;
		case "makeEmpty":
			stack.makeEmpty();
			break;	
		case "pop":
			try {
				stack.pop();
			} catch (Underflow e) {
				e.printStackTrace();
			}
			break;
		case "push":
			stack.push(null);
			break;
		case "topAndPop":
			stack.topAndPop();
			break;
		case "top":
			stack.top();
			break;
		default:
			// do nothing
		}
	}

}
