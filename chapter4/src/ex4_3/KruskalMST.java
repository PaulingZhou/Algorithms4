package ex4_3;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * Created by zhou on 2017/3/16.
 */
public class KruskalMST implements MST{

    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for(Edge e: G.edges()) pq.insert(e);
        UF uf = new UF(G.V());

        while(!pq.isEmpty() && mst.size() < G.V()-1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if(uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight() {
        double sumWeight = 0.0;
        for(Edge e : this.edges()) sumWeight += e.getWeight();
        return sumWeight;
    }
}
