package q1_3_49;

import edu.princeton.cs.algs4.Stack;

public class StackofQueue<Item> {
	public Stack<Item> enqueueStack;
	public Stack<Item> dequeueStack;
	
	public StackofQueue() {
		enqueueStack = new Stack<>();
		dequeueStack = new Stack<>();
	}
	
	public int size() {
		return enqueueStack.size() + dequeueStack.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void enqueue(Item item){
		enqueueStack.push(item);
	}
	
	public Item dequeue() {
		if(isEmpty()) throw new RuntimeException("queue is empty");
		if(dequeueStack.isEmpty()) {
			while(!enqueueStack.isEmpty()) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.pop();
	}
}
