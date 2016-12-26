package q1_3_39;

import edu.princeton.cs.algs4.StdOut;

/**
 * 				RingBuffer(int N)	新建一个大小为N环形缓冲区
 * 	boolean		isEmpty()			环形区是否为空
 * 	boolean		isFull()			环形区是否已满
 * 	void		enqueue(Item item)	添加一个元素
 * 	Item		dequeue()			取出环形区内最早被添加的元素
 * @author zhou
 *
 */
public class RingBuffer<Item> {
	private int N;
	Item[] items;
	//headIndex指下一次被取出元素的索引，tailIndex指下一次加入元素的索引位置
	int headIndex = 0, tailIndex = 0;
	
	@SuppressWarnings("unchecked")
	public RingBuffer(int N) {
		this.N = N + 1;
		items = (Item[])new Object[this.N];
	}
	
	private int size() {
		int lengthOrigin = tailIndex - headIndex;
		return lengthOrigin >= 0 ? lengthOrigin : lengthOrigin + N;
	}
	
	public boolean isEmpty() { return size() == 0; }
	
	public boolean isFull() { return size() == N-1; }
	
	public void enqueue(Item item) throws RingBufferFullorNullException {
		if(isFull()){
			throw new RingBufferFullorNullException("RingBuffer is full");
		}
		else {
			items[tailIndex] = item;
			tailIndex = tailIndex == N ? 0 : tailIndex+1;
		}
	}
	
	public Item dequeue() throws RingBufferFullorNullException {
		if(isEmpty()) {
			throw new RingBufferFullorNullException("RingBuffer is null");
		}
		else {
			Item deItem = items[headIndex];
			items[headIndex] = null;
			headIndex = headIndex == N ? 0 : headIndex+1;
			return deItem;
		}
	}

	public static void main(String[] args) {
		RingBuffer<String> buffer = new RingBuffer<>(5);
		for(int i = 0 ; i < 8; i++) {
			try {
				buffer.enqueue(""+i);
			} catch (RingBufferFullorNullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 0; i < 8; i++) {
			try {
				StdOut.println(buffer.dequeue());
			} catch (RingBufferFullorNullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
