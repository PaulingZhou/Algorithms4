package ex1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou<p>
 *	寻找数组中最接近的两个数
 */
public class Ex1_4_16 {
	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/1Kints.txt").readAllInts();
		Arrays.sort(a);
		int minDiff = Integer.MAX_VALUE;
		for(int i = 0; i < a.length-1; i++) {
			int curDiff = Math.abs(a[i] - a[i+1]);
			if(curDiff < minDiff) {
				minDiff = curDiff;
			}
		}
		StdOut.println(minDiff);
	}
}
