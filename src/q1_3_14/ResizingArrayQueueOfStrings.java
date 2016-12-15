package q1_3_14;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayQueueOfStrings<Item> {
	@SuppressWarnings("unchecked")
	private Item[] a = (Item[]) new Object[1];
	private int N = 0, start = 0;
	public boolean isEmpty()	{ return N == 0; }
	public int size()	{ return N; }
	
	private void resize(int max,int start) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; i++) {
			temp[i] = a[start++];
		}
		a = temp;
	}
	
	public void enqueue(Item item) {
		if(N == a.length) resize(2 * a.length, 0);
		a[N++] = item;
	}
	
	public Item dequeue() {
		if(isEmpty()) {
			StdOut.println("cannot dequeue: empty");
			return null;
		}
		if(N-1 <= a.length/4) {
			resize(a.length/2, start);
			start = 0;
		}
		N--;
		return a[start++];
	}
}
