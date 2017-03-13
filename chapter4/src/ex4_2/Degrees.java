package ex4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by zhou on 2017/3/13.
 */
public class Degrees {

    private Digraph G;
    private Integer[] inDegree;
    private Integer[] outDegree;

    public Degrees(Digraph G) {
        this.G = G;
        inDegree = new Integer[G.V()];
        outDegree = new Integer[G.V()];
        for(int i = 0; i < G.V(); i++) {
            inDegree[i] = 0;
            outDegree[i] = 0;
        }
        for(int w = 0; w < G.V(); w++) {
            for(int v : G.adj(w)) {
                inDegree[v]++;
                outDegree[w]++;
            }
        }
    }

    public int indegree(int v) {
        return inDegree[v];
    }

    public int outdegree(int v) {
        return outDegree[v];
    }

    public Iterable<Integer> sources() {
        return Arrays.asList(outDegree);
    }

    public Iterable<Integer> sinks() {
        return Arrays.asList(inDegree);
    }

    public boolean isMap() {
        for(int i : outDegree) if(i != 1) return false;
        return true;
    }

    public static void main(String[] args) {
        Digraph d = new Digraph(new In("case_example/" + args[0]));
        StdOut.println(d);
        Degrees degrees = new Degrees(d);
        for(int i : degrees.sources()) StdOut.println(i);
    }
}
