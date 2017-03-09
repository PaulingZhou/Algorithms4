package ex3_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by zhou on 2017/3/9.
 */
public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> implements Iterable<Key> {
    @Override
    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            Node it = head.next;

            @Override
            public boolean hasNext() {
                return (!isEmpty() && it != null);
            }

            @Override
            public Key next() {
                Node result = it;
                it = it.next;
                return result.key;
            }
        };
    }

    private class Node {
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private int N = 0;
    private Node head;

    public OrderedSequentialSearchST() {
        head = new Node((Key) new Integer(Integer.MIN_VALUE), (Value) new Object());
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int rank(Key key) {
        int i = 0;
        for (Key k : this) {
            if (key.compareTo(k) <= 0) break;
            i++;
        }
        return i;
    }

    public boolean contains(Key key) {
        for (Key k : this) {
            if (key.compareTo(k) == 0) return true;
            else if (key.compareTo(k) < 0) break;
        }
        return false;
    }

    public void put(Key key, Value value) {
        Node it = head;
        while (it.next != null) {
            if(it.next.key.compareTo(key) == 0) it.next.value = value;
            else if(it.next.key.compareTo(key) > 0) break;
            it = it.next;
        }
        {
            Node insert = new Node(key, value);
            insert.next = it.next;
            it.next = insert;
        }
        N++;
    }

    public Value get(Key key) {
        Node it = head;
        while(it.next != null) {
            if(it.next.key.compareTo(key) == 0) return it.next.value;
            else if(it.next.key.compareTo(key) > 0) break;
            it = it.next;
        }
        return null;
    }

    public static void main(String[] args) {
        OrderedSequentialSearchST<Integer, Integer> osST = new OrderedSequentialSearchST<>();
        for(int i = 0; i < 11; i++) {
            osST.put(i, i);
        }
        for(int i : osST) {
            StdOut.println("key: " + i + ", value: " + osST.get(i));
        }
    }


}
