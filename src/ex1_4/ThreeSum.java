package ex1_4;

import java.util.Arrays;
import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou<p>
 * 
 * ex1.4.2
 *
 */
public class ThreeSum {
	public static int count(int[] a) {
		Arrays.sort(a);
		int cnt = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				long sum = a[i] + a[j];
				if(sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) continue;
				if(BinarySearch.indexOf(a, -a[i]-a[j]) > j) cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/1Kints.txt").readAllInts();
		StdOut.println(count(a));
	}
}
