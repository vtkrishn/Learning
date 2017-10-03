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

  var size = function(node){
    return node == null ? 0 : 1 + size(node.left) + size(node.right);
  }

  var size = function(root){
    if(root === null)
      return 0;

      var q = [];
      q.push(root);
      var sum = 0;
      while(q.length > 0){
        var node = q.shift();
        sum +=1;

        if(node.left !== null)
          q.push(node.left);


        if(node.right !== null)
          q.push(node.right);
      }
    return sum;
  }

  console.log(size(root));


})(typeof window === 'undefined' ? module.exports : window)
