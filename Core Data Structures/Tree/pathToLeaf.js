(function(exports){
    'use strict';

  console.clear();

  var TreeNode = function(val){
    this.val = val;
    this.left= null;
    this.right = null;
		this.leaf = false;
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

	rightleft.leaf = true;
	rightright.leaf = true;
 var list = [];

  var print = function(root,l){
    l.push(root.val);
    if(root.left === null && root.right === null){
       console.log(l);
    }
    else{
				print(root.left,l);
				print(root.right,l);
		}
		l.pop();
  }

	var print1 = function(root){
    var stack = [];
		stack.push(root);
		stack.push(root.val);

		while(stack.length > 0){
			var node = stack.shift();
			var path = stack.shift();

			if(node.leaf)
				console.log(path);

			if(node.left !== undefined){
				path = path + node.left.val;
				stack.push(node.left);
				stack.push(path);
			}

			if(node.right !== undefined){
				path = path + node.right.val;
				stack.push(node.right);
				stack.push(path);
			}
		}

	}

  console.log(print(root,list));
	console.log(print1(root));


})(typeof window === 'undefined' ? module.exports : window)
