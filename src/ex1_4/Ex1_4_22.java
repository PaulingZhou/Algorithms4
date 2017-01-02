package ex1_4;

import edu.princeton.cs.algs4.StdOut;

public class Ex1_4_22 {
	
	static int mihPatr(int[] a, int target) {
		int n = a.length;
		return mihPatr(a, 0, n, target);
	}
	
	static int mihPatr(int[] a, int start, int offset, int target) {
		int acc = 0;
		int f1 = 1, f2 = 0;
		int result = -1;
		while(acc < offset) {
			if(a[start + acc] < target) {
				acc = f1+f2;
				f2 = f1;
				f1 = acc;
			}
			else if(a[start + acc] == target) {
				result = start + acc;
				break;
			}
			else if(a[start + acc] > target){
				start = start + f2;
				result = mihPatr(a, start, f1-f2, target);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,5,6,7,8,9,11,13,15,17,19,25,27,29,34,56};
		StdOut.println(mihPatr(a, 8));
	}
}
