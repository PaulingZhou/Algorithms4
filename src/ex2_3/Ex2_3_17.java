package ex2_3;

public class Ex2_3_17 {

	@SuppressWarnings({ "unused", "rawtypes" })
	private static int partition(Comparable[] a, int lo, int hi) {
		Comparable max = a[0];
		int index = 0;
		for(int i = 0; i < a.length; i++) {
			if(less(max, a[i])) {
				max = a[i];
				index = i;
			}
		}
		exch(a, index, a.length-1);
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true) {
			while(less(a[++i], v));
			while(less(v, a[--j]));
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
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
	
}
