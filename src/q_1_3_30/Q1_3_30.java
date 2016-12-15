package q_1_3_30;

public class Q1_3_30 {
	
	public static void main(String[] args) {
		Node head = new Node("0");
		Node current = head;
//		construct LinkedList
		for(int i = 1; i < 5; i++) {
			current.next = new Node(""+i);
			current = current.next;
		}
//		reverse iterable
		Node reverse = null, first, second;
		first = head;
		while (first != null) {
			second = first.next;
			first.next = reverse;
			reverse = first;
			first = second;
		}
	}
}
