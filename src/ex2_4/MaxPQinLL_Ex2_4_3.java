package ex2_4;


public abstract class MaxPQinLL_Ex2_4_3<Key extends Comparable<Key>> {

	protected class Node {
		
		public Key val;
		public Node next;

		public Node(Key v) {
			val = v;
		}
		
		@Override
		public String toString() {
			return ""+val;
		}
		
	}
	
	protected int N;
	protected int capacity;
	protected Node head, tail;
	
	public MaxPQinLL_Ex2_4_3() {
		this(1);
	}
	
	public MaxPQinLL_Ex2_4_3(int n) {
		Integer d = Integer.MIN_VALUE;
		head = new Node(MaxPQinLL_Ex2_4_3.cast(d));
		capacity = n;
	}
	
	@SuppressWarnings("unchecked")
	public static <Key> Key cast(Integer d) {
		return (Key)d;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public abstract void insert(Key v);
	
	public abstract Key delMax();
	
	protected boolean less(Key i, Key j) {
		return i.compareTo(j) < 0;
	}
	
	protected void exch(Node i, Node j) {
		Key t = i.val;
		i.val = j.val;
		j.val = t;
	}
	
	@Override
	public String toString() {
		if(isEmpty()) return "null";
		else {
			String output = "";
			Node it = head;
			while(it != tail) {
				output = output + it.val + "->";
				it = it.next;
			}
			output += it.val;
			return output;
		}
	}

}
