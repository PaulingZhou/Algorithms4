package ex2_3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhou
 *	快速三向切分 (J. Bently, D. Mcllroy)
 */
public class Ex2_3_22 {
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		if(a.length == 0 || a == null) return;
		StdRandom.shuffle(a);
//		for(Comparable i : a) StdOut.print((Integer)i + " ");
//		StdOut.print('\n');
		sort(a, 0, a.length-1);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void sort(Comparable[] a, int lo, int hi) {
//		for(Comparable c : a) StdOut.print((Integer)c + " ");
//		StdOut.print('\n');
		if(lo >= hi) return;
		Comparable v = a[lo];
		int i = lo, p = lo+1;
		int j = hi, q = hi;
		while(i <= j-1) {
			while(!less(v, a[++i])) {
				if(v.compareTo(a[i]) == 0) exch(a, p++, i);
				if(i == j) break;
			}
			if(!less(v, a[i])) {
				j++;
				break;
			}
			while(!less(a[j], v)) {
				if(j == i) break;
				if(v.compareTo(a[j]) == 0) exch(a, q--, j);
				j--;
			}
			if(!less(a[j], v)) {
				i--;
				break;
			}
			exch(a, i, j--);
		}
		if(i == j) j++;
		
//		for(Comparable c : a) StdOut.print((Integer)c + " ");
//		StdOut.print('\n');
//		int c = 0;
//		for(c = 0; c < a.length; c++) {
//			if(less(a[0], a[c])) break; 
//		}
//		if(c != j) throw new RuntimeException("wrong i & j");
		
		for(int ch = lo; ch < p; ch++) {
			exch(a, ch, lo+i-ch);
		}
		for(int ch = hi; ch > q; ch--) {
			exch(a, ch, hi+j-ch);
		}
//		boolean isV = false;
//		boolean isSuccess = false;
//		for(Comparable c : a) {
//			StdOut.print((Integer)c + " ");
//			if(!isV && c.compareTo(v) == 0) isV = true;
//			if(isV && c.compareTo(v) != 0) isSuccess = true;
//			if(isSuccess && c.compareTo(v) == 0) isSuccess = false;
//		}
//		if(!isSuccess) throw new RuntimeException("wrong v order");
//		StdOut.print('\n');
//		StdOut.printf("lo = %d, hi = %d, i = %d, j = %d, p = %d, q = %d\n", lo, hi, i, j, p, q);

		sort(a, lo, lo+i-p);
		sort(a, hi+j-q, hi);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable a, Comparable b) {
		if(a.compareTo(b) < 0) return true;
		else return false;
	}
	
	@SuppressWarnings("rawtypes")
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		Integer[] a = {4,2,2,1,5,2,2,1,3,4,1,3,1000};

		for(int i = 0; i < 100; i++){
			sort(a);
			for(int j = 0; j < a.length-1 ; j++) {
//				StdOut.print(a[j] + " ");
				if(less(a[j+1], a[j])) throw new RuntimeException("wrong order");
			}
//			StdOut.println(a[a.length - 1]);
		}
		StdOut.println("success!");

	}
}
