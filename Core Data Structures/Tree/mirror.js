(function(exports){
    'use strict';

  console.clear();

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

  var mirror = function(root){
    if(root === null)
      return;
    else{
      mirror(root.left);
      mirror(root.right);
      var temp = root.left;
      root.left = root.right;
      root.right = temp;
    }
  }

  console.log(root);
  mirror(root);
  console.log(root);


})(typeof window === 'undefined' ? module.exports : window)
