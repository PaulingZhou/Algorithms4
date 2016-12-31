package ex1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex1_4_19 {

	private static class Value {

		public Value(Value X) {
			this.value = X.value;
			this.x = X.x;
			this.y = X.y;
		}

		public Value(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}

		public void changeValue(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}

		int value;
		int x;
		int y;

		@Override
		public String toString() {
			return "x=" + x + "y=" + y + "value=" + value;
		}
	}

	private static Value getMinVal(Value X, int xUp, int xDown, int xLeft, int xRight) {
		Value minVal = new Value(X);
		if (minVal.value > xUp)
			minVal.changeValue(xUp, minVal.x, minVal.y - 1);
		if (minVal.value > xDown)
			minVal.changeValue(xDown, minVal.x, minVal.y + 1);
		if (minVal.value > xLeft)
			minVal.changeValue(xLeft, minVal.x - 1, minVal.y);
		if (minVal.value > xRight)
			minVal.changeValue(xRight, minVal.x + 1, minVal.y);
		return minVal;
	}

	public static void main(String[] args) {
		int[] a = new In("src/ex1_4/1Kints.txt").readAllInts();
		final int[][] newA = new int[30][30];
		int cnt = 0;
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 30; j++) {
				newA[i][j] = a[cnt++];
			}
		}
		int y = newA.length / 2;
		int x = newA[0].length / 2;
		Value curValue = new Value(newA[x][y], x, y);
		int valueUp, valueDown, valueLeft, valueRight;
		while (true) {
			valueUp = y == 0 ? Integer.MAX_VALUE : newA[x][y - 1];
			valueDown = y == newA.length - 1 ? Integer.MAX_VALUE : newA[x][y + 1];
			valueLeft = x == 0 ? Integer.MAX_VALUE : newA[x - 1][y];
			valueRight = x == newA[0].length - 1 ? Integer.MAX_VALUE : newA[x + 1][y];
			Value minVal = getMinVal(curValue, valueUp, valueDown, valueLeft, valueRight);
			if (curValue.toString().equals(minVal.toString()))
				break;
			else {
				curValue = minVal;
				y = curValue.y;
				x = curValue.x;
			}
		}
		StdOut.println(curValue);
		StdOut.printf("up=%d, down=%d, left=%d, right=%d", newA[curValue.x - 1][curValue.y],
				newA[curValue.x + 1][curValue.y], newA[curValue.x][curValue.y - 1], newA[curValue.x][curValue.y + 1]);
	}
}
