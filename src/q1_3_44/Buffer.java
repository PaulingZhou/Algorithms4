package q1_3_44;

import edu.princeton.cs.algs4.Stack;

/**
 * 			Buffer()			创建一块空缓冲区<p>
 * 
 * 	void	insert(char c)		在光标位置插入字符c<p>
 * 
 * 	char	delete()			删除并返回光标位置的字符<p>
 * 
 * 	void	left(int k)				将光标向左移动k个位置<p>
 * 
 * 	void	right(int k)				将光标向右移动k个位置<p>
 * 
 * 	int		size()				缓冲区的字符数量<p>
 * 
 * @author zhou
 *
 */
public class Buffer {
	Stack<Character> leftCursor, rightCursor;
	public Buffer() {
		leftCursor = new Stack<>();
		rightCursor = new Stack<>();
	}
	
	public int size() {
		return leftCursor.size() + rightCursor.size();
	}
	
	public void insert(char c) {
		leftCursor.push(c);
	}
	
	public char delete() {
		return leftCursor.isEmpty() ? null : leftCursor.pop();
	}
	
	public void left(int k) {
		for(int i = 0; i < k; i++) {
			if(leftCursor.isEmpty()) return;
			else {
				rightCursor.push(leftCursor.pop());
			}
		}
	}
	
	public void right(int k) {
		for(int i = 0; i < k; i++) {
			if(rightCursor.isEmpty()) return;
			else {
				leftCursor.push(rightCursor.pop());
			}
		}
	}
}
