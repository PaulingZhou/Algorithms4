package ex1_4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou
 * 
 *			Deque()					创建一个空双向队列<p>
 *	boolean	isEmpty()				双向队列是否为空<p>
 *	int		size()					双向队列中的元素数量<p>
 *	void	pushLeft(Item item)		向左端添加一个新元素<p>
 *	void	pushRight(Item item)	向右端添加一个新元素<p>
 *	Item	popLeft()				从左端删除一个元素<p>
 *	Item	popLeft()				从右端删除一个元素<p>
 *
 */
public class Deque<Item>{

	private Stack<Item> stack;
	private Queue<Item>	queue;
	
	public Deque() {
		stack = new Stack<>();
		queue = new Queue<>();
	}
	
	public int size() {
		return stack.size() + queue.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void pushLeft(Item item) {
		stack.push(item);
	}
	
	public void pushRight(Item item) {
		queue.enqueue(item);
		for(int i = 1; i < queue.size(); i++) {
			queue.enqueue(queue.dequeue());
		}
	}
	
	public Item popLeft() {
		if(isEmpty()) throw new RuntimeException("deque is empty!");
		if(!stack.isEmpty()) return stack.pop();
		else {
			for(int i = 0; i < size(); i++) {
				if(i < size()/2) queue.enqueue(queue.dequeue());
				else stack.push(queue.dequeue());
			}
			return stack.pop();
		}
	}
	
	public Item popRight() {
		if(isEmpty()) throw new RuntimeException("deque is empty!");
		if(!queue.isEmpty()) return queue.dequeue();
		else {
			for(int i = 0; i < size(); i++) {
				queue.enqueue(stack.pop());
			}
			for(int i = 0; i < size(); i++) {
				stack.push(queue.dequeue());
			}
			for(int i = 0; i < size(); i++) {
				queue.enqueue(stack.pop());
			}
			for(int i = 0; i < size(); i++) {
				if(i < size()/2 + 1) queue.enqueue(queue.dequeue());
				else stack.push(queue.dequeue());
			}
			return queue.dequeue();
		}
	}
	
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<>();
		for(int i = 0; i < 10; i++) {
			if(i%2 == 0) deque.pushLeft(i);
			else deque.pushRight(i);
		}
		for(int i = 0; i < 10; i++) {
			int a;
			if(i%2 == 0) a = deque.popLeft();
			else a = deque.popRight();
			String pattern = i%2 == 0 ? "left" : "right";
			StdOut.printf("pop" + pattern + ":%d\n", a);
		}
	}

}
