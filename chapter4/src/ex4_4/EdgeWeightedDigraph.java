package ex4_4;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by zhou on 2017/3/17.
 */
public class EdgeWeightedDigraph {

    private final int V;
    private int E;
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        E = 0;
        adj = (Bag<DirectedEdge>[]) new Bag[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        Bag<DirectedEdge> b = new Bag<>();
        for(int i = 0; i < V; i++) {
            for(DirectedEdge e : adj[i]) b.add(e);
        }
        return b;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d\n", V));
        sb.append(String.format("%d\n", E));
        for (DirectedEdge e : this.edges()) {
            sb.append(String.format("%s\n", e));
        }
        return sb.toString();
    }


}
