package ex2_2;

import java.awt.Color;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSort {

	@SuppressWarnings("rawtypes")
	private static Comparable[] aux;
	private static int visitCount;

	public static void sortTop2Buttom(@SuppressWarnings("rawtypes") Comparable[] a) {
		aux = new Comparable[a.length];
		sortTop2Buttom(a, 0, a.length - 1);
	}

	private static void sortTop2Buttom(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = (hi - lo) / 2 + lo;
		sortTop2Buttom(a, lo, mid);
		sortTop2Buttom(a, mid + 1, hi);
//		if(less(a[mid+1], a[mid]))
		merge2(a, lo, mid, hi);
	}
	
	public static void sortButtom2Top(@SuppressWarnings("rawtypes") Comparable[] a) {
		int N = a.length;
		for(int sz = 1; sz < N; sz = sz + sz) {
			for(int lo = 0; lo < N - sz; lo += sz+sz) {
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
			}
		}
	}
	
	private static void merge2(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int mid, int hi) {
		int i = mid, j = lo;	//i:index of a[]; j:index of aux[]
		for(int k = hi; k > mid; k--) {
			visitCount+=2;
			aux[hi+lo-k] = a[k];
		}
		for(int k = hi; k >= lo; k--) {
			if(j > hi+lo-mid-1) break;
			else if(i < lo) {
				visitCount+=2;
				a[k] = aux[j++];
			}
			else if(less(a[i], aux[j])) {
				visitCount+=4;
				a[k] = aux[j++];
			}
			else {
				visitCount+=4;
				a[k] = a[i--];
			}
		}
	}

	private static void merge(@SuppressWarnings("rawtypes") Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			visitCount += 2;
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			visitCount += 2;
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j])) {
				a[k] = aux[i++];
				visitCount += 2;
			} else {
				a[k] = aux[j++];
				visitCount += 2;
				
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static Double[] getRandomArray(int N) {
		Double[] array = new Double[N];
		for (int i = 0; i < N; i++)
			array[i] = StdRandom.uniform();
		return array;
	}
	
	// is the array a[] sorted?
	@SuppressWarnings("unused")
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
		StdDraw.setXscale(0, 256);
		StdDraw.setYscale(0, 12000);
		for (int i = 1; i <= 256; i++) {
			visitCount = 0;
			Double[] a = getRandomArray(i);
			Double[] a2 = a.clone();
			sortTop2Buttom(a);
//			boolean isSorted = isSorted(a);
//			if(!isSorted) throw new RuntimeException("wrong sort");
//			StdOut.println(isSorted);
			StdDraw.setPenColor(Color.BLACK);
			StdDraw.point(i, visitCount);
			visitCount = 0;
			sortButtom2Top(a2);
			StdDraw.setPenColor(Color.GREEN);
			StdDraw.point(i, visitCount);
			StdDraw.setPenColor(Color.RED);
			StdDraw.point(i, 6*i*Math.log10(i)/Math.log10(2));
		}
	}

}
