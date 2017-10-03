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


	var invert = function(root){
		if(root === null)
			return;

		var left = invert(root.left);
		var right = invert(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	invert(root);

})(typeof window === 'undefined' ? module.exports : window)
