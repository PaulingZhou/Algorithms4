package ex2_3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhou
 *	非递归的快速排序
 */
public class Ex2_3_20 {

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		Comparable[] result = new Comparable[a.length];
		StdRandom.shuffle(a);
		Stack<Comparable[]> stack = new Stack<>();
		stack.push(a);
		int index = a.length;
		while(!stack.isEmpty()) {
			Comparable[] output = stack.pop();
			if(output.length == 0) continue;
			if(output.length == 1) {
				result[--index] = output[0];
				continue;
			}
			Comparable v = output[0];
			int i = 0, j = output.length;
			while(true) {
				while(less(v, output[++i]))if(i == output.length-1) break;
				while(less(output[--j], v));
				if(i >= j) break;
				exch(output, i, j);
			}
			exch(output, 0, j);
			Comparable[] low = copyArrays(output, 0, j-1);
			Comparable[] medium = copyArrays(output, j, j);
			Comparable[] high = copyArrays(output, j+1, output.length-1);
			stack.push(high);
			stack.push(medium);
			stack.push(low);
		}
		for(int i = 0; i < a.length; i++) a[i] = result[i];
	}
	
	@SuppressWarnings("rawtypes")
	private static Comparable[] copyArrays(Comparable[] output, int i, int j) {
		Comparable[] result = new Comparable[j-i+1];
		for(int c = i; c <=j; c++) {
			result[c-i] = output[c];
		}
		return result;
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
		Integer[] a = Ex2_3_16.genRanArray(100);
		sort(a);
		for(int i : a) StdOut.println(i);
	}
	
}
