package ex4_4;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.*;


/**
 * Created by zhou on 2017/3/17.
 */
public class BellmanFordSP {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private boolean[] onQ;
    private Queue<Integer> queue;
    private int cost = 0;
    private Iterable<DirectedEdge> cycle;

    public BellmanFordSP(EdgeWeightedDigraph G, int v) {
        distTo = new double[G.V()];
        edgeTo = new DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new Queue<>();
        for(int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[v] = 0.0;
        onQ[v] = true;
        queue.enqueue(v);
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int s = queue.dequeue();
            onQ[s] = false;
            relax(G, s);
        }
    }

    private void relax(EdgeWeightedDigraph G, int s) {
        for(DirectedEdge e : G.adj(s)) {
            int to = e.to();
            if(distTo[to] > distTo[s] + e.weight()) {
                distTo[to] = distTo[s] + e.weight();
                edgeTo[to] = e;
                if(!onQ[to]) {
                    queue.enqueue(to);
                    onQ[to] = true;
                }
            }
        }
        if(cost++ % G.V() == 0) findNegativeCycle();
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

    private void findNegativeCycle() {
        int v = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(v);
        for(int i = 0; i < v; i++) {
            if(edgeTo[i] != null) spt.addEdge(edgeTo[i]);
        }
    }

    private boolean hasNegativeCycle() {
        return true;
    }
}

class EdgeWeightedCycleFinder {

    //TODO unfinished

    Queue<DirectedEdge> queue;
    boolean[] marked;

    public EdgeWeightedCycleFinder(EdgeWeightedDigraph G) {
        queue = new Queue<>();
        marked = new boolean[G.V()];
        for(int i = 0; i < G.V(); i++) {
            if(G.indegree(i) != 0) continue;
            for(DirectedEdge e : G.adj(i)) {
                DirectedEdge it = e;
                while(it != null) {
                    if(!marked[it.to()]) {
                        queue.enqueue(it);
                        marked[it.to()] = true;
                    }
                }
            }
        }
    }
}
