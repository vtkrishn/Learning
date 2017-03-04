public class YourClassNameHere {
	    public static void main(String[] args) {
	        TreeNode root = new TreeNode(10);
	        TreeNode rootLeft = new TreeNode(7);
	        TreeNode rootRight = new TreeNode(13);
	        root.left = rootLeft;
	        root.right = rootRight;
	        
	        TreeNode rootLeftLeft = new TreeNode(5);
	        TreeNode rootLeftRight = new TreeNode(8);
	        rootLeft.left = rootLeftLeft;
	        rootLeft.right = rootLeftRight;
	        
	        TreeNode rootRightLeft = new TreeNode(11);
	        TreeNode rootRightRight = new TreeNode(17);
	        rootRight.left = rootRightLeft;
	        rootRight.right = rootRightRight;
	        
	        java.util.Stack s = new java.util.Stack();        
	        
	        int k = 2;
	        
	        while(!s.isEmpty() || root != null){
	          if(root !=null){
	            s.push(root);
	            root = root.left;
	          }
	          else{
	            
	            TreeNode t = (TreeNode)s.pop();
	            k--;
	            if(k == 0)
	              System.out.println(t.data);
	            root = t.right;
	        }
	        
	    }
	
	}
	
}
	
	class TreeNode{
	   TreeNode left;
	   TreeNode right;
	   int data;
	   
	   TreeNode(int val){
	     this.data = val;
	   }
	}	
	
