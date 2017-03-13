package ex2_4;

import edu.princeton.cs.algs4.StdOut;

public class Ex2_4_14 {

	public static<Key extends Comparable<Key>> boolean isMinHeap(Key[] k) {
		return isSubMinHeap(k, 1);
	}
	
	private static<Key extends Comparable<Key>> boolean isSubMinHeap(Key[] k, int index) {
		if(index >= k.length) return true;
		int leftSub = 2*index, rightSub = 2*index+1;
		if(leftSub < k.length) {
			if(less(k[leftSub], k[index])) return false;
			else return isSubMinHeap(k, leftSub);
		}
		if(rightSub < k.length) {
			if(less(k[rightSub], k[index])) return false;
			else return isSubMinHeap(k, rightSub);
		}
		return true;
	}
	
	protected static<Key extends Comparable<Key>> boolean less(Key k1, Key k2) {
		return k1.compareTo(k2) < 0;
	}
	
	public static void main(String[] args) {
		Integer[] in = {0,2,1,3,4,5,6};
		StdOut.println(isMinHeap(in));
	}
	
}
