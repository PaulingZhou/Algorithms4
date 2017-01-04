package ex1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex1_4_34 {

	static int correctNum, lastGuess = Integer.MAX_VALUE;

	private static int isHot(int guess) {
		int result = -2;
		if (guess == correctNum)
			result = 0;
		else {
			if (Math.abs(guess - correctNum) < Math.abs(lastGuess - correctNum)) result = 1;
			else result = -1;
			lastGuess = guess;
		}
		return result;
	}

	private static int findNumIn2LgNDetails(int head, int tail) {
		if(isHot(head) == 0) return head;
		int returnCode = isHot(tail);
		if(returnCode == 0) return tail;
		else if(returnCode == 1) return findNumIn2LgNDetails((head+tail) / 2, tail-1);
		else return findNumIn2LgNDetails(head+1, (head + tail)/2);
	}
	
	private static int findNumInLgNDetails(int head, int tail) {
		if(head == tail) return head;
		int mid = (head + tail) / 2;
		int guessNum = mid * 2 - lastGuess;
		int guessNumLarge = guessNum > lastGuess ? 1 : -1;
		int returnCode = isHot(guessNum);
		lastGuess = guessNum;
		if(returnCode == 0) return lastGuess;
		else if(returnCode == 1 && guessNumLarge == 1) return findNumInLgNDetails(mid+1, tail);
		else if(returnCode == 1 && guessNumLarge == -1) return findNumInLgNDetails(head, mid-1);
		else if(returnCode == -1 && guessNumLarge == 1) return findNumInLgNDetails(head, mid);
		else if(returnCode == -1 && guessNumLarge == -1) return findNumInLgNDetails(mid, tail);
		return -1;
	}
	
	static int findNumIn2LgN(int N) {
		return findNumIn2LgNDetails(1, N);
	}
	
	static int findNumInLgN(int N) {
		isHot(1);
		lastGuess = 1;
		return findNumInLgNDetails(1, N);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 1000000; i++) {
			correctNum = StdRandom.uniform(1, 1000);
			int result1 = findNumInLgN(1000);
			int result2 = findNumIn2LgN(1000);
			if(result1 != correctNum) throw new RuntimeException("wrong calculation at function findNumInLgN()!");
			if(result2 != correctNum) throw new RuntimeException("wrong calculation at function findNumIn2LgN()!");
		}
		StdOut.println("pass!");
	}

}
