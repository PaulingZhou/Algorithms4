package q1_3_50;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item>{
	private class Node {
		public Node(Item item) {
			this.item = item;
		}
		public Item item;
		public Node next;
	}
	
	private Node head;
	private int size = 0;
	private int popValue = 0;
	private int pushValue = 0;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(Item item) {
		pushValue++;
		if(isEmpty()) head = new Node(item);
		else {
			Node newHead = new Node(item);
			newHead.next = head;
			head = newHead;
		}
		size++;
	}
	
	public Item pop() {
		popValue++;
		if(isEmpty()) throw new RuntimeException("stack is empty.");
		size--;
		Node popNode = head;
		head = head.next;
		popNode.next = null;
		return popNode.item;
	}
	
	public Item peek() {
		if(isEmpty()) throw new RuntimeException("stack is empty");
		return head.item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {

		private Node itHead = head;
		public ListIterator() {
			pushValue = 0;
			popValue = 0;
		}
		
		@Override
		public boolean hasNext() {
			if(popValue != 0 || pushValue != 0) throw new ConcurrentModificationException("illegal push or pop in iterator.");
			return itHead != null;
		}

		@Override
		public Item next() {
			Item item = itHead.item;
			itHead = itHead.next;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		for(int i = 1; i <= 5; i++) {
			stack.push(""+i);
		}
		for(String s : stack) {
			stack.push("s");
			StdOut.println(s);
		}
//		for(int i = 1; i <=6; i++) {
//			StdOut.println(stack.pop());
//		}
	}

}
