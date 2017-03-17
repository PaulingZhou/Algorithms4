package ex4_3;

import edu.princeton.cs.algs4.Bag;

import java.util.Iterator;

/**
 * Created by zhou on 2017/3/16.
 */
public class EdgeWeightedGraph {

    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int i = 0; i < V; i++) adj[i] = new Bag<>();
    }

    public int V() {return V;}

    public int E() {return E;}

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        Bag<Edge> b = new Bag<>();
        for(int v = 0; v < V; v++) {
            for(Edge e : adj[v]) if(v < e.other(v)) b.add(e);
        }
        return b;
    }
}
