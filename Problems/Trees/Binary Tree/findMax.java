public class YourClassNameHere {
	    static int max = Integer.MIN_VALUE;
	    public static void main(String[] args) {
	      TreeNode root = new TreeNode(1);
	      TreeNode left = new TreeNode(2);
	      TreeNode right = new TreeNode(3);
	      root.left = left;
	      root.right = right;

	      findMax1(root);
	    }

	    public static void findMax(TreeNode root){
	      if(root == null)
	        return;

	      max = Math.max(max,root.value);
	      findMax(root.left);
	      findMax(root.right);
	    }

	    public static int findMax1(TreeNode root){
	      if(root == null)
	        return 0;

	      int max = root.value;

	      int leftMax = findMax1(root.left);
	      int rightMax = findMax1(root.right);

	      if(max < leftMax)
	        max = leftMax;

	      if(max < rightMax)
	        max = rightMax;

	      return max;
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
