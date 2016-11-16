package chapter1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Q1_1_35 {
	public static void expectedProb() {
		final int SIDES = 6;
		double[] dist = new double[SIDES * 2 + 1];
		for(int i = 1; i <= SIDES; i++) {
			for(int j = 1; j <= SIDES; j++) {
				dist[i+j]++;
			}
		}
		StdOut.println("理论上：");
		for(int i = 1; i < dist.length; i++) {
			StdOut.printf("投掷和为" + i + "的概率为%.3f\n", dist[i]/36);
		}
		StdOut.print("\n\n");
	}
	
	public static void experiencedProb(int N) {
		double[] dist = new double[13];
		int i = 0;
		while(i++ < N) {
			dist[(int)StdRandom.uniform(1, 7) + (int)StdRandom.uniform(1, 7)]++;
		}
		StdOut.println("实验：");
		for(int i1 = 1; i1 < dist.length; i1++) {
			StdOut.printf("投掷和为" + i1 + "的概率为%.3f\n", dist[i1]/N);
		}
		StdOut.print("\n\n");
	}
	
	public static void main(String[] args) {
		expectedProb();
		experiencedProb(1000000);
	}
}
