package ex2_4;

import edu.princeton.cs.algs4.StdOut;

public class Ex2_4_19 {

	public static <Key extends Comparable<Key>> void constructMaxPQ(Key[] k) {
		int index = 1;
		while(index * 2 < k.length) index *= 2;
		for(int i = index-1; i > 0; i--) {
			sink(k, i);
		}
	}
	
	protected static <Key extends Comparable<Key>> void sink(Key[] k, int index) {
		while(2*index <= k.length) {
			int j = 2*index;
			if(j < k.length-1 && Ex2_4_14.less(k[j], k[j+1])) j++;
			if(!Ex2_4_14.less(k[index], k[j])) break;
			exch(k, index, j);
			index = j;
		}
	}
	
	protected static <Key extends Comparable<Key>> void exch(Key[] k, int i, int j) {
		Key temp = k[i];
		k[i] = k[j];
		k[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] in = {0,2,1,3,4,5,6};
		constructMaxPQ(in);
		for(Integer i : in) StdOut.println(i);
	}

	
}
