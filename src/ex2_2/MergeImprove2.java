package ex2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeImprove2 {

	@SuppressWarnings("rawtypes")
	private static Comparable[] block;
	
	public static void sort(@SuppressWarnings("rawtypes") Comparable[] a, int blkSize) {
		int arraySize = a.length;
		int blkNum = arraySize / blkSize;
		block = new Comparable[blkSize];
		for(int i = 0; i < blkNum; i++) {
			merge(a, i*blkSize);
		}
		for(int i = 0; i < blkNum; i++) {
			for(int j = i+1; j < blkNum; j++) {
				if(less(a[blkSize * j], a[blkSize * i])) {
					exch(a, i, j, blkSize);
				}
			}
		}
		for(int i = 1; i < blkNum; i++) {
			mergeBlock(a, i*blkSize);
		}
	}

	private static void mergeBlock(@SuppressWarnings("rawtypes") Comparable[] a, int newBlockIndex) {
		for(int i = 0; i < block.length; i++) {
			block[i] = a[newBlockIndex + i];
		}
		int originPoint = 0, newPoint = 0;
		while(originPoint< newBlockIndex && newPoint < block.length) {
			if(!less(block[newPoint], a[originPoint+newPoint])) originPoint++;
			else {
				for(int i = newBlockIndex; i > originPoint; i--) {
					a[i+newPoint] = a[i+newPoint-1];
				}
				a[originPoint + newPoint] = block[newPoint];
				newPoint++;
			}
		}
	}

	private static void merge(@SuppressWarnings("rawtypes") Comparable[] a, int startPoint) {
		for(int i = 0; i < block.length; i++) {
			block[i] = a[startPoint+i];
		}
		Merge.sort(block);
		for(int i = 0; i < block.length; i++) {
			 a[startPoint+i] = block[i];
		}
	}

	private static void exch(@SuppressWarnings("rawtypes") Comparable[] a, int i, int j, int m) {
		for(int k = 0; k < m; k++) {
			exch(a, i*m+k, j*m+k);
		}
	}

	private static void exch(@SuppressWarnings("rawtypes") Comparable[] a, int i, int j) {
		@SuppressWarnings("rawtypes")
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
	
	public static void main(String[] args) {
		Double[] a = getRandomArray(20);
		Double[] a2 = a.clone();
		sort(a, 5);
		for(int i = 0; i < a.length; i++) {
			if(i%5 == 0) StdOut.println();
			StdOut.println(a[i] + " " + a2[i]);
		}
	}
	
}
