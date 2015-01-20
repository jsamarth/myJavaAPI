package myUtil;
import java.util.LinkedList;
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fibo(6));
	}
	
	public static int fibo(int n) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(1);
		
		for (int i = 2; i<= n; i++) {
			l.add(l.get(i - 1) + l.get(i - 2));
		}
		
		return l.get(n - 1);
	}

}
