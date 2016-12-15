package q1_3_15;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_15 {
	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		while (!StdIn.isEmpty()) {
			queue.enqueue(StdIn.readString());
		}
		int k = Integer.parseInt(args[0]);
		for(String s : queue) {
//			StdOut.println(s);
			if(k++ == queue.size()) {
				StdOut.println(s);
				return;
			}
		}
	}
}
