package ex2_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex2_2_14 {

	private static Queue<Double> result;
	
	public static Queue<Double> merge(Queue<Double> q1, Queue<Double> q2) {
		result = new Queue<>();
		while(!q1.isEmpty() && !q2.isEmpty()) {
			if(less(q1.peek(), q2.peek())) result.enqueue(q1.dequeue());
			else result.enqueue(q2.dequeue());
		}
		while(!q1.isEmpty()) {
			result.enqueue(q1.dequeue());
		}
		while(!q2.isEmpty()) {
			result.enqueue(q2.dequeue());
		}
		return result;
	}
	
	// is a less than b?
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	public static void main(String[] args) {
		Queue<Double> q1 = new Queue<>();
		Queue<Double> q2 = new Queue<>();
		for(int i = 0; i < 100; i++) {
			q1.enqueue(Double.valueOf(i++));
			q2.enqueue(Double.valueOf(i));
		}
		StdOut.println(q1);
		StdOut.println(q2);
		Queue<Double> queue = merge(q1, q2);
		StdOut.println(queue);
		
	}
	
}
