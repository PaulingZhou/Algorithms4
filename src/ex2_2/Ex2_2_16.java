package ex2_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex2_2_16 {

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
	
	public static void sort(@SuppressWarnings("rawtypes") Comparable[] a) {
		Queue<Integer> queue = new Queue<>();
		aux = new Comparable[a.length];
		int lo = 0;
		for(int i = 1; i < a.length; i++) {
			if(less(a[i], a[i-1])) queue.enqueue(i-1);
		}
		queue.enqueue(a.length-1);
		while(queue.size() > 1) {
			int mid = queue.dequeue();
			if(mid > queue.peek()) {
				queue.enqueue(mid);
				lo = 0;
				continue;
			}
			int hi = queue.dequeue();
			merge(a, lo, mid, hi);
			queue.enqueue(hi);
			lo = hi+1;
		}
	}
	
	public static void main(String[] args) {
		Double[] a = getRandomArray(20);
		sort(a);
		for(Double d : a) StdOut.println(d);
	}

	
}
