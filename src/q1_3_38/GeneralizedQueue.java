package q1_3_38;

import edu.princeton.cs.algs4.StdOut;

public class GeneralizedQueue<Item> {
	int N = 1;
	int itemsLength = 0;
	@SuppressWarnings("unchecked")
	Item[] items = (Item[])new Object[N];

	public boolean isEmpty() { return itemsLength == 0; }
	
	@SuppressWarnings("unchecked")
	public void insert(Item x) {
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
		items[0] = x;
		itemsLength++;
	}
	
	@SuppressWarnings("unchecked")
	public Item delete(int k) {
		if(isEmpty() || k > itemsLength || k <= 0) return null;
		Item delItem = items[k-1];
		for(int i = k-1; i < itemsLength-1; i++) items[i] = items[i+1];
		items[itemsLength-1] = null;
		itemsLength--;
		if(itemsLength <= N/4) {
			N = N / 2;
			Item[] newItem = (Item[])new Object[N];
			for(int i = 0; i < itemsLength; i++) newItem[i] = items[i];
			items = newItem;
		}
		return delItem;
	}
	
	public static void main(String[] args) {
		GeneralizedQueue<String> queue = new GeneralizedQueue<>();
		for(int i = 1; i <= 5; i++) {
			queue.insert(""+i);
		}
		for(int i = 5; i > 0; i--) {
			StdOut.println(queue.delete(i));
		}
	}
}
