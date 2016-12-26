package q1_3_47;

import edu.princeton.cs.algs4.Queue;

public class NewQueue<Item> extends Queue<Item> {
    private Node<Item> first;    // beginning of queue
    private Node<Item> last;     // end of queue
    private int n;               // number of elements on queue
	
	public Queue<Item> catenation(NewQueue<Item> catQueue) {
		if(isEmpty()) return catQueue;
		last.next = catQueue.first;
		return this;
	}
	
    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
}
