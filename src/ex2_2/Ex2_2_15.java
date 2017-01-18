package ex2_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex2_2_15 {

	
	public static void main(String[] args) {
		Queue<Queue<Double>> queue = new Queue<>();
		for(int i = 0; i < 100; i++) {
			Double d = StdRandom.uniform();
			Queue<Double> q = new Queue<>();
			q.enqueue(d);
			queue.enqueue(q);
		}
		Queue<Double> result = sort(queue);
		StdOut.println(result);
	}

	private static Queue<Double> sort(Queue<Queue<Double>> queue) {
		while(queue.size() > 1) {
			Queue<Double> q1 = queue.dequeue();
			Queue<Double> q2 = queue.dequeue();
			Queue<Double> mergeQ = Ex2_2_14.merge(q1, q2);
			queue.enqueue(mergeQ);
		}
		return queue.dequeue();
	}
	
	
}
