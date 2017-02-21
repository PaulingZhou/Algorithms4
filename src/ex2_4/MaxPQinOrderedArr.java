package ex2_4;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQinOrderedArr<Key extends Comparable<Key>> extends MaxPQinArr_Ex2_4_3<Key> {

	public MaxPQinOrderedArr() {
		super();
	}
	
	public MaxPQinOrderedArr(int n) {
		super(n);
	}
	
	@Override
	public void insert(Key v) {
		if(N < pq.length-1) {
			pq[++N] = v;
		} else {
			pq[N] = v;
		}
		int index = N;
		for(int i = 1; i < index; i++) {
			if(less(i, index)) {
				index = i;
				break;
			}
		}
		for(int i = index; i < N; i++) {
			exch(i, i+1);
		}
	}

	@Override
	public Key delMax() {
		if(isEmpty()) throw new RuntimeException("empty pq!");
		Key op = pq[N];
		pq[N] = null;
		N--;
		return op;
	}
	
	public static void main(String[] args) {
		Integer[] in = {1,3,6,5,4,2,2};
		MaxPQinOrderedArr<Integer> pqOrderedArr = new MaxPQinOrderedArr<>(5);
		for(int i = 0; i < in.length; i++) {
			pqOrderedArr.insert(in[i]);
		}
		while(!pqOrderedArr.isEmpty()) {
			StdOut.println((int)pqOrderedArr.delMax());
		}
	}
	

}
