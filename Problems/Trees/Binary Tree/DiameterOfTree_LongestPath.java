public class YourClassNameHere {

    static class TreeNode{
      TreeNode left;
      TreeNode right;
      int value;

      TreeNode(int value){
        this.value = value;
      }
    }

    public static void main(String[] args) {
      TreeNode root = new TreeNode(6);
      TreeNode left = new TreeNode(5);
      TreeNode right = new TreeNode(1);
      root.left = left;
      TreeNode leftLeft = new TreeNode(7);
      TreeNode leftRight = new TreeNode(8);
      root.left.left = leftLeft;
      root.left.right = leftRight;
      TreeNode rightLeft = new TreeNode(2);
      TreeNode rightRight = new TreeNode(3);
      root.left.left.left = right;
      root.left.left.right = rightLeft;
      root.left.right.left = rightRight;
      //findLongestPath(root);
      //System.out.println(height(root));
      System.out.println(diameter(root));
    }

    public static int longestPath(TreeNode root){
      if(root == null)
        return 0;

      //lh = height(root.left);
      return 1;
    }

    public static int diameter(TreeNode root){
      if(root == null)
        return 0;

      int lh = height(root.left);
      int rh = height(root.right);

      int longest = lh + rh + 1;

      return Math.max(longest, Math.max(diameter(root.left),diameter(root.right)));
    }

    public static int height(TreeNode root){
      if(root == null)
        return 0;

      int lh = height(root.left);
      int rh = height(root.right);

      return Math.max(lh,rh) + 1;
    }
}
