public class YourClassNameHere {
	    static int max = Integer.MIN_VALUE;
	    public static void main(String[] args) {
	      TreeNode root = new TreeNode(10);
	      TreeNode left = new TreeNode(2);
	      TreeNode right = new TreeNode(10);
	      root.left = left;
	      root.right = right;
	      TreeNode leftleft = new TreeNode(20);
	      TreeNode leftright = new TreeNode(1);
	      //TreeNode rightleft = new TreeNode(6);
	      TreeNode rightright = new TreeNode(-25);
	      left.left = leftleft;
	      left.right = leftright;
	      //right.left = rightleft;
	      right.right = rightright;
	      TreeNode rightrightLeft = new TreeNode(3);
	      TreeNode rightrightRight = new TreeNode(4);
	      rightright.left = rightrightLeft;
	      rightright.right = rightrightRight;

	      findSum(root,Integer.MIN_VALUE);
	    }

      public static int findSum(TreeNode root,int result){
        if(root == null)
          return 0;

        int leftSum = findSum(root.left,result);
        int rightSum = findSum(root.right,result);
        int maxOfSingle = Math.max(leftSum,rightSum);
        int maxOfSubTree = Math.max(maxOfSingle+root.value,root.value);
        int maxOfTop = Math.max(maxOfSubTree,leftSum+rightSum+root.value);
        result = Math.max(result,maxOfTop);
        return result;
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
