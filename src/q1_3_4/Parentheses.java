package q1_3_4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		while (!StdIn.isEmpty()) {
			String item = ""+StdIn.readChar();
			if (item.equals("(") || item.equals("[") || item.equals("{"))
				stack.push(item);
			else {
				if ((!stack.isEmpty()) && ((item.equals(")") && stack.pop().equals("("))
						|| (item.equals("]") && stack.pop().equals("["))
						|| (item.equals("}") && stack.pop().equals("{")))) {;
				} else {
					StdOut.println("false");
					return;
				}
			}
		}
		StdOut.println(stack.isEmpty() ? "true" : "false");
	}
}
