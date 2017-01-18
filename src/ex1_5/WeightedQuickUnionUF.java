package ex1_5;

public class WeightedQuickUnionUF extends QuickUnionUF{

	protected int[] sz;	//（由触点索引的）各个根节点所对应的分量大小
	
	public WeightedQuickUnionUF(int N) {
		super(N);
		sz = new int[N];
		for(int i = 0; i < N; i++) sz[i] = i;
	}

	@Override
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if(i == j) return;
		if(sz[i] < sz[j]) { id[i] = j; sz[j]+=sz[i]; }
		else {id[j] = i; sz[i] += sz[j];}
		count--;
	}
	
}
