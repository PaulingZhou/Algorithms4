package ex1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou<p>
 *	寻找数组中相差最大的两个数<p>
 */
public class Ex1_4_17 {
	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/1Kints.txt").readAllInts();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++) {
			min = Integer.min(a[i], min);
			max = Integer.max(a[i], max);
		}
		int diff = max - min;
		StdOut.println(diff);
	}
}
