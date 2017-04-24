public boolean identical(TreeNode root1, TreeNode root2){
  if(root1 == null && root2 == null)
      return true;

  if(root1 == null || root2 -- null)
      return false;

    return (root1.value == root2.value) &&
            (identical(root1.left, root2.left)) &&
            (identical(root1.right, root2.right));
}
