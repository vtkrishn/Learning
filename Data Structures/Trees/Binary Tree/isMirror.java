public class YourClassNameHere {
	    static int max = Integer.MIN_VALUE;
	    public static void main(String[] args) {
	      TreeNode root = new TreeNode(1);
	      TreeNode left = new TreeNode(2);
	      TreeNode right = new TreeNode(2);
	      root.left = left;
	      root.right = right;
	      TreeNode leftleft = new TreeNode(3);
	      TreeNode leftright = new TreeNode(4);
	      TreeNode rightleft = new TreeNode(4);
	      TreeNode rightright = new TreeNode(3);
	      left.left = leftleft;
	      left.right = leftright;
	      right.left = rightleft;
	      right.right = rightright;
	     // TreeNode rightrightLeft = new TreeNode(3);
	     // TreeNode rightrightRight = new TreeNode(4);
	     // rightright.left = rightrightLeft;
	     // rightright.right = rightrightRight;

	      isMirror(root.left,root.right);
	    }

      public static boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1 == null || root2 == null)
          return true;

        if(root1 != null && root2 != null && root1.value == root2.value
        && isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left))
          return true;

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
