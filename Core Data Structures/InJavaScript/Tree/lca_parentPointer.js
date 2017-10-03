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

	leftleft.parent = left;
	leftright.parent = left;

  right.left = rightleft;
  right.right = rightright;

	rightleft.parent = right;
	rightright.parent = right;


	var map = [];
	var lca = function(node1,node2){
		while(node1 !== null){
			map.push(node1.val);
			node1 = node1.parent;
		}

		while(node2 !== null){
			if(map.indexOf(node2.val) !== -1)
				return node2;
			node2 = node2.parent;
		}

	}

	console.log(lca(leftleft,rightleft));

})(typeof window === 'undefined' ? module.exports : window)
