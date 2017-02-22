public class YourClassNameHere {
	    public static void main(String[] args) {
	      DoubleLinkList d = new DoubleLinkList();
	      
	      d.addFirst(1);
	      d.addFirst(2);
	      d.addFirst(3);
	      d.addFirst(4);
	      
	      d.addLast(5);
	      
	    }
	    
	    static class DoubleLinkList{
	      Node head;
	      Node tail;
	      int size;
	      
	      public DoubleLinkList(){
	       this.size = 0; 
	      }
	     
	     private void addLast(int value){
	       Node newNode = new Node(value);
	       if(tail == null || head == null){
	          head = newNode;
	          tail = head;
	      }
	      else{
	        tail.next = newNode;
	          newNode.previous = tail;
	          tail = newNode;
	      }
	     }
	     
	     private void addFirst(int value){
	       Node newNode = new Node(value);
	       if(head == null){
	        head = newNode;
	        tail = head;
	       }
	       else{
	       newNode.next = head;
	       head.previous = newNode;
	       head = newNode;
	       }
	     }
	     
	     static class Node{
	      Node next;
	      Node previous;
	      int data;
	      
	      public Node(int value){
	        this.data = value;
	      } 
	       
	     }
	      
	    }
	}
