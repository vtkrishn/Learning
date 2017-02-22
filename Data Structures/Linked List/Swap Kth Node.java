public class YourClassNameHere {
	    public static void main(String[] args) {
	      DoubleLinkList d = new DoubleLinkList();
	      
	      d.addLast(1);
	      d.addLast(2);
	      d.addLast(3);
	      d.addLast(4);
	      
	      d.printList();
	      d.swapKthNode(1);
	      d.printList();
	    }
	    
	    static class DoubleLinkList{
	      Node head;
	      Node tail;
	      int size;
	      
	      public DoubleLinkList(){
	       this.size = 0; 
	      }
	     
	     void printList()
    {
        Node node = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
    
	     private void swapKthNode(int k){
	       int length = 0;
	       
	       //get the length of the linked list
	       Node dummy = head;
	       while(dummy!= null){
	         length += 1;
	          dummy = dummy.next; 
	       }
	       
	       //bound check
	       if(k > length)
	        return;
	       
	       //same element
	       if(2*k == length)
	        return;
	       
	       //get the kth node from the first
	       Node dummy1 = head;
	       for(int i=1;i<k;i++){
	          dummy1.previous = dummy1;
	          dummy1=  dummy1.next; 
	       }
	       
	       //get the kth node from the last
	       Node dummy2 = head;
	       for(int i=1;i<length-k+1;i++){
	          dummy2.previous = dummy2;
	          dummy2=  dummy2.next; 
	       }
	       
	       Node next = dummy1.next;
	       //Node previous = dummy1.previous;
	       dummy1.next = dummy2.next;
	       //dummy1.previous = dummy2.previous;
	       dummy2.next = next;
	       //dummy2.previous = previous;
	       
	       
	       if(k == 1)
	        head = dummy2;
	        
	       if(k == length)
	        head = dummy1;
	       
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
