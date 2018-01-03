package features.array;

public class SimpleArray {
	
	public int foo(int[] arr, int i) {
		int a = arr[i];
		if (a > 0) {
			return a;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		SimpleArray sa = new SimpleArray();
		
		int[] arr = {1,2,3,4,5};
		sa.foo(arr,0);
	}

}
