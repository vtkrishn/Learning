(function(exports){
    'use strict';

  console.clear();

  var TreeNode = function(val){
    this.val = val;
    this.left= null;
    this.right = null;
		this.parent = null;
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

	left.parent = root;
	right.parent = root;

  left.left = leftleft;
  left.right = leftright;

	leftleft.parent = left.left;
	leftright.parent = left.right;

  right.left = rightleft;
  right.right = rightright;

	rightleft.parent = right.left;
	rightright.parent = right.right;


	var lca = function(root,val1,val2){
		if(root == null)
			return null;

		if(root.val == val1 || root.val == val2)
			return root;

		var left = lca(root.left, val1,val2);
		var right = lca(root.right, val1,val2);

		if(left !== null && right !== null)
			return root;

		return (left != null) ? left: right;
	}

	console.log(lca(root,2,6));

})(typeof window === 'undefined' ? module.exports : window)
