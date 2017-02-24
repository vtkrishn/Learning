class Node{
  Node next;
  int data;
  
  public Node(int data){
    this.data = data; 
  }
}



public class YourClassNameHere {
	  
public static Node reverse(Node node,Node previous){
  Node temp;
  if(node.next == null)
       temp = node;
  else 
        temp = reverse(node.next,node);
  node.next = previous;
  return temp;
}

public static void print(Node node){
  if(node == null)
    return;
  else{
   System.out.println(node.data);
   print(node.next);
  }
    
}

  
public static void main(String[] args) {
	        Node root1 = new Node(1);
	        Node root2 = new Node(2);
	        Node root3 = new Node(3);
	        root1.next = root2;
	        root2.next = root3;
	        
	        print(root1);
	        Node head = reverse(root1,null);
	        print(head);
	        
	    }
	}
