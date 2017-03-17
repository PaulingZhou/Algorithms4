package ex4_4;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Topological;


/**
 * Created by zhou on 2017/3/17.
 */
public class AcyclicSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;

    public AcyclicSP(EdgeWeightedDigraph G, int v) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        for(int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[v] = 0;

        Topological top = new Topological(G);

        for(int w : top.order()) {
            relax(G, w);
        }
    }

    public void relax(EdgeWeightedDigraph G, int v) {
        for(DirectedEdge e : G.adj(v)) {
            int to = e.to();
            if(distTo[to] > distTo[v] + e.weight()) {
                distTo[to] = distTo[v] + e.weight();
                edgeTo[v] = e;
            }
        }
    }

    public double distTo(int v) {return distTo[v];}

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
