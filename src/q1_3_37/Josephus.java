package q1_3_37;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		Queue<Integer> queue = new Queue<>();
		for(int i = 0; i < N; i++) queue.enqueue(i);
		while(!queue.isEmpty()) {
			for(int i = 1; i < M; i++) queue.enqueue(queue.dequeue());
			StdOut.println(queue.dequeue());
		}
	}
}
