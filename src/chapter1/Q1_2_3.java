package chapter1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Q1_2_3 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);
		Rectangle[] rectangles = new Rectangle[N];
		for(int i = 0; i < N; i++) {
			double x1 = StdRandom.uniform(min, max);
			double x2 = StdRandom.uniform(min, max);
			double y1 = StdRandom.uniform(min, max);
			double y2 = StdRandom.uniform(min, max);
			double x = (x1 + x2) / 2;
			double y = (y1 + y2) / 2;
			double halfWidth = Math.abs((x1 - x2) / 2);
			double halfHeight = Math.abs((y1 - y2) / 2);
			rectangles[i] = new Rectangle(x, y, halfWidth, halfHeight);
			StdDraw.rectangle(x, y, halfWidth, halfHeight);
		}
		int containCount = 0, interCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(Rectangle.isContain(rectangles[i], rectangles[j]) || Rectangle.isContain(rectangles[j], rectangles[i])) containCount++;
				if(Rectangle.isIntersect(rectangles[i], rectangles[j])) interCount++;
			}
		}
		StdOut.println(containCount);
		StdOut.println(interCount);
	}
	

	

}
