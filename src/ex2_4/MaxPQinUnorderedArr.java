package ex2_4;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQinUnorderedArr<Key extends Comparable<Key>> extends MaxPQinArr_Ex2_4_3<Key> {
	
	public MaxPQinUnorderedArr() {
		super();
	}
	
	public MaxPQinUnorderedArr(int n) {
		super(n);
	}
	
	@Override
	public void insert(Key v) {
		if(N < pq.length-1) { 
			N++;
			pq[N] = v;
		}
		else {
			int minIndex = 1;
			for(int i = 1; i <= N; i++) {
				if(less(i, minIndex)) {
					minIndex = i;
				}
			}
			pq[minIndex] = v;
		}
	}

	@Override
	public Key delMax() {
		if(N == 0) throw new RuntimeException("empty pq!");
		int maxIndex = 1;
		for(int i = 1; i <= N; i++) {
			if(less(maxIndex, i)) {
				maxIndex = i;
			}
		}
		Key op = pq[maxIndex];
		pq[maxIndex] = null;
		exch(maxIndex, N);
		N--;
		return op;
	}
	
	public static void main(String[] args) {
		Integer[] in = {1,3,6,5,4,2,2};
		MaxPQinUnorderedArr<Integer> pqUnorderedArr = new MaxPQinUnorderedArr<>(5);
		for(int i = 0; i < in.length; i++) {
			pqUnorderedArr.insert(in[i]);
		}
		while(!pqUnorderedArr.isEmpty()) {
			StdOut.println((int)pqUnorderedArr.delMax());
		}
		
	}

}
