public class YourClassNameHere {
	    public static void main(String[] args) {
	      DoubleLinkList d = new DoubleLinkList();
	      
	      d.addFirst(1);
	      d.addFirst(2);
	      d.addFirst(3);
	      d.addFirst(4);
	      
	      d.mergeSort(d.getFirst());
	      
	    }
	    
	    
	    static void mergeSort(){
	      
	    }
	    
	    
	    static class DoubleLinkList{
	      Node head;
	      Node tail;
	      int size;
	      
	      public DoubleLinkList(){
	       this.size = 0; 
	      }
	     
	     private Node mergeSort(Node root){
	       
	       Node dummy = root;
	       Node second = dummy;
	       Node first = dummy;
	       
	       while(dummy.next != null && dummy.next != null){
	        first = dummy.next.next; 
	        second = dummy.next;
	        
	        dummy = dummy.next;
	       }
	       
	       Node node1 = split(dummy,second.data);
	       Node node2 = split(first,second.data);
	       
	       mergeSort(node1);
	       mergeSort(node2);
	       
	       return merge(node1,node2);
	     }
	     
	     private Node split(Node start, int end){
	       Node head = start;
	       while(start != null){
	          if(start.data == end){
	            start.next = null;
	          }
	          start = start.next;
	       }
	       return head;
	     }
	     
	     private Node merge(Node node1,Node node2){
	         if(node1 == null)
	          return node2;
	          
	         if(node2 == null)
	          return node1;
	         
	         if(node1.data > node2.data){
	           node1.next = merge(node1.next,node2);
	           node1.next.previous = node1;
	          return node1;
	         }
	         else{
	           node2.next = merge(node1,node2.next);
	           node2.next.previous = node2;
	           return node2;
	         }
	     }
	     
	     
	     private Node getFirst(){
	        return head; 
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
