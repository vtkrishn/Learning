public class YourClassNameHere {
	    static int max = Integer.MIN_VALUE;
	    public static void main(String[] args) {
	      TreeNode root = new TreeNode(1);
	      TreeNode left = new TreeNode(2);
	      TreeNode right = new TreeNode(3);
	      root.left = left;
	      root.right = right;
	      TreeNode leftleft = new TreeNode(4);
	      TreeNode leftright = new TreeNode(5);
	      //TreeNode rightleft = new TreeNode(6);
	      TreeNode rightright = new TreeNode(6);
	      left.left = leftleft;
	      left.right = leftright;
	      //right.left = rightleft;
	      right.right = rightright;

	      findSum(root);
	    }

      public static int findSum(TreeNode root){
        if(root == null)
          return 0;

        //get the left Sum
        int leftSum = findSum(root.left);
        //get the right sum
        int rightSum = findSum(root.right);
        //store the left sum and the root value
        root.value = root.value + leftSum;
        //return the root value with the right sum
        return root.value + rightSum;
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
