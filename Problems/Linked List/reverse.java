public class Solution{
static class Node{
Node next;
int value;

	public Node(int data){
		this.value = data;
	}
}

	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		reverse(node1);
	}



public static Node reverse(Node head){
	Node current = head;
	Node previous = null;
	while(current != null){
		Node next = current.next;
		current.next = previous;
		previous = current;
		current = next;
	}
	return previous;
}
}


--------------
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // if(head == null)
        //     return null;
        // ListNode previous = null;
        // ListNode current = head;
        // while(current != null){
        //     ListNode next = current.next;
        //     current.next = previous;
        //     previous = current;
        //     current = next;
        // }
        // return previous;
        if(head == null || head.next == null)
            return head;
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
