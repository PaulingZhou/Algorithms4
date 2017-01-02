package ex1_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex1_4_23 {
	
	static int getGCD(int p, int q) {
		while(p % q != 0) {
			int m = p % q;
			p = q;
			q = m;
		}
		return q;
	}
	
	static boolean compare(double a, double b) {
		return a < b;
	}
	
	static int guessNum(double num, int N) {
		int start = 0, end = N*N;
		int result = -1;
		while(start < end) {
			int mid = (start + end) / 2;
			double lowNum = (double) mid / (N*N);
			double highNum = (double) (mid+1) / (N*N);
			if(compare(lowNum, num) && !compare(highNum, num)) {
				result = mid;
				break;
			}
			else if(!compare(lowNum, num)) end = mid;
			else if(compare(highNum, num)) start = mid+1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		int m = StdRandom.uniform(N);
		int n = StdRandom.uniform(N);
		
		int p = Math.max(m, n);
		int q = Math.min(m, n);
		int resolution = (int)Math.log10(N*N)+1;
		StdOut.printf("generate random number is %d/%d~%."+resolution+"f\n", q/getGCD(p, q), p/getGCD(p, q), (double)q/p);
		int guessNum = guessNum((double)q/p, N);
		StdOut.printf("guess number is between (%d/%d~%."+resolution+"f, %d/%d~%."+resolution+"f\n]", guessNum, N*N, (double)guessNum/(N*N), guessNum+1, N*N, (double)(guessNum+1)/(N*N));
	}
}
