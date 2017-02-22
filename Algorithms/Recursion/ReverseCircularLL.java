public class YourClassNameHere {
	    public static void main(String[] args) {
	      Node n1 = new Node(1);
	      Node n2 = new Node(2);
	      Node n3 = new Node(3);
	      Node n4 = new Node(4);
	      n1.next = n2;
	      n2.next = n3;
	      n3.next = n4;
	      n4.next = n1;
	      
	      Node head = reverse(n1,null);
	    }
	    
	    static Node reverse(Node head,Node previous){
	      if(head == null)
	        return null;
	        
	        Node current = head;
	        Node next = current.next;
	        current.next  = previous;
	      return reverse(next,current);
	    }
	    
	    static class Node{
	      Node next;
	      int data;
	      
	      public Node(int data){
	        this.data = data;
	      }
	    }
	}
