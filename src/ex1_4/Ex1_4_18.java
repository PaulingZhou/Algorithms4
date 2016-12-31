package ex1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex1_4_18 {
	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/1Kints.txt").readAllInts();
		int head = 0, tail = a.length-1;
		int mid = -1;
		while(head < tail) {
			mid = (head+tail)/2;
			if(mid == 0 && a[mid] < a[mid+1]) break;
			else if(mid == a.length-1 && a[mid] < a[mid-1]) break;
			else {
				if(a[mid] < a[mid-1] && a[mid] < a[mid+1]) break;
				else if(a[mid] > a[mid-1]) tail = mid - 1;
				else if(a[mid] > a[mid+1]) head = mid + 1;
			}
		}
		StdOut.printf("the local lowest number is %d in %d", a[mid], mid);
	}
}
