
package javaproject;

public class YourClassNameHere {
    public static void main(String[] args) {
      Node node1 = new Node(1);
      Node node2 = new Node(2);
      Node node3 = new Node(3);
      node1.next=  node2;
      node2.next=  node3;
      reverseLL(node1);
    }
    
    static class Node{
      Node next;
      int value;
      public Node(int data){
        this.value = data;
      }
    }
  public static void reverseLL(Node node){
  	if(node == null)
  		return;
  	Node prev = node;
  	reverseLL(node.next);
  	node.next = prev;
  }
}


