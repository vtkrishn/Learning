public class Solution{
	public static void main(String[] args){
		Node head = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;

		System.out.println(findLengthRecursion(head));
		System.out.println(findLengthIterative(head));
	}

	static class Node{
		int data;
		Node next;

		public Node(int val){
			this.data = val;
		}
	}

	private static int findLengthRecursion(Node head){
		if(head == null)
			return 0;

		return findLengthRecursion(head.next) + 1;
	}

    private static int findLengthIterative(Node head){
      if(head == null)
        return 0;
      int count = 0;
      Node dummy= head;
      while(dummy != null){
         count += 1;
         dummy = dummy.next;
      }
      return count;
    }
}
