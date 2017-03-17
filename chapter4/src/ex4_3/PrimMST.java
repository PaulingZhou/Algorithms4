package ex4_3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Arrays;

/**
 * Created by zhou on 2017/3/16.
 */
public class PrimMST implements MST{

    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for( int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(G.V());
        distTo[0] = 0.0;
        pq.insert(0, 0.0);


    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;

        for(Edge e : G.adj(v)) {
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.getWeight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.getWeight();
                if(pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
//        Bag<Edge> b = new Bag<>();
        return Arrays.asList(edgeTo);
    }

    public double weight() {
        double weightSum = 0.0;
        for(Edge e : this.edges()) weightSum += e.getWeight();
        return weightSum;
    }
}
