package ex2_3;

import edu.princeton.cs.algs4.StdOut;

public class Ex2_3_16 {
	
	private static int index = 0;
	
	public static Integer[] genRanArray(int N) {
		Integer[] nums = new Integer[N];
		genRanArray(nums, 1, N);
		return nums;
	}

	private static void genRanArray(Integer[] nums, int lo, int hi) {
		if(index >= nums.length || lo > hi) return;
		int insertNum = (lo + hi) / 2;
		nums[index++] = insertNum;
		if(lo == hi) return;
		genRanArray(nums, lo, insertNum-1);
		genRanArray(nums, insertNum+1, hi);
	}
	
	public static void main(String[] args) {
		Integer[] a = genRanArray(15);
		for(int s : a) StdOut.println(""+s);
	}
}
