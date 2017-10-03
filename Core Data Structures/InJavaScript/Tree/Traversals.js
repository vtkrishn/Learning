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

var inorder = function(node){
  if(node === null)
    return;

    inorder(node.left);
    console.log(node.val);
    inorder(node.right);
}

var preorder = function(node){
  if(node === null)
  return;

  console.log(node.val);
  preorder(node.left);
  preorder(node.right);
}

var postorder = function(node){
  if(node === null)
  return;

  postorder(node.left);
  postorder(node.right);
  console.log(node.val);
}

console.log("In order");
inorder(root);
console.log("Pre order");
preorder(root);
console.log("Post order");
postorder(root);


})(typeof window === 'undefined' ? module.exports : window)
