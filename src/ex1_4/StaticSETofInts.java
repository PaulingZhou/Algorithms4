package ex1_4;

import java.util.Arrays;

public class StaticSETofInts {
	private int[] ints;
	
	public StaticSETofInts(int[] a) {
		ints = a.clone();
		Arrays.sort(ints);
	}
	
	public boolean contains(int key) {
		return rank(key) != -1;
	}
	
	private int rank(int key) {
		int head = 0, tail = ints.length;
		while(head < tail) {
			int mid = (head+tail)/2;
			if(ints[mid] > key) tail = mid - 1;
			else if(ints[mid] < key) head = mid + 1;
			else return mid;
		}
		return -1;
	}
	
}
