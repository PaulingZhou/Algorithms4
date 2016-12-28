package ex1_4;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou <p>
 *	Ex1.4.14<p>
 */
public class FourSum {
	public static int count(int[] a) {
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				for(int k = j+1; k < a.length ;k++) {
					int threeSum = a[i] + a[j] + a[k];
					if(BinarySearch.indexOf(a, -threeSum) > k) count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/1Kints.txt").readAllInts();
		StdOut.println(count(a));
	}
}
