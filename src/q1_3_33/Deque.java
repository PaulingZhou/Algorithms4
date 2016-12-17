package q1_3_33;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou
 *				Deque()						创建双向元素
 *	boolean		isEmpty()					双向元素是否为空
 *	int			size()						双向队列中的元素数量
 *	void		pushLeft(Item item)			向左端添加一个元素
 *	void		pushRight(Item item)		向右端添加一个元素
 *	Item		popLeft()					从左端删除一个元素
 *	Item		popRight()					向右端删除一个元素
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

	private int N = 0; // size
	private DoubleNode head, tail;

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void pushLeft(Item item) {
		if (isEmpty())
			pushEmpty(item);
		else {
			DoubleNode current = new DoubleNode(item);
			current.next = head;
			head.previous = current;
			head = current;
		}
		N++;
	}

	public void pushRight(Item item) {
		if (isEmpty())
			pushEmpty(item);
		else {
			DoubleNode current = new DoubleNode(item);
			current.previous = tail;
			tail.next = current;
			tail = current;
		}
		N++;
	}
	
	public Item popLeft() {
		if(isEmpty()) return null;
		N--;
		DoubleNode popNode = head;
		if(popNode != tail) {
			head = head.next;
			popNode.next.previous = null;
			popNode.next = null;
		}
		return popNode.item;
	}
	
	public Item popRight() {
		if(isEmpty()) return null;
		N--;
		DoubleNode popNode = tail;
		if(popNode != head) {
			tail = tail.previous;
			popNode.previous.next = null;
			popNode.previous = null;
		}
		return popNode.item;
	}

	private void pushEmpty(Item item) {
		head = new DoubleNode(item);
		tail = head;
	}

	private class DoubleNode {

		Item item;
		DoubleNode previous;
		DoubleNode next;

		public DoubleNode(Item item) {
			this.item = item;
		}

	}

	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {

		DoubleNode current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

	public static void main(String[] args) {
		Deque<String> deque = new Deque<>();
		for (int i = 1; i < 5; i++) {
			deque.pushLeft("pushLeft:" + i);
		}
		for (int i = 1; i < 5; i++) {
			deque.pushRight("pushRight:" + i);
		}
		for (String string : deque)
			StdOut.println("Iterator: "+string);
		for(int i = 1; i < 5; i++) {
			StdOut.println("popLeft: " + deque.popLeft());
		}
		for(int i = 1; i < 5; i++) {
			StdOut.println("popRight: " + deque.popRight());
		}
		
	}
}
