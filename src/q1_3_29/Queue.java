package q1_3_29;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item> {
	private Node last;
	private int N = 0;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item newItem) {
		Node oldLast = last;
		last = new Node();
		last.item = newItem;
		if (isEmpty())
			last.next = last;
		else {
			last.next = oldLast.next;
			oldLast.next = last;
		}
		N++;
	}

	public Item dequeue() {
		if (isEmpty())
			return null;
		else {
			Item deItem = last.next.item;
			last.next = last.next.next;
			N--;
			return deItem;
		}
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
		private int count = N;
		private Node current = last.next;

		@Override
		public boolean hasNext() {
			if (count != 0)
				return true;
			else {
				return false;
			}
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			count--;
			return item;
		}
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		for (int i = 0; i < 5; i++) {
			queue.enqueue("" + i);
		}
		for (String s : queue)
			StdOut.println("Iterator:" + s);
		for (int i = 0; i < 6; i++) {
			StdOut.println("dequeue:" + queue.dequeue());
		}
	}

}
