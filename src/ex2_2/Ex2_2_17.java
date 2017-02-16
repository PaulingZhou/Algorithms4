package ex2_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author zhou
 *	实现对链表的自然排序
 */
public class Ex2_2_17 {
	
	private static class Node {
		public Node(Double val) {
			this.val = val;
		}
		public Double val;
		public Node next;
	}
	
	private static Node getRandomList(int N) {
		Node head,tail;
		head = new Node(StdRandom.uniform());
		tail = head;
		for(int i = 1; i < N; i++) {
			Double d = StdRandom.uniform();
			Node newTail = new Node(d);
			tail.next = newTail;
			tail = newTail;
		}
		return head;
	}
	
	// is a less than b?
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	// 遍历链表一遍
	@SuppressWarnings("unused")
	private static void iterateList(Node head) {
		while(head != null) {
			Double val = head.val;
			StdOut.print(val + "\n");
			head = head.next;
		}
		StdOut.println();
	}
	
	//链表规模
	private static int size(Node head) {
		int size = 0;
		while(head != null){
			size++;
			head = head.next;
		}
		return size;
	}
	
	private static Node sort(Node head) {
		int N = size(head);
		Node newHead = new Node(Double.MIN_VALUE);
		newHead.next = head;
		for(int sz = 1; sz < N; sz += sz) {
			Node opBefore = newHead;
			for(int lo = 0; lo < N-sz; lo += sz + sz) {
				opBefore = merge(opBefore, sz);
			}
		}
		return newHead.next;
	}
	
	private static Node merge(Node opBefore, int sz) {
		Node list1Bf = opBefore;
		Node list2Bf = opBefore;
		for(int i = 0; i < sz; i++) list2Bf = list2Bf.next;
		Node endNode = list2Bf;
		int list1Sz = sz;
		int list2Sz = 0;
		for(int i = 0; i < sz; i++) {
			if(endNode != null)	{
				endNode = endNode.next;
				list2Sz++;
			}
		}
		if(endNode == null) list2Sz--;
		endNode = merge(list1Bf, list2Bf, list1Sz, list2Sz);
		return endNode;
	}

	private static Node merge(Node list1Bf, Node list2Bf, int list1Sz, int list2Sz) {
		while(list1Sz > 0 && list2Sz > 0) {
			if(less(list1Bf.next.val, list2Bf.next.val)) {
				list1Sz--;
				list1Bf = list1Bf.next;
			}
			else {
				list2Sz--;
				Node list2Node = list2Bf.next;
				list2Bf.next = list2Node.next;
				list2Node.next = list1Bf.next;
				list1Bf.next = list2Node;
				list1Bf = list1Bf.next;
			}
		}
		if(list1Sz > 0) {
			while(list1Sz-- > 0) list1Bf = list1Bf.next;
			return list1Bf;
		}
		if(list2Sz > 0) {
			while(list2Sz -- > 0) list2Bf = list2Bf.next;
			return list2Bf;
		}
		return null;
	}
	
	private static boolean isSorted(Node head) {
		Double val = Double.MIN_VALUE;
		while(head != null) {
			if(less(head.val, val)) return false;
			else {
				val = head.val;
				head = head.next;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		for(int i = 1; i < 100000; i++) {
			Node head = getRandomList(i);
			head = sort(head);
			if(!isSorted(head)) {
				throw new RuntimeException("wrong sort in " + i);
			}
		}
		StdOut.println("right sort!");
	}
	
}
