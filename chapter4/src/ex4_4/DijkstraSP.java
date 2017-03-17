package ex4_4;

import edu.princeton.cs.algs4.IndexMinPQ;
import java.util.Stack;

/**
 * Created by zhou on 2017/3/17.
 */
public class DijkstraSP {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int v) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>(G.V());
        for(int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[v] = 0;
        pq.insert(v, distTo[v]);

        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }

    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for(DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if(distTo[w] < distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if(pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return edgeTo[v] != null;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        Stack<DirectedEdge> s = new Stack<>();
        DirectedEdge e = edgeTo[v];
        while(e != null) {
            s.push(e);
            e = edgeTo[e.from()];
        }
        return s;
    }
}
