package chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Q1_1_3 {
	public static void main(String[] args) {
		double[] inputNumbers = new double[3];
		for(int i = 0; i < 3; i++) inputNumbers[i] = StdIn.readDouble();
		if(inputNumbers[0] == inputNumbers[1] && inputNumbers[1] == inputNumbers[2]) StdOut.println("equal");
		else {
			StdOut.println("not equal");
		}
	}
}
