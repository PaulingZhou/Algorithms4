package ex2_4;

import edu.princeton.cs.algs4.StdOut;

public class MaxPQinOrderedLL<Key extends Comparable<Key>> extends MaxPQinLL_Ex2_4_3<Key> {

	public MaxPQinOrderedLL() {
		super();
	}

	public MaxPQinOrderedLL(int n) {
		super(n);
	}

	@Override
	public void insert(Key v) {
		Node node = new Node(v);
		if (isEmpty()) {
			tail = node;
			head.next = tail;
		} else {
			Node itNode = head;
			while (itNode.next != null) {
				if (less(itNode.next.val, node.val))
					break;
				itNode = itNode.next;
			}
			node.next = itNode.next;
			itNode.next = node;
			while(tail.next != null) tail = tail.next;
			if(size() == capacity) {
				itNode = head;
				while(itNode.next != tail) {
					itNode = itNode.next;
				}
				itNode.next = null;
				tail = itNode;
				N--;
			}
		}
		N++;
	}

	@Override
	public Key delMax() {
		if(isEmpty()) throw new RuntimeException("pq is empty!");
		Key op = head.next.val;
		head.next = head.next.next;
		N--;
		return op;
	}

	public static void main(String[] args) {
		Integer[] in = { 1, 3, 1, 5, 4, 2, 9 };
		MaxPQinOrderedLL<Integer> pqOrderedLL = new MaxPQinOrderedLL<>(5);
		for (Integer i : in) pqOrderedLL.insert(i);
		StdOut.println(pqOrderedLL);
		while(!pqOrderedLL.isEmpty()) {
			StdOut.println(pqOrderedLL.delMax());
		}
	}

}
