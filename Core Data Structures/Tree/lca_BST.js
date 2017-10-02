(function(exports){
    'use strict';

  console.clear();

  var TreeNode = function(val){
    this.val = val;
    this.left= null;
    this.right = null;
		this.leaf = false;
  }

  var root = new TreeNode(5);
  var left = new TreeNode(3);
  var right = new TreeNode(8);

   var leftleft = new TreeNode(2);
   var leftright = new TreeNode(4);

   var rightleft = new TreeNode(6);
   var rightright = new TreeNode(9);

 root.left = left;
 root.right = right;

  left.left = leftleft;
  left.right = leftright;

  right.left = rightleft;
  right.right = rightright;

	rightleft.leaf = true;
	rightright.leaf = true;


	var lca = function(root,val1,val2){
		if(root == null)
			return null;
		if(val1 < root.val && val2 < root.val)
			return lca(root.left,val1,val2);
		if(val1 > root.val && val2 > root.val)
			return lca(root.right,val1,val2);

		return root;
	}

	console.log(lca(root,2,6));

})(typeof window === 'undefined' ? module.exports : window)
