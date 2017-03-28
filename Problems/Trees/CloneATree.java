class Node{
 
 Node left;
 Node right;
 int data;
 
 public Node(int data){
   this.data = data;
 }
}

public class YourClassNameHere {
	    
	    public static Node cloneTree(Node root1){
	      if(root1 == null)
	        return null;
	      
	      Node root2 = new Node(root1.data);
	      root2.left = cloneTree(root1.left);
	      root2.right = cloneTree(root1.right);
	      
	      return root2;
	    }
	    
	    public static void main(String[] args) {
	      Node node1 = new Node(1);
	      node1.left = new Node(2);
	      node1.right = new Node(3);
	      Node node2 = cloneTree(node1);
	    }
	}
