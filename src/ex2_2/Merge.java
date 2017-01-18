package ex2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Merge{
	
	@SuppressWarnings("rawtypes")
	private static Comparable[] aux;
	
	private static void merge(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j])) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];
				
			}
		}
	}
	
	public static void sort(@SuppressWarnings("rawtypes") Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	
	protected static void sort(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int hi) {
		aux = new Comparable[a.length];
		if (hi <= lo)
			return;
		int mid = (hi - lo) / 2 + lo;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
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
		for(int i = 0; i < 10000; i++) {
			Double[] a = getRandomArray(i);
			sort(a);
			if(i % 100 == 0) StdOut.println(i);
			if(!isSorted(a)) throw new RuntimeException("wrong sort");
		}
		StdOut.println("end");
	}
	
}
