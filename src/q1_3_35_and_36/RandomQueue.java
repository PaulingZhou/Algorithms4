package q1_3_35_and_36;

import java.util.Arrays;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 *				RandomQueue()		创建一个空的随机队列<p>
 *	boolean		isEmpty()			队列是否为空<p>
 *	void		enqueue(Item item)	添加一个元素<p>
 *	Item		dequeue()			删除并随即返回一个元素（取样但不返回）<p>
 *	Item		sample()			随即返回一个元素但不删除它（取样但返回）<p>
 *
 * @author zhou
 * @param <Item>
 */
public class RandomQueue<Item> implements Iterable<Item>{
	int N = 1;
	int itemsLength = 0;
	Item[] items;
	
	@SuppressWarnings("unchecked")
	public RandomQueue() {
		items = (Item[]) new Object[N];
	}
	
	public boolean isEmpty() { return itemsLength == 0; }
		
	@SuppressWarnings("unchecked")
	public void enqueue(Item item) {
		if(itemsLength == N) {
			Item[] newItems = (Item[])new Object[N *= 2];
			for(int i = 0; i < itemsLength; i++) {
				newItems[i+1] = items[i];
			}
			items = newItems;
		}
		else {
			for(int i = itemsLength; i > 0; i--) {
				items[i] = items[i-1];
			}
		}
		items[0] = item;
		itemsLength++;
	}
	
	@SuppressWarnings("unchecked")
	public Item dequeue() {
		if(isEmpty()) return null;
		int i = StdRandom.uniform(0, itemsLength);
		Item deItem = items[i];
		items[i] = items[itemsLength-1];
		items[itemsLength-1] = null;
		itemsLength--;
		if(itemsLength <= N/4) {
			N = N/2;
			Item[] newItems = (Item[])new Object[N];
			for(int j = 0; j < itemsLength; j++) {
				newItems[j] = items[j];
			}
			items = newItems;
		}
		return deItem;
	}
	
	public Item sample() {
		if(isEmpty()) return null;
		return items[StdRandom.uniform(0, itemsLength)];
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator implements Iterator<Item> {

		int i = itemsLength;
		Item[] itItems = Arrays.copyOf(items, itemsLength);
		
		public RandomQueueIterator() {
			StdRandom.shuffle(itItems);
		}
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return itItems[--i];
		}
		
	}
	
	
	public static void main(String[] args) {
		RandomQueue<Card> randomQueue = new RandomQueue<>();
		String[] colors = {"红桃","方块","黑桃","梅花"};
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < 13; i++) {
				randomQueue.enqueue(new Card(colors[j], i+1));
			}
		}
		for(Card card: randomQueue)
			StdOut.println(card);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				StdOut.print(randomQueue.dequeue() + "\t");
			}
			StdOut.println();
		}
	}
}
