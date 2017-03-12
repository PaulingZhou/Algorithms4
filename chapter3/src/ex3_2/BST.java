package ex3_2;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by zhou on 2017/3/10.
 */
public class BST <Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {

        private Key key;
        private Value val;
        private Node left,right;
        private int N;
        private int height;

        public Node(Key key, Value val, int n, int height) {
            this.key = key;
            this.val = val;
            N = n;
            this.height = height;
        }

    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if(node == null) return 0;
        else return node.N;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) return get(key, node.left);
        else if(cmp > 0) return get(key, node.right);
        else return node.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node node, Key key, Value val) {
        if(node == null) return new Node(key, val, 1, 0);
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = put(node.left, key, val);
        else if(cmp > 0) node.right = put(node.right, key, val);
        else node.val = val;
        node.N = size(node.left) + size(node.right) + 1;
        node.height = Math.max(node.left.height, node.right.height) + 1;
        return node;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if(node.left == null) return node;
        return min(node.left);
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if(node.right == null) return node;
        return max(node.right);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if(node == null) return null;
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) return floor(node.left, key);
        else if(cmp > 0) {
            Node t = floor(node.right, key);
            if(t != null) return t;
        }
        return node;
    }
    
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node node, int k) {
        if(node == null) return null;
        int size = size(node.left);
        if(size > k) return select(node.left, k);
        else if(size < k) return select(node.right, k-size-1);
        else return node;
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) return rank(key, node.left);
        else if(cmp > 0) return size(node.left) + 1 + rank(key, node.right);
        else return size(node.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        node.height = Math.max(node.left.height, node.right.height) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = delete(node.left, key);
        else if(cmp > 0) node.right = delete(node.right, key);
        else {
            if(node.left == null) return node.right;
            if(node .right == null) return node.left;
            Node t = node;
            node = min(t.right);
            node.left = t.left;
            node.right = deleteMin(t.right);
        }
        node.N = size(node.left) + size(node.right) + 1;
        node.height = Math.max(node.right.height, node.left.height) + 1;
        return node;
    }

    private void print(Node node) {
        if(node == null) return;
        print(node.left);
        StdOut.println(node.key);
        print(node.right);
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
        if(node == null) return;
        int cmplo = lo.compareTo(node.key);
        int cmphi = hi.compareTo(node.key);
        if(cmplo < 0) keys(node.left, queue, lo, hi);
        if(cmplo <= 0 && cmphi >= 0) queue.enqueue(node.key);
        if(cmphi > 0) keys(node.right, queue, lo, hi);
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public int height_selconst() {
        return height_selconst(root);
    }

    private int height_selconst(Node node) {
        return node.height;
    }





}
