package ex4_1;

import java.util.Stack;

/**
 * Created by zhou on 2017/3/12.
 */
public class DepthFirstPaths extends Paths{

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }


    @Override
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for(int x = v; x != s; x = edgeTo[x])
            stack.push(x);
        stack.push(s);
        return stack;
    }
}
