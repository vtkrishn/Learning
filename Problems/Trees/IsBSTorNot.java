isBST(TreeNode root){
	if(root = =null)
		return false;
	return isBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
}

isBSTHelper(root , min, max){
	if(root == null)
		return true;

	if(node.data < min || node.data > max)
		return false;

	return isBSTHelper(root.left, min, node.data-1) && isBSTHelper(root.right, node.data+1, max);

}
