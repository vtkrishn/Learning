(function(exports){
    'use strict';

var TreeNode = function(val){
this.val = val;
this.left= null;
this.right = null;
}

var root = new TreeNode(1);
var left = new TreeNode(2);
var right = new TreeNode(3);

var leftleft = new TreeNode(4);
var leftright = new TreeNode(5);

var rightleft = new TreeNode(6);
var rightright = new TreeNode(7);

root.left = left;
root.right = right;

left.left = leftleft;
left.right = leftright;

right.left = rightleft;
right.right = rightright;

console.clear();

	var convert = function(root){
		if(root === null)
			return null;

		var left = convert(root.left);
		var right = convert(root.right);

		root.left = root;
		root.right = root;

		return concatenate(concatenate(left,root),right);
	}

	var concatenate = function(left, right){
		if(left === null)
			return right;
		if(right == null)
			return left;

		var leftLast = left.left;
		var rightLast = right.left;

		leftLast.right = right;
		right.left= leftLast;

		left.left = rightLast;
		rightLast.right = left;

		return left;
	}



	var list = convert(root);
	var itr = list;
	while(itr.right != list){
		console.log(itr.val);
		itr = itr.right;
	}

})(typeof window === 'undefined' ? module.exports : window)
