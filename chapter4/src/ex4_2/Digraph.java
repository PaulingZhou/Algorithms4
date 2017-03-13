package ex4_2;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhou on 2017/3/13.
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int v) {
        V = v;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i++) adj[i] = new Bag<>();
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++) {
            int w = in.readInt();
            int v = in.readInt();
            addEdge(w, v);
        }
    }

    public void addEdge(int w, int v) {
        adj[w].add(v);
        this.E++;
    }

    public int V() { return V; }

    public int E() { return E; }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for(int v = 0; v < V; v++) {
            s += v + ": ";
            for(int w : adj[v]) s += w + " ";
            s += "\n";
        }
        return s;
    }

    public static void main(String[] args) {
        Digraph d = new Digraph(new In("case_example/"+args[0]));
        StdOut.println(d);
    }
}
