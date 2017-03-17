package ex4_3;

/**
 * Created by zhou on 2017/3/16.
 */
public class Edge implements Comparable<Edge>{


    private final int v,w;
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int v) {
        if(v == this.v) return w;
        if (v == this.w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(Edge o) {
        return (int) (this.weight - o.weight);
    }

    @Override
    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }

}
