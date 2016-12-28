package ex1_4;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou<p>
 *	ex1.4.15<p>
 *	线性时间求2-Sum问题，平方时间求3-Sum问题
 */
public class ThreeSumFast {
	public static int TwoSumFast(int[] a, int target) {
		int head = 0, tail = a.length-1;
		int count = 0;
		while(head < tail) {
			int currentTwoSum = a[head] + a[tail];
			count = currentTwoSum == target ? count+1 : count;
			if(currentTwoSum > target) tail--;
			else head++;
		}
		return count;
	}
	
	public static int ThreeSumFasta(int[] a) {
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			count += TwoSumFast(Arrays.copyOfRange(a, i+1, a.length), -a[i]);
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/1Kints.txt").readAllInts();
		Arrays.sort(a);
		StdOut.println(ThreeSumFasta(a));
	}
}
