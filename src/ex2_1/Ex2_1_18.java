package ex2_1;

import edu.princeton.cs.algs4.StdDraw;

public class Ex2_1_18 {

	public static void selectionSort(double[] a) {
		@SuppressWarnings("unchecked")
		Comparable<Double>[] newA = new Comparable[a.length];
		for (int i = 0; i < a.length; i++) {
			newA[i] = a[i];
		}
		selectionSort(newA);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void selectionSort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
			assert isSorted(a, 0, i);
			Animation.animate(a, i + 1);
		}
		assert isSorted(a);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void insertSort(Comparable[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
			assert isSorted(a, 0, i);
			Animation.animate(a, i + 1);
		}
		assert isSorted(a);
	}

	/***************************************************************************
	 * Helper sorting functions.
	 ***************************************************************************/

	// is v < w ?
	@SuppressWarnings({ "rawtypes" })
	private static boolean less(Comparable<Comparable> v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/

	// is the array a[] sorted?
	private static boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	// is the array sorted from a[lo] to a[hi]
	@SuppressWarnings("unchecked")
	private static boolean isSorted(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		Double[] array = Animation.getRandomArray(50);
		double[] arrays = new double[50];
		for(int i = 0; i < 50; i++) {
			arrays[i] = array[i];
		}
		StdDraw.setXscale(-1, 51);
		selectionSort(arrays);
		insertSort(array);
	}

}
