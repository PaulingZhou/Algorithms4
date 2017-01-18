package ex2_1;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Animation{

	public static void animate(@SuppressWarnings("rawtypes") Comparable[] a) {
		StdDraw.clear();
		int N = a.length;
		for(int i = 0; i < N; i++) {
			double x = 1.0 * i;
			double y = (double)a[i] / 2;
			double rw = 0.5;
			double rh = (double)a[i] / 2;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		StdDraw.pause(200);
		StdDraw.pause(100);
	}
	
	public static void animate(@SuppressWarnings("rawtypes") Comparable[] a, int sortedNum) {
		StdDraw.clear();
		int N = a.length;
		for(int i = 0; i < N; i++) {
			if(i < sortedNum) StdDraw.setPenColor(Color.RED);
			else StdDraw.setPenColor(Color.BLACK);
			double x = 1.0 * i;
			double y = (double)a[i] / 2;
			double rw = 0.5;
			double rh = (double)a[i] / 2;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
		StdDraw.pause(200);
		StdDraw.pause(100);
	}
	
	public static Double[] getRandomArray(int N) {
		Double[] array = new Double[N];
		for(int i = 0; i < N; i++) array[i] = StdRandom.uniform();
		return array;
	}
	
	public static void main(String[] args) {
		Double[] array = getRandomArray(50);
		StdDraw.setXscale(-1, 51);
		animate(array);
	}
	
}
