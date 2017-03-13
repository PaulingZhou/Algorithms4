package ex4_1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by zhou on 2017/3/12.
 */
public class Graph {

    private final int V;                // 顶点数目
    private int E;                      // 边的数目
    private Bag<Integer>[] adj;           // 邻接表

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for(int i = 0; i < V; i++) {
            for(int j : G.adj(i)) addEdge(i, j);
        }
    }

    public int E() {
        return E;
    }

    public int V() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public boolean hasEdge(int v, int w) {
        for(int i : adj[v])
            if(i == w) return true;
        return false;
    }

}
