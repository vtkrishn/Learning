public class YourClassNameHere {
	    
	    static class TreeNode{
	      TreeNode left;
	      TreeNode right;
	      int data;
	      
	      TreeNode(int value){
	        this.data = value;
	      }
	    }
	    
	    public static void main(String[] args) {
	      TreeNode root = new TreeNode(5);
	      TreeNode rootLeft = new TreeNode(2);
	      TreeNode rootLeftLeft = new TreeNode(1);
	      TreeNode rootLeftRight = new TreeNode(3);
	      TreeNode rootRight = new TreeNode(7);
	      TreeNode rootRightLeft = new TreeNode(6);
	      TreeNode rootRightRight = new TreeNode(8);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;
        
        System.out.println(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        
	    }
	    
	    static boolean isBST(TreeNode root,int low, int high){
	      if(root == null)
	        return true;
	      
	     // if(root.data <= low || root.data >= high)
	     //   return false;
	      if(root.left != null && root.left.data > root.data || 
	      root.right != null && root.right.data < root.data)
	        return false;
	      
	      return (isBST(root.left,low,root.data) && isBST(root.right,root.data,high));
	     // TreeNode prev = null; 
	      
	     // if(!isBST(root.left))
	     //   return false;
	      
	     // if(prev != null && prev.data <= root.data)
	     //   return false;
	      
	     // prev = root;
	      
	     //  return isBST(root.right);
	    }
	}
