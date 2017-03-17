package ex4_4;

/**
 * Created by zhou on 2017/3/17.
 */
public class DirectedEdge {

    private final int from;
    private final int to;
    private final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", from, to, weight);
    }
}
