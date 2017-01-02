package ex1_4;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex1_4_24 {

	private static class Info {
		
		public Info(int expNum, int brkNum, int floor) {
			this.expNum = expNum;
			this.brkNum = brkNum;
			this.floor = floor;
		}
		
		int expNum;
		int brkNum;
		int floor;
	}
	
	static Info getInfoLogN(int N, int F) {
		int start = 1, end = N;
		int expNum = 0, brkNum = 0;
		int floor = 1;
		while(start <= end) {
			expNum++;
			int mid = (start + end) / 2;
			if(mid == F) {
				brkNum++;
				floor = mid;
				break;
			}
			else if(mid < F) {
				start = mid + 1;
			}
			else if(mid > F) {
				end = mid - 1;
				brkNum++;
			}
		}	
		return new Info(expNum, brkNum, floor);
	}
	
	static Info getInfoLogF(int N, int F) {
		return getInfoLogF(0, N, F, new Info(0, 0, -1));
	}
	
	private static Info getInfoLogF(int offset, int upBound, int F, Info info) {
		int ascendFloor = 1;
		while(true) {
			info.expNum++;
			if(offset + ascendFloor == F) {
				info.brkNum++;
				info.floor = offset + ascendFloor;
				break;
			}
			else if(offset + ascendFloor > F) {
				info.brkNum++;
				return getInfoLogF(offset + ascendFloor / 2, ascendFloor, F, info);
			}
			else if(offset + ascendFloor < F) {
				ascendFloor *= 2;
				ascendFloor = ascendFloor > upBound ? upBound : ascendFloor;
			}
		}
		return info;
	}
	
	public static void main(String[] args) {
	
		StdOut.print("1. logN\n2. logF\n");
		int sel = StdIn.readInt();
		
		/** logN test **/
		if(sel == 1) {
			for(int i = 1; i < 10000; i+=50) {
				int N = i;
				int expCnt = 0;
				int accExpNum = 0, accBrkNum = 0;
				while((expCnt++) < N) {
					int F = StdRandom.uniform(1, N+1);
					Info infoLogN = getInfoLogN(N, F);
					if(infoLogN.floor != F) throw new RuntimeException("wrong floor!");
					accExpNum += infoLogN.expNum;
					accBrkNum += infoLogN.brkNum;
				}
				StdDraw.setXscale(0, 10000);
				StdDraw.setYscale(0, 20);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.point(N, (double)accExpNum/N);
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.point(N, (double)accBrkNum/N);
			}
		}
		
		/** logF test **/
		if(sel == 2) {
			StdDraw.setXscale(0, 100000);
			StdDraw.setYscale(0, 100);
			for(int i = 1; i < 100000; i+= 50) {
				Info infoLogF = getInfoLogF(Integer.MAX_VALUE, i);
				if(infoLogF.floor != i) throw new RuntimeException("wrong floor");
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.point(i, infoLogF.expNum);
				StdDraw.setPenColor(StdDraw.RED);
				StdDraw.point(i, infoLogF.brkNum);
			}
		}
	}
}
