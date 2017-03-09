package ex3_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by zhou on 2017/3/9.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> implements Iterable<Key>{

    @Override
    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < N;
            }

            @Override
            public Key next() {
                return (Key)items[i++].key;
            }
        };
    }

    private class Item<Key extends Comparable<Key>, Value>{
        public Key key;
        public Value value;

        public Item(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    private Item[] items;
    private int N;

    public BinarySearchST(int capacity) {
        items = new Item[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int rank(Key key) {
        return rank(key, 0, N-1);
    }

    private int rank(Key key, int lo, int hi) {
        if(hi < lo) return lo;
        int mid = lo + (hi-lo)/2;
        int cmp = key.compareTo((Key)items[mid].key);
        if(cmp < 0) return rank(key, lo, mid-1);
        else if(cmp > 0) return rank(key, mid+1, hi);
        else return mid;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if(i < N && items[i].key.compareTo(key) == 0) {
            items[i].value = value;
            return;
        }
        else {
            if(size() == items.length) {
                StdOut.println("BinarySearchST is full");
                return;
            }
            for(int j = N; j > i; j--) {
                items[j] = items[j-1];
            }
            items[i] = new Item(key, value);
            N++;
        }
    }

    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && items[i].key.compareTo(key) == 0) return (Value)items[i].value;
        else return null;
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> st = new BinarySearchST<>(10);
        for(int i = 0; i < 12; i++) st.put(i, "string"+i);
        for(Integer i : st) StdOut.println(st.get(i));
    }
}
