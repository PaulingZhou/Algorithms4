package ex1_5;

public class HeightWeightedQuickUnionUF extends QuickUnionUF{

	private int[] height;
	
	public HeightWeightedQuickUnionUF(int N) {
		super(N);
		height = new int[N];
	}

	@Override
	public void union(int p, int q) {
		int pRoot = super.find(p);
		int qRoot = super.find(q);
		if(pRoot == qRoot) return;
		if(height[pRoot] > height[qRoot]) super.id[qRoot] = pRoot;
		else super.id[pRoot] = qRoot;
		count--;
	}
}
