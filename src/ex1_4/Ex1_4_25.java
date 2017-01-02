package ex1_4;

public class Ex1_4_25 {

	private static class Info {
		public Info(int expNum, int brkNum, int floor) {
			this.expNum = expNum;
			this.floor = floor;
		}
		int expNum;
		int brkNum;
		int floor;
	}

	static Info getInfoSqrtN(int N, int F) {
		int floor = 0, expNum = 0, brkNum = 0;
		int n = (int)Math.sqrt(N);
		for(int i = 0; i < n+10; i++) {
			expNum++;
			if(floor < F) {
				floor += n;
				continue;
			}
			else if(floor > F) {
				brkNum++;
				break;
			}
		}
		for(int i = 0; i < n+1; i++) {
			expNum++;
			if(floor-n+i == F) {
				brkNum++;
				floor = floor-n+i;
				break;
			}
			else if(floor-n+i > F) {
				brkNum++;
			}
			else if(floor-n+i < F) {
				continue;
			}
		}
		return new Info(expNum, brkNum, floor);
	}
	
	static Info getInfoSqrtF(int N, int F) {
		int floor = 1;
		int expNum = 0, brkNum = 0;
		int i = 0;
		for(i = 0; i < Math.sqrt(2*F) + 1; i++) {
			expNum++;
			if(floor + i < F) {
				floor = floor + i;
			}
			else {
				brkNum++;
				break;
			}
		}
		for(int j = 0; j < i; j++) {
			expNum++;
			if(++floor < F) {
				continue;
			}
			else if(floor == F) {
				brkNum++;
				break;
			}
			else if(floor > F){
				brkNum++;
			}
		}
		return new Info(expNum, brkNum, floor);
	}

	public static void main(String[] args) {
		for(int i = 1; i < 10000; i+=1) {
			/** test sqrtN **/
			if(getInfoSqrtN(i, i).floor != i) throw new RuntimeException("wrong floor!" + getInfoSqrtF(i, i).floor + i);
			if(getInfoSqrtN(i, i).brkNum > 2) throw new RuntimeException("too more break eggs!");
			/** test sqrtF **/
			if(getInfoSqrtF(i, i).floor != i) throw new RuntimeException("wrong floor!" + getInfoSqrtF(i, i).floor + i);
			if(getInfoSqrtF(i, i).brkNum > 2) throw new RuntimeException("too more break eggs!");
		}
	}

}
