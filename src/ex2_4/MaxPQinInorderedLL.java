package ex2_4;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQinInorderedLL<Key extends Comparable<Key>> extends MaxPQinLL_Ex2_4_3<Key> {

	public MaxPQinInorderedLL(int n) {
		super(n);
	}
	
	public MaxPQinInorderedLL() {
		super();
	}
	
	@Override
	public void insert(Key v) {
		if(N < capacity) {
			Node node = new Node(v);
			if (isEmpty()) {
				tail = node;
				head.next = tail;
			} else {
				tail.next = node;
				tail = tail.next;
			}
			N++;
		}
		else {
			Node itNode = head, minNode = head;
			while(itNode.next != null) {
				if(less(itNode.next.val, minNode.next.val)) {
					minNode = itNode;
				}
				itNode = itNode.next;
			}
			minNode.next.val = v;
		}
	}

	@Override
	public Key delMax() {
		if (isEmpty())
			throw new RuntimeException("pq is empty!");
		Key op;
		Node itPoint = head, maxNode = head;
		while (itPoint.next != null) {
			if (less(maxNode.next.val, itPoint.next.val)) {
				maxNode = itPoint;
			}
			itPoint = itPoint.next;
		}
		op = maxNode.next.val;
		maxNode.next = maxNode.next.next;
		N--;
		return op;
	}

	public static void main(String[] args) {
		Integer[] in = { 1, 3, 6, 5, 4, 2, 2 };
		MaxPQinInorderedLL<Integer> pqInorderedLL = new MaxPQinInorderedLL<>(5);
		for (Integer i : in)
			pqInorderedLL.insert(i);
		StdOut.println(pqInorderedLL);
		 while(!pqInorderedLL.isEmpty()) {
		 StdOut.println((int) pqInorderedLL.delMax());
		 }
	}

}
