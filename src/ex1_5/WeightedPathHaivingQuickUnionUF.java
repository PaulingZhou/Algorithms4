package ex1_5;

public class WeightedPathHaivingQuickUnionUF extends WeightedQuickUnionUF{

	public WeightedPathHaivingQuickUnionUF(int N) {
		super(N);
	}

	@Override
	public int find(int p) {
		while(id[p] != p) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	
	
}
