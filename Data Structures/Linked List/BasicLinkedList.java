public class YourClassNameHere {
	    public static void main(String[] args) {

	      LinkedList ll = new LinkedList();
	      ll.insertLast(1);
	      ll.insertLast(2);
	      ll.insertLast(3);
	      ll.insertLast(4);
	      ll.insertLast(5);
	    }

static class LinkedList{
 Node head;
 int size;

 LinkedList(){
   this.size=0;
 }

 public void insertLast(int value){
	       Node newNode = new Node(value);
	        if(head == null){
	          head = newNode;
	        }
	        else{
	          Node dummy = head;
	          while(dummy.next != null){
	            dummy = dummy.next;
	          }
	          dummy.next = newNode;
	        }
	       }

 public void insertFirst(int value){
   Node newNode = new Node(value);
   if(head == null)
    head = newNode;

   newNode.next = head;
   head = newNode;
 }

 class Node{
  Node next;
  int data;

  Node(int val){
    this.data = val;
  }
}

}
}
