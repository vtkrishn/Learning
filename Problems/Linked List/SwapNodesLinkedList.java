public class YourClassNameHere {
	    public static void main(String[] args) {

	      LinkedList ll = new LinkedList();
	      ll.insertLast(1);
	      ll.insertLast(2);
	      ll.insertLast(3);
	      ll.insertLast(4);
	      ll.insertLast(5);

	      //ll.delete(4);
	      //ll.findLength1(ll.head);

	      ll.swapNode(2,5);

	    }

static class LinkedList{
 Node head;
 int size;

 LinkedList(){
   this.size=0;
 }

 public void swapNode(int n1, int n2){
   Node dummy = head;
   Node prev1 = null;
   Node prev2 = null;
   while(dummy.next != null){
     if(dummy.next.data == n1)
      prev1 = dummy;

     if(dummy.next.data == n2)
      prev2 = dummy;

    dummy = dummy.next;
   }

   Node node1 = prev1.next;
   Node node2 = prev2.next;

   Node node1Next = node1.next;
   Node node2Next = node2.next;

   prev1.next = node2;
   node2.next = node1Next;

   prev2.next = node1;
   node1.next = node2Next;

 }

 public int findLength(Node head){
    if(head == null)
      return 0;

    return findLength(head.next) + 1;
 }

 public int findLength1(Node head){
    if(head == null)
      return 0;

    Node dummy = head;
    int count = 0;
    while(dummy != null){
      count++;
      dummy = dummy.next;
    }

    return count;

 }




 public void delete(int value){
    Node dummy = head;
    while(dummy != null){
      if(dummy.next != null && dummy.next.data == value)
        dummy.next = dummy.next.next;

      dummy = dummy.next;
    }
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
