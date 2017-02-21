package ex2_4;

public abstract class MaxPQinArr_Ex2_4_3<Key extends Comparable<Key>> {
	protected Key[] pq;
	protected int N = 0;
	
	public MaxPQinArr_Ex2_4_3() {
		this(2);
	}

	@SuppressWarnings("unchecked")
	public MaxPQinArr_Ex2_4_3(int max) {
		pq = (Key[]) new Comparable[max+1];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public abstract void insert(Key v);
	
	public abstract Key delMax();
	
	protected boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	protected void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
}
