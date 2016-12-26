package q1_3_40;

import edu.princeton.cs.algs4.StdIn;

public class MoveToFront {

	private static class Node {
		char c;
		Node next;

		public Node(char c) {
			this.c = c;
		}
	}

	public static void main(String[] args) {
		String s = StdIn.readString();
		char[] chars = s.toCharArray();
		Node head = null;
		for (char c : chars) {
			if (head == null) {
				head = new Node(c);
			} else {
				Node current = head;
				if (current.next == null) {
					if (current.c != c) {
						Node newHead = new Node(c);
						newHead.next = head;
						head = newHead;
					}
				} else {
					while (current.next != null) {
						if (current.next.c == c)
							break;
						current = current.next;
					}
					if (current.next != null && current.next.c == c)
						current.next = current.next.next;
					Node newHead = new Node(c);
					newHead.next = head;
					head = newHead;
				}

			}

		}
	}
}
