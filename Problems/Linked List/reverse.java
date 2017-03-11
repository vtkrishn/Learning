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
