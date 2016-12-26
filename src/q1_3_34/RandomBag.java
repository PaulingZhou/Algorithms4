package q1_3_34;

import java.util.Arrays;
import java.util.Iterator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhou
 *				RandomBag()				创建一个空随机背包
 *	boolean		isEmpty()				背包是否为空
 *	int			size()					背包中的元素数量
 *	void		add(Item item)			添加一个元素
 * @param <Item>
 */
public class RandomBag<Item> implements Iterable<Item>{
	int N = 1;
	int itemLength = 0;
	@SuppressWarnings("unchecked")
	Item[] items = (Item[])new Object[N];
	Item[] shuffleItems;
	
	public boolean isEmpty() {
		return itemLength == 0;
	}

	public int size() {
		return itemLength;
	}
	
	@SuppressWarnings("unchecked")
	public void add(Item item) {
		if(itemLength == N) {
			N = N * 2;
			Item[] newItems = (Item[])new Object[N];
			for(int i = 0; i < itemLength; i++) {
				newItems[i] = items[i];
			}
			items = newItems;
		}
		items[itemLength++] = item;
	}
	

	@Override
	public Iterator<Item> iterator() {
		shuffleItems = Arrays.copyOf(items, itemLength);
		StdRandom.shuffle(shuffleItems);
		return new RandomBagIterator();
	}
	
	private class RandomBagIterator implements Iterator<Item> {
		int i = itemLength;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public Item next() {
			return shuffleItems[--i];
		}
		
	}
	
	public static void main(String[] args) {
		RandomBag<String> randomBag = new RandomBag<>();
		for(int i = 0; i < 12; i++) {
			randomBag.add(""+i);
		}
		for(String s : randomBag) {
			StdOut.println(s);
		}
	}

}
