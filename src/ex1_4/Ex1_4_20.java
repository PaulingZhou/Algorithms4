package ex1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex1_4_20 {
	static int getLargestIndex(int[] a) {
		int head = 0, tail = a.length-1;
		int mid = (head + tail) / 2;
		while(head < tail) {
			if(mid == 0 || mid == a.length -1) throw new RuntimeException("非双调数组");
			else {
				if(a[mid] > a[mid-1] && a[mid] > a[mid+1]) break;
				else if(a[mid] < a[mid-1]) tail = mid - 1;
				else if(a[mid] < a[mid+1]) head = mid + 1;
				mid = (head + tail) / 2;
			}
		}
		return mid;
	}
	
	static int getNumIndexAd(int num, int[] a, int largeIndex) {
		int index = -1;
		int head = 0, tail = largeIndex;
		int mid = (head + tail) / 2;
		while(head < tail) {
			if(a[mid] == num) {
				index = mid;
				break;
			}
			else if(a[mid] > num) {
				tail = mid - 1;
				mid = (head + tail) / 2;
			}
			else if(a[mid] < num) {
				head = mid + 1;
				mid = (head + tail) / 2;
			}
		}
		return index;
	}
	
	static int getNumIndexDe(int num, int[] a, int largeIndex) {
		int index = -1;
		int head = largeIndex + 1, tail = a.length - 1;
		int mid = (head+tail)/2;
		while(head < tail) {
			if(a[mid] == num) {
				index = mid;
				break;
			}
			else if(a[mid] < num) {
				tail = mid - 1;
				mid = (head+tail)/2;
			}
			else if(a[mid] > num) {
				head = mid + 1;
				mid = (head+tail)/2;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/Ex1.4.20.txt").readAllInts();
		int num = StdIn.readInt();
		int largeIndex = getLargestIndex(a);
		int adIndex = getNumIndexAd(num, a, largeIndex);
		int deIndex= getNumIndexDe(num, a, largeIndex);
		String adPattern = adIndex == -1 ? "" : "%d位于数组第%d位\n";
		String dePattern = deIndex == -1 ? "" : "%d位于数组第%d位\n";
		if(adIndex != -1) StdOut.printf(adPattern, num, adIndex);
		if(deIndex != -1) StdOut.printf(dePattern, num, deIndex);
		if((adPattern + dePattern).equals("")) StdOut.printf("%d不位于该数组中", num);
	}
	
}
