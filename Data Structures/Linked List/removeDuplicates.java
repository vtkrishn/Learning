public class YourClassNameHere {
	    public static void main(String[] args)  throws Exception{
	        Node head = new Node(1);
	        Node n1 = new Node(1);
	        Node n2 = new Node(2);
	        Node n3 = new Node(3);
	        Node n4 = new Node(1);
	        Node n5 = new Node(2);
	        Node n6 = new Node(3);
	        head.next= n1;
	        n1.next = n2;
	        n2.next = n3;
	        n3.next = n4;
	        n4.next = n5;
	        n5.next = n6;

	        removeDuplicates(head);
	        removeDup(head);
	    }

  public static void removeDup(Node head){
    if(head == null)
      return;
    Node dummy = head;
    while(dummy != null){
      Node runner = dummy;
      while(runner.next != null){
        if(runner.next.value == dummy.value){
          runner.next = runner.next.next;
        }
        else
          runner = runner.next;
      }

      dummy = dummy.next;
    }
  }

  public static void removeDuplicates(Node head){
    if(head == null)
      return;

    Node previous = null;
    java.util.Set<Integer> s = new java.util.HashSet<Integer>();
    while(head != null){
      if(!s.contains(head.value)){
        s.add(head.value);
        previous = head;
      }
      else{
       previous.next = head.next;
      }
      head = head.next;
    }

    }

  static class Node{
    Node next;
    int value;

    public Node(int value){
      this.value = value;
    }
  }

}    
