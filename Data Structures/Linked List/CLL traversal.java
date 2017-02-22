public class YourClassNameHere {
	    public static void main(String[] args) {
	     // CircularLL c = new CircularLL();
	     //   c.addLast(1);
	     //   c.addLast(2);
	     //   c.addLast(3);
	     //   c.addLast(4);
	        
	        CircularLL c1 = new CircularLL();
	        c1.addFirst(1);
	        c1.addFirst(2);
	        c1.addFirst(3);
	        c1.addFirst(4);
	    }
	    
	    static class CircularLL{
	    
	    Node head;
	    int size;
	    
	    
	    public void addFirst(int value){
	      Node newNode = new Node(value);
	      Node dummy=null;
	      if(head == null){
	        head = newNode;
	        head.next = head;
	      }
	      else{
	       newNode.next = head;
	       dummy = head;
	       while(dummy.next != head){
	          dummy = dummy.next; 
	       }
	       dummy.next = newNode;
	       head = newNode;
	      }
	    }
	    
	    public void addLast(int value){
	      Node newNode = new Node(value);
	      Node dummy=null;
	      
	      if(head == null){
	        head = newNode;
	        head.next = head;
	      }
	      else{
	       dummy = head;
	       while(dummy.next != head){
	         dummy = dummy.next;
	       }
	       dummy.next = newNode;
	       newNode.next = head;
	      }
	      
	      size++;
	    }
	    	    
	    static class Node{
	      Node next;
	      int data;
	      
	      public Node(int value){
	        this.data = value;
	      }
	    }
	    
	    }
	    
	    
	    
	}
