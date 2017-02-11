
public class Solution{
	static class Node{
		Node next;
		int data;

		Node(int value){
			this.data = value;
		}
	}

	public static void main(String[] args){
			Node node1 = new Node(1);
			Node node2 = new Node(2);
			Node node3 = new Node(3);
			Node node4 = new Node(4);

			node1.next= node2;
			node2.next= node3;
			node3.next= node4;

			deleteNode(node2);
	}

	public static void deleteNode(Node node){
		if(node == null)
			return;

		if(node.next != null){
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}
}
