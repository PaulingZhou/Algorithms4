package ex4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by zhou on 2017/3/16.
 */
public class LazyPrimMST implements MST{

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>();
        mst = new Queue<>();
        marked = new boolean[G.V()];

        visit(G, 0);
        while(!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.enqueue(e);
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);
        }

    }

    public void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v))
            if(!marked[e.other(v)])
                pq.insert(e);
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0.0;
        for(Edge e : this.edges()) weight += e.getWeight();
        return weight;
    }

}
