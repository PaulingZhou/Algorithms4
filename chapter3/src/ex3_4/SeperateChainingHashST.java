package ex3_4;

/**
 * Created by zhou on 2017/3/12.
 * 拉链法散列表数据结构
 * 使用链表Node类构建
 */
public class SeperateChainingHashST<Key, Value> {

    private class Node{
        Key key;
        Value value;
        Node next;
        int insertCount;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            insertCount = 1;
        }

    }

    private Node[] heads;
    private int M;
    private int N;

    public SeperateChainingHashST() {
        this(997);
    }

    public SeperateChainingHashST(int M) {
        heads = new SeperateChainingHashST.Node[M];
        this.M = M;
    }

    private int hash(Key key) {
        return ( key.hashCode() & 0x7fffffff ) % M;
    }

    public void put(Key key, Value value) {
        int i = hash(key);
        Node itNode = heads[i];
        if(itNode == null) itNode = new Node(key, value);
        else {
            while (itNode != null) {
                if(itNode.key.equals(key)) {
                    itNode.value = value;
                    itNode.insertCount++;
                    return;
                }
                else if(itNode.next != null) itNode = itNode.next;
                else break;
            }
            itNode.next = new Node(key, value);
        }
    }

    public Value get(Key key) {
        int i = hash(key);
        Node itNode = heads[i];
        while(itNode != null) {
            if(itNode.key.equals(key)) return itNode.value;
            else itNode = itNode.next;
        }
        return null;
    }

    public void deleteMuchInsert(int k) {
        for(int i = 0; i < M; i++) {
            while(heads[i] != null) {
                if(heads[i].insertCount > k) heads[i] = heads[i].next;
                else break;
            }
            Node itNode = heads[i];
            while(itNode != null && itNode.next != null) {
                if(itNode.next.insertCount > k) itNode.next = itNode.next.next;
            }
        }
    }

}
