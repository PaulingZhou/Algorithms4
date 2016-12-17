package q1_3_33;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import q_1_3_30.Node;

@SuppressWarnings("unchecked")
public class ResizingArrayDeque<Item> {
	int dequelength = 0;		//队列长度
	int N = 1;		//数组长度
	Item[] items = (Item[])new Object[N];
	
	private boolean isFull() { return dequelength == N; }
	
	public boolean isEmpty() { return dequelength == 0; }
	
	public int size() { return dequelength; }
	
	public void pushLeft(Item item) {
		Item[] tempItems = items;
		if(isFull()) {
			N = N * 2;
			Item[] newItems = (Item[])new Object[N];
			items = newItems;
		}
		for(int i = dequelength; i > 0; i--) {
			items[i] = tempItems[i-1];
		}
		items[0] = item;
		dequelength++;
	}
	
	public void pushRight(Item item) {
		Item[] tempItems = items;
		if(isFull()) {
			N = N * 2;
			Item[] newItems = (Item[])new Object[N];
			items = newItems;
		}
		for(int i = dequelength-1; i >= 0; i--) {
			items[i] = tempItems[i];
		}
		items[dequelength++] = item;
	}
	
	public Item popLeft() {
		if(isEmpty()) return null;
		dequelength--;
		Item popItem = items[0];
		Item[] tempItems = items;
		if(dequelength <= N/4) {
			N = N / 2;
			Item[] newItems = (Item[])new Object[N];
			items = newItems;
		}
		for(int i = 0; i < dequelength; i++) {
			items[i] = tempItems[i+1];
		}
		items[dequelength] = null;
		return popItem;
	}
	
	public Item popRight() {
		if(isEmpty()) return null;
		dequelength--;
		Item popItem = items[dequelength];
		items[dequelength] = null;
		if(dequelength <= N/4) {
			N = N / 2;
			Item[] newItems = (Item[])new Object[N];
			for(int i = 0; i < dequelength; i++){
				newItems[i] = items[i];
			}
			items = newItems;
		}
		return popItem;
	}
	
	public static void main(String[] args) {
		ResizingArrayDeque<String> deque = new ResizingArrayDeque<>();
		for(int i = 1; i < 10; i++) {
			deque.pushLeft("pushLeft:"+i);
		}
		for(int i = 1; i < 10; i++) {
			StdOut.println("popLeft: " + deque.popLeft());
		}
		for(int i = 1; i < 10; i++) {
			deque.pushRight("pushRight:"+i);
		}
		for(int i = 1; i < 10; i++) {
			StdOut.println("popRight: " + deque.popRight());
		}
	}
}
