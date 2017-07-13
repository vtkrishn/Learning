public class ClassNameHere {

   static class TreeNode{
      TreeNode parent;
      TreeNode left;
      TreeNode right;
      int val;

      public TreeNode(int value){
       this.val=value;
      }
   }
   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      TreeNode left = new TreeNode(2);
      TreeNode right = new TreeNode(3);
      TreeNode leftleft = new TreeNode(4);
      TreeNode leftright = new TreeNode(5);
      TreeNode rightleft = new TreeNode(6);
      TreeNode rightright = new TreeNode(7);

      root.left = left;
      root.right = right;
      left.parent = root;
      right.parent = root;

      left.left = leftleft;
      left.right = leftright;
      leftleft.parent = left;
      leftright.parent = left;

      right.left = rightleft;
      right.right = rightright;
      rightleft.parent = right;
      rightright.parent = right;

      lca(left,rightleft);

   }

   public static TreeNode lca(TreeNode node1, TreeNode node2){
      int node1Height = getRootLength(node1);
      int node2Height = getRootLength(node2);
      TreeNode temp = null;
      if(node1Height == node2Height)
         return node1.parent;
      int diff = Math.abs(node1Height-node2Height);
      if(node1Height > node2Height)
         temp = getRoot(node1,diff);
      else
         temp = getRoot(node2,diff);
      return temp.parent;
   }

   public static TreeNode getRoot(TreeNode node,int value){
      if(value == 0)
         return node;
      return getRoot(node.parent,value-1);
   }

   public static int getRootLength(TreeNode node){
      if(node.parent == null)
         return 0;
      return getRootLength(node.parent)+1;
   }
}
