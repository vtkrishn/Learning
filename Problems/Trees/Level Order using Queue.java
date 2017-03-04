public class YourClassNameHere {
	    static class TreeNode {
	      TreeNode left;
	      TreeNode right;
	      int data;
	      
	      public TreeNode(int data){
	        this.data = data;
	      }
	      
	    }
	    
	    public static void main(String[] args) {
	        TreeNode root = new TreeNode(1);
	        TreeNode rootLeft = new TreeNode(2);
	        TreeNode rootRight = new TreeNode(3);
	        TreeNode rootLeftLeft = new TreeNode(4);
	        TreeNode rootLeftRight = new TreeNode(5);
	        TreeNode rootRightLeft = new TreeNode(6);
	        TreeNode rootRightRight = new TreeNode(7);
	        
	        root.left = rootLeft;
	        root.right = rootRight;
	        
	        rootLeft.left = rootLeftLeft;
	        rootLeft.right = rootLeftRight;
	        
	        rootRight.left = rootRightLeft;
	        rootRight.right = rootRightRight;
	        
	        levelOrderTraversal(root);
	        
	    }
	    
	    public static void levelOrderTraversal(TreeNode root){
	      if(root == null)
	        return;
	      
	      java.util.LinkedList<TreeNode> q = new java.util.LinkedList<TreeNode>();
	      q.add(root);
	      while(q.size() != 0){
	        TreeNode t = q.poll(); 
	        System.out.println(t.data);
	        
	        if(root.left != null){
	          q.add(t.left);
	        }
	        
	        if(root.right != null){
	          q.add(t.right);
	         }
	        
	      }
	        
	    }
	    
	}
