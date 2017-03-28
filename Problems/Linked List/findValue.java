public class Solution{
	public static void main(String[] args){
		Node head = new Node(1);
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;

		System.out.println(findValueRecursion(head,7));
		System.out.println(findValueIterative(head,3));
	}

	static class Node{
		int data;
		Node next;

		public Node(int val){
			this.data = val;
		}
	}

	private static boolean findValueRecursion(Node head,int val){
		if(head == null)
			return false;

	  if(val == head.data)
	    return true;

		return findValueRecursion(head.next,val);
	}

    private static boolean findValueIterative(Node head,int val){
      if(head == null)
        return false;
      Node dummy= head;
      while(dummy != null){
         if(val == dummy.data)
	         return true;
         dummy = dummy.next;
      }
      return false;
    }
}
