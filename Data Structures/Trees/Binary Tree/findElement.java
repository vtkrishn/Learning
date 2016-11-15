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

	      boolean found = findElement(root,76);
	      System.out.println(found);
	    }

	    public static boolean findElement(TreeNode root,int key){
	      if(root == null)
	        return false;

	      if(root.value == key)
	        return true;

	      boolean leftFound = findElement(root.left,key);
	      boolean rightFound = findElement(root.right,key);

	      return leftFound || rightFound;
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
