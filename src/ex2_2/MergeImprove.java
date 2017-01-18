package ex2_2;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeImprove {
	
	
	public static void sort(@SuppressWarnings("rawtypes") Comparable[] a) {
		sort(a, 0, a.length-1);
	}
	
	private static void sort(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int hi) {
		if(isSorted(a, lo, hi)) return;
		if(hi - lo < 6) Insertion.sort(a, lo, hi);
		else 
			Merge.sort(a, lo, hi);
	}
	
	// is a less than b?
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	// generate random array numbers
	private static Double[] getRandomArray(int N) {
		Double[] array = new Double[N];
		for (int i = 0; i < N; i++)
			array[i] = StdRandom.uniform();
		return array;
	}
	
	// is the array a[] sorted?
	private static boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	// is the array sorted from a[lo] to a[hi]
	private static boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++) {
			Double[] a = getRandomArray(i);
			sort(a);
			if(!isSorted(a)) throw new RuntimeException("wrong sort at " + i);
		}
		StdOut.println("end");
	}
	
	
}
