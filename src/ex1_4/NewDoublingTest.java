package ex1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class NewDoublingTest{
	
	private NewDoublingTest() {}
	
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for(int i = 0; i < N; i++) a[i] = StdRandom.uniform(-MAX, MAX);
		Stopwatch timer = new Stopwatch();
		@SuppressWarnings("unused")
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}
	
	public static void rePaint(double[][] points, int count) {
		StdDraw.clear();
		double prePointX = points[0][0];
		double prePointY = points[1][0];
		for(int i = 1; i < count; i++) {
			StdDraw.line(prePointX, prePointY, points[0][i], points[1][i]);
			prePointX = points[0][i];
			prePointY = points[1][i];
		}
	}
	
	public static void main(String[] args) {
		int marginX = 500;
		double marginY = 0.5;
		double[][] previousPos = new double[2][1000];
		int cnt = 0;
		StdDraw.setXscale(0, marginX);
		StdDraw.setYscale(0, marginY);
		double currentX = 0, currentY = 0;
		for(int N = 250; N <= 10000; N+=250) {
			double time = timeTrial(N);
			while(marginX < N) {
				marginX *= 2;
				StdDraw.setXscale(0, marginX);
				rePaint(previousPos, cnt);
			}
			while(marginY < time) {
				marginY *= 2;
				StdDraw.setYscale(0, marginY);
				rePaint(previousPos, cnt);
			}
			if(currentX != 0 && currentY != 0) {
				StdDraw.line(currentX, currentY, N, time);
			}
			currentX = N;
			currentY = time;
			previousPos[0][cnt] = currentX;
			previousPos[1][cnt] = currentY;
			cnt++;
			StdOut.printf("%7d %5.1f\n", N, time);
		}
	}
	
}
