package ex1_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author zhou
 * 
 *			Deque_3Stack()			创建一个空双向队列
 *	boolean	isEmpty()				双向队列是否为空
 *	int		size()					双向队列中的元素数量
 *	void	pushLeft(Item item)		向左端添加一个新元素
 *	void	pushRight(Item item)	向右端添加一个新元素
 *	Item	popLeft()				从左端删除一个元素
 *	Item	popLeft()				从右端删除一个元素
 *
 */

public class Deque_3Stack<Item> {

	Stack<Item> stackLeft, stackRight, stackTrans;
	
	public Deque_3Stack() {
		stackLeft = new Stack<>();
		stackRight = new Stack<>();
		stackTrans = new Stack<>();
	}
	
	public int size() {
		return stackLeft.size() + stackRight.size() + stackTrans.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void pushLeft(Item item) {
		stackLeft.push(item);
	}
	
	public void pushRight(Item item) {
		stackRight.push(item);
	}
	
	public Item popLeft() {
		if(isEmpty()) throw new RuntimeException("deque is empty!");
		else if(stackLeft.isEmpty()) {
			rearrangeStacks();
		}
		return stackLeft.pop();
	}
	
	public Item popRight() {
		if(isEmpty()) throw new RuntimeException("deque is empty!");
		else if(stackRight.isEmpty()) {
			rearrangeStacks();
		}
		return stackRight.pop();
	}
	
	private void rearrangeStacks() {
		Stack<Item> stackNull = stackLeft.isEmpty() ? stackLeft : stackRight;
		Stack<Item> stackCop = stackLeft.isEmpty() ? stackRight : stackLeft;
		while(!stackCop.isEmpty()) stackNull.push(stackCop.pop());
		int N = size();
		for(int i = 0; i < N; i++) {
			if(i < N/2 + 1) stackTrans.push(stackNull.pop());
			else stackCop.push(stackNull.pop());
		}
		while(!stackTrans.isEmpty()) stackNull.push(stackTrans.pop());
	}
	
	public static void main(String[] args) {
		Deque_3Stack<Integer> deque_3Stack = new Deque_3Stack<>();
		for(int i = 0; i < 10; i++) {
			if(i%2 == 0) deque_3Stack.pushLeft(i);
			else deque_3Stack.pushRight(i);
		}
		for(int i = 0; i < 10; i++) {
			StdOut.printf("Deque pop left : %d\n", deque_3Stack.popLeft());
		}
	}
}
