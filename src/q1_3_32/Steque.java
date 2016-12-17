package q1_3_32;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou
 *	boolean isEmpty()						判断队列是否为空
 *	void push(Item item)					将item加入队列末尾
 *	Item pop()								从队列末尾弹出item
 *	void enqueue(Item item)					将item加入队列头部
 * @param <Item>
 */
public class Steque<Item> {
	
	Node head,tail;
	int N = 0;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public final boolean isEmpty() {
		return N == 0;
	}
	
	public void push(Item item) {
		if(isEmpty()) {
			head = new Node();
			tail = head;
			head.item = item;
		}
		else {
			Node newTail = new Node();
			newTail.item = item;
			tail.next = newTail;
			tail = newTail;
		}
		N++;
	}
	
	public Item pop() {
		if(isEmpty()) return null;
		else {
			Node current = head;
			N--;
			if(head == tail) {
				return head.item;
			}
			else {
				while(current.next.next != null) {
					current = current.next;
				}
				current.next = null;
				Node popNode = tail;
				tail = current;
				return popNode.item;
			}
		}
	}
	
	public void enqueue(Item item) {
		if(isEmpty()) {
			head = new Node();
			tail = head;
			head.item = item;
		}
		else {
			Node current = new Node();
			current.item = item;
			current.next = head;
			head = current;
		}
		N++;
	}
	
	public static void main(String[] args) {
		Steque<String> steque = new Steque<>();
		for(int i = 1; i <= 5; i++) {
			steque.push("push:"+i);
		}
		for(int i = 1; i <=6; i++) {
			StdOut.println("pop: "+steque.pop());
		}
		for(int i = 1; i <= 5; i++) {
			steque.enqueue("enqueue:"+i);
		}
		for(int i = 1; i <=6; i++) {
			StdOut.println("pop: "+steque.pop());
		}
	}
}
