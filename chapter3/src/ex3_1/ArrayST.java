package ex3_1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by zhou on 2017/3/9.
 */
public class ArrayST<Key extends Comparable<Key>, Value> implements Iterable<Key>{

    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public ArrayST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int rank(Key key) {
        int index = 0;
        while(index < N) {
            if(key.equals(keys[index])) break;
            index++;
        }
        return index;
    }

    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N) return values[i];
        else return null;
    }

    public void put(Key key, Value value) {
        if(N == keys.length) {
            StdOut.println("ST is full.");
            return;
        }
        int i = rank(key);
        if(i < N) {
            values[i] = value;
        }
        else {
            N++;
            keys[i] = key;
            values[i] = value;
        }
    }

    public void delete(Key key) {
        int i = rank(key);
        if(i < N) {
            for(int j = i; j < N; j++) {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
        }
        else {
            StdOut.println("not contain key");
        }
    }

    public boolean contains(Key key) {
        int i = rank(key);
        return i < N;
    }


    @Override
    public Iterator<Key> iterator() {
        return new STArrayIterator();
    }

    private class STArrayIterator implements Iterator<Key> {

        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < N;
        }

        @Override
        public Key next() {
            return keys[i++];
        }
    }

    public static void main(String[] args) {
        ArrayST<String, Integer> arrayST = new ArrayST<>(10);
        for(int i = 0; i < 11; i++) {
            arrayST.put(""+i, i);
        }
        for(String i : arrayST) {
            StdOut.println("key: " + i + ", value: " + arrayST.get(i));
        }
    }

}
