package q1_3_12;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
//	与原栈位置相反
public class Q1_3_12 {
	static Stack<String> copy(Stack<String> stack) {
		Stack<String> stack2 = new Stack<>();
		for(String s : stack) stack2.push(s);
		return stack2;
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("a");
		stack.push("e");
		stack.push("i");
		stack.push("o");
		stack.push("u");
		Stack<String> stack2 = copy(stack);
		for(String s : stack2) StdOut.println(s);
	}
}
