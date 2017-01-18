package ex2_1;

import edu.princeton.cs.algs4.StdOut;

public class Ex2_1_12 {
	public static void main(String[] args) {
		int N = 1;
		int T = 5;
		String alg = "Shell";
		for(int i = 1; i <= 10; i++) {
			double time = SortCompare.timeRandomInput(alg, N, T);
			N*=10;
			StdOut.printf("%d random Numbers time is %.1f, time/N=%.1f\n", N, time, time/N);
		}
	}
}
