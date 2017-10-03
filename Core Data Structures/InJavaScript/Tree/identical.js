(function(exports){
    'use strict';

  console.clear();

  var TreeNode = function(val){
    this.val = val;
    this.left= null;
    this.right = null;
  }

  var root1 = new TreeNode(1);
  var left1 = new TreeNode(2);
  var right1 = new TreeNode(3);

  var leftleft1 = new TreeNode(4);
  var leftright1 = new TreeNode(5);

  var rightleft1 = new TreeNode(6);
  var rightright1 = new TreeNode(7);

 root1.left = left1;
 root1.right = right1;

 left1.left = leftleft1;
 left1.right = leftright1;

 right1.left = rightleft1;
 right1.right = rightright1;

  var root2 = new TreeNode(1);
 var left2 = new TreeNode(2);
 var right2 = new TreeNode(3);

  var leftleft2 = new TreeNode(4);
  var leftright2 = new TreeNode(5);

  var rightleft2 = new TreeNode(6);
  var rightright2 = new TreeNode(7);

  root2.left = left2;
  root2.right = right2;

  left2.left = leftleft2;
  left2.right = leftright2;

  right2.left = rightleft2;
  right2.right = rightright2;

  var identical = function(root1,root2){
    if(root1 === null && root2 === null)
      return true;

    if(root1.val == root2.val && identical(root1.left, root2.left) && identical(root1.right, root2.right))
      return true;

    return false;
  }


  var identical2 = function(root1, root2){
    if(root1 === null && root2 === null)
      return true;

    if(root1 === null || root2 ===  null)
      return false;

      var q1 = [];
      var q2 = [];
      q1.push(root1);
      q2.push(root2);

    while(q1.length > 0 && q2.length > 0){
        var node1 = q1.shift();
        var node2 = q2.shift();

        if(node1.val !== node2.val)
          return false;

        q1.pop();
        q2.pop();

        if(node1.left !== null && node2.left !== null){
          q1.push(node1.left);
          q2.push(node2.left);
        }
        else if(node1.left === null || node2.left === null)
          return false;

        if(node1.right !== null && node2.right !== null){
          q1.push(node1.right);
          q2.push(node2.right);
        }
         else if(node1.right === null || node2.right === null)
           return false;

      }
    return true;
  }

  console.log(identical2(root1,root2));


})(typeof window === 'undefined' ? module.exports : window)
