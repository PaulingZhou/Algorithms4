package q1_3_9;

import java.util.Arrays;
import java.util.HashSet;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q1_3_9 {
	public static void main(String[] args) {
		Stack<String> op = new Stack<>();
		Stack<String> val = new Stack<>();
		HashSet<String> opSet = new HashSet<>();
		opSet.addAll(Arrays.asList("+","-","*","/"));
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if(s.equals("("))	;
			else if(opSet.contains(s)) op.push(s);
			else if(s.equals(")")) {
				String s1 = val.pop();
				String newEle = String.format("( %s %s %s )", val.pop(), op.pop(), s1);
				val.push(newEle);
			}
			else {
				try {
					Integer.parseInt(s);
				} catch (Exception e) {
					StdOut.println("incorrect expression: wrong number");
					System.exit(-1);
				}
				val.push(s);
			}
		}
		StdOut.println(val.size() == 1 ? val.pop() : "incorrect expression: parentheses cannot match");
	}
}
