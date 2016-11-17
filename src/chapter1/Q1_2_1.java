package chapter1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Q1_2_1 {
	private final double x;
	private final double y;
		
	Q1_2_1(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
		StdDraw.setXscale(0,1);
		StdDraw.setYscale(0,1);
		StdDraw.setPenRadius(0.01);
		int N = Integer.parseInt(args[0]);
		double minDistance = 1.414;
		Q1_2_1 minPoint1 = new Q1_2_1(0,0);
		Q1_2_1 minPoint2 = new Q1_2_1(1,1);
		Q1_2_1[] points = new Q1_2_1[N];
		for(int i = 0; i < N; i++) {
			points[i] = new Q1_2_1(StdRandom.uniform(),StdRandom.uniform());
			StdDraw.point(points[i].x, points[i].y);
			if(i >= 1) {
				for(int j = 0; j < i; j++) {
					if(minDistance > getDistance(points[i], points[j])) {
						minDistance = getDistance(points[i], points[j]);
						minPoint1 = points[i];
						minPoint2 = points[j];
					}
				}
			}
		}
		StdOut.println(minPoint1);
		StdOut.println(minPoint2);
		StdOut.println(minDistance);
	}
	
	private static double getDistance(Q1_2_1 p0, Q1_2_1 p1) {
		return Math.sqrt(Math.pow((p0.x-p1.x), 2) + Math.pow((p0.y-p1.y), 2));
	}
	
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}
}
