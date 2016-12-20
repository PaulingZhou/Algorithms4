package q1_3_38;

import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueueLinkedList<Item> {
	int N = 0;
	Node head,tail;
	
	public boolean isEmpty() {return N == 0;}
	
	public void insert(Item x) {
		Node newHead = new Node(x);
		if(isEmpty()) {
			head = newHead;
			tail = head;
		}
		else {
			newHead.next = head;
			head = newHead;
		}
		N++;
	}
	
	public Item delete(int k) {
		if(isEmpty() || k > N || k <= 0) return null;
		else {
			N--;
			Node current = head;
			if(isEmpty()) {
				return current.item;
			}
			while(--k > 1) current = current.next;
			Item returnItem = current.next.item;
			current.next = current.next.next;
			return returnItem;
		}
	}
	
	private class Node {
		public Node(Item item) {
			this.item = item;
		}
		Item item;
		Node next;
	}
	
	public static void main(String[] args) {
		GeneralizedQueueLinkedList<String> queue = new GeneralizedQueueLinkedList<>();
		for(int i = 1; i <= 5; i++) {
			queue.insert(""+i);
		}
		for(int i = 5; i > 0; i--) {
			StdOut.println(queue.delete(i));
		}
	}
}
