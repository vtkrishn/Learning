package linkedin.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class MyStackDLL {

	
	public static void main(String[] args) {
		DoubleLinkedList stack = new DoubleLinkedList();
		stack.push(5); 
		stack.push(1);
		stack.push(5);
		stack.top(); //-> 5
		stack.popMax(); //-> 5
		stack.top(); //-> 1
		stack.peekMax(); //-> 5
		stack.pop(); //-> 1
		stack.top(); //-> 5
		
	}
	
	static class DoubleLinkedList{
		Node head;
		Node tail;
		PriorityQueue<Integer> pq;
		
		public DoubleLinkedList() {
			pq = new PriorityQueue<>(Collections.reverseOrder());
		}
		public void push(int val) {
			Node node = new Node(val);
			if(tail != null) {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			else {
				head = tail = node;	
			}
			pq.add(node.val);
		}
		
		public int pop() {
			int val = tail.val;
			if(tail.prev != null) {
				tail.prev.next = null;
				tail = tail.prev;
			}
			System.out.println(val);
			return val;
		}
		
		public int top() {
			System.out.println(tail.val);
			return tail.val;
		}
		
		public int peekMax() {
			System.out.println(pq.peek());
			return pq.peek();
		}
		
		public int popMax() {
			int max = pq.remove();
			System.out.println(max);
			pop();
			return max;
		}
		
		class Node{
			int val;
			Node prev;
			Node next;
			
			public Node(int val) {
				this.val = val;
			}
			
		}
		
	}
}
