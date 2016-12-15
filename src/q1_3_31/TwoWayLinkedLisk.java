package q1_3_31;

/**
 * @author zhou
 * 双向链表
 * 实现静态方法：在表头插入节点，在表尾插入节点，从表头删除节点，从表尾删除节点，在指定节点前插入新节点，在指定节点后插入新节点，删除指定节点
 */
public class TwoWayLinkedLisk {

	static DoubleNode insertBeforeHead(DoubleNode head, DoubleNode insertNode) {
		if(head == null) head = insertNode;
		else {
			head.previous = insertNode;
			insertNode.next = head;
			head = insertNode;
		}
		return head;
	}
	
	static DoubleNode insertAfterTail(DoubleNode head, DoubleNode insertNode) {
		if(head == null) head = insertNode;
		else {
			DoubleNode current = head;
			while(current.next != null) current = current.next;
			current.next = insertNode;
			insertNode.previous = current;
		}
		return head;
	}
	
	static DoubleNode deleteBeforeHead(DoubleNode head) {
		if(head == null) return null;
		else {
			DoubleNode newHead = head.next;
			head.next = null;
			if(newHead != null) {
				newHead.previous = null;
			}
			return newHead;
		}
	}
	
	static DoubleNode deleteAfterTail(DoubleNode head) {
		if(head == null || head.next == null) return null;
		else {
			DoubleNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.previous.next = null;
			current.previous = null;
			return head;
		}
	}
	
	static DoubleNode insertBeforeExactNode(DoubleNode head, DoubleNode insertNode, int index) {
		DoubleNode current = head;
		for(int i = 1; i < index; i++) {
			if(current == null) return null;
			else current = current.next;
		}
		if(current.previous == null) {
			current.previous = insertNode;
			insertNode.next = current;
			head = head.previous;
		}
		else {
			insertNode.previous = current.previous;
			insertNode.next = current;
			current.previous.next = insertNode;
			current.previous = insertNode;
		}
		return head;
	}
	
	static DoubleNode insertAfterExactNode(DoubleNode head, DoubleNode insertNode, int index) {
		DoubleNode current = head;
		for(int i = 1; i < index; i++) {
			if(current == null) return null;
			else current = current.next;
		}
		if(current.next == null) {
			current.next = insertNode;
			insertNode.previous = current;
		}
		else {
			insertNode.previous = current;
			insertNode.next = current.next;
			current.next.previous = insertNode;
			current.next = insertNode;
		}
		return head;
	}
	
	static DoubleNode deleteNode(DoubleNode head, int index) {
		DoubleNode current = head;
		for(int i = 1; i < index; i++) {
			if(current == null) return null;
			else current = current.next;
		}
		if(head == current) head = current.next;
		if(current.previous != null) current.previous.next = current.next;
		if(current.next != null) current.next.previous = current.previous;
		current.next = null;
		current.previous = null;
		return head;
	}
	
	public static void main(String[] args) {
		DoubleNode head = new DoubleNode("0");
		for(int i = 1; i < 4; i++) {
			head = insertBeforeHead(head, new DoubleNode("beforehead:"+i));	
		}
		for(int i = 1; i < 4; i++) {
			head = deleteBeforeHead(head);
		}
		for(int i = 1; i < 4; i++) {
			head = insertAfterTail(head, new DoubleNode("aftertail:" + i));
		}
		for(int i = 1; i < 4; i++) {
			head = deleteAfterTail(head);
		}
		for(int i = 1; i < 4; i++) {
			head = insertAfterExactNode(head, new DoubleNode("after"+i+"Node:" + i), i);
		}
		for(int i = 4; i > 1; i--) {
			head = deleteNode(head, i);
		}
		for(int i = 1; i < 4; i++) {
			head = insertBeforeExactNode(head, new DoubleNode("before"+i+"Node:" + i), i);
		}
		for(int i = 1; i < 4; i++) {
			head = deleteNode(head, 1);
		}

	}
}
