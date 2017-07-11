public class Main {
 static class Node{
	int value;
	Node next;

	Node(int value){
	  this.value = value;
	}
}

public static void main(String[] args){
	Node node1 = new Node(1);
	Node node2 = new Node(2);
	Node node3 = new Node(3);
	Node node4 = new Node(4);
	Node node5 = new Node(5);
  Node node6 = new Node(6);
	Node node7 = new Node(7);
	Node node8 = new Node(8);
	Node node9 = new Node(9);
	Node node10 = new Node(10);
	node1.next =node2;
	node2.next =node3;
	node3.next =node4;
	node4.next =node5;
  node5.next =node6;
	node6.next =node7;
	node7.next =node8;
	node8.next =node9;
  node9.next =node10;
	compute(node1,node1,0);
	while(node1 != null){
	  System.out.println(node1.value);
	  node1 = node1.next;
	}

}

public static Node compute(Node temp,Node head,int length){
   //if the node is null then return the head for calculation,
   //for last node we have to calulate with the first node and so on
   if(temp == null)
       return head;

   Node x = compute(temp.next,head,length+1);//compute length as we go
   length = length - 2;
   //this is where both end meets
   if(length <= 2)
      return head;
   else
         x.value = temp.value-x.value;
   return x.next;
}

}
---------------

public static Node compute(Node fast,Node slow,Node head){
   if(fast == null)
       return head;
    Node x = compute(fast.next.next,fast,head);
    if(x.value != slow.value)
      x.value = fast.value-x.value;
   return x.next;
}
