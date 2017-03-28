public class YourClassNameHere {
	    
	    static class Node{
	      Node next;
	      int data;
	      
	      Node(int data){
	        this.data = data; 
	      }
	    }
	    public static void main(String args[]){
	       Node node1 = new Node(1);
	       Node node2 = new Node(2);
	       Node node3 = new Node(3);
	       Node node4 = new Node(4);
	       Node node5 = new Node(5);
	       node1.next = node2;
	       node2.next = node3;
	       node3.next = node4;
	       node4.next = node5;
	       
	       searchElement(node1,7);
	    }
	    
	    static void searchElement(Node head,int value){
	      if(head == null){
	        System.out.println("Not Found");
	        return; 
	      }
	      
	      if(head.data == value){
	        System.out.println("Found");
	        return;
	      }
	      
	      searchElement(head.next,value);   
	    }
	}
