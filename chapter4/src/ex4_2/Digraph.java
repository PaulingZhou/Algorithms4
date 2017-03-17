package ex4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zhou on 2017/3/13.
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private boolean[] onStack;
    private boolean[] marked;

    public Digraph(int v) {
        V = v;
        E = 0;
        onStack = new boolean[V];
        marked = new boolean[V];
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) adj[i] = new Bag<>();
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int w = in.readInt();
            int v = in.readInt();
            addEdge(w, v);
        }
    }

    public Digraph(Digraph G) {
        this(G.V());
        E = G.E();
        for(int i = 0; i < E; i++) {
            for(int w : G.adj(i)) adj[i].add(w);
        }
    }

    public void addEdge(int w, int v) {
        //不允许平行边和自环
        if(v == w) return;                          //自环
        for(int i : adj[w]) if(i == v) return;      //平行边
        adj[w].add(v);
        this.E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public boolean hasEdge(int v, int w) {
        for(int i : adj[v]) if(w == i) return true;
        return false;
    }

    public boolean isTopoLogical() {
        for(int i = 0; i < V; i++) {
            if(!isTopoLogical(i)) return false;
        }
        return true;
    }

    private boolean isTopoLogical(int v) {
        if(onStack[v]) return false;
        if(marked[v]) return true;
        marked[v] = true;
        onStack[v] = true;
        for(int i : adj[v]) if(!marked[v]) isTopoLogical(i);
        onStack[v] = false;
        return true;
    }


    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : adj[v]) s += w + " ";
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Digraph d = new Digraph(new In("case_example/" + args[0]));
        StdOut.println(d);
        Digraph d1 = new Digraph(d);
        StdOut.println(d1);
    }

}
