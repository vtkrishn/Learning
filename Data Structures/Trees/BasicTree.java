public class YourClassNameHere {
	    static int max = Integer.MIN_VALUE;
	    public static void main(String[] args) {
	      TreeNode root = new TreeNode(1);
	      TreeNode left = new TreeNode(2);
	      TreeNode right = new TreeNode(3);
	      root.left = left;
	      root.right = right;
	      
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
