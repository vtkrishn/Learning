public class YourClassNameHere {
	    static int max = Integer.MIN_VALUE;
	    public static void main(String[] args) {
	      TreeNode root = new TreeNode(1);
	      TreeNode left = new TreeNode(2);
	      TreeNode right = new TreeNode(3);
	      root.left = left;
	      root.right = right;
	      TreeNode leftleft = new TreeNode(4);
	      TreeNode leftright = new TreeNode(55);
	      TreeNode rightleft = new TreeNode(6);
	      TreeNode rightright = new TreeNode(76);
	      left.left = leftleft;
	      left.right = leftright;
	      right.left = rightleft;
	      right.right = rightright;

	      boolean found = findElement(root,7);
	      System.out.println(found);
	    }

	    public static boolean findElement(TreeNode root,int key){
	      if(root == null)
	        return false;

	      Stack<TreeNode> s= new Stack<TreeNode>();
	      s.push(root);

	      while(!s.isEmpty()){
	        TreeNode node = s.pop();
	        if(node.value == key)
	          return true;

	        if(node.left != null)
	          s.push(node.left);
	       if(node.right != null)
	          s.push(node.right);

	      }

	      return false;
	    }

static class TreeNode{
  TreeNode left;
  TreeNode right;
  int value;

  public TreeNode(int val){
    this.value = val;
  }

}

}
