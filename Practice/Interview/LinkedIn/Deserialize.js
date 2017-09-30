(function(exports){
    'use strict';

  console.clear();

  var createTree = function(treeString){

    var createTreeNode = function(value){
            var TreeNode = function(value) {
             this.left = null;
             this.right = null;
             this.val = value;
            };
            return new TreeNode(value);
        };

    var treeStringSplit = treeString.split(',');
    var root = createTreeNode(treeStringSplit[0]);
    var q = [];
    q.push(root);

    var i = 1;
    while(q.length > 0 && i < treeStringSplit.length){
        var node = q.shift();

      if(node == null)
        continue;

      if(i< treeStringSplit.length && treeStringSplit[i] !== '#'){
        node.left = createTreeNode(treeStringSplit[i]);
        q.push(node.left);
      }
      else{
        node.left = null;
        q.push(null);
      }

      i++;

      if(i< treeStringSplit.length && treeStringSplit[i] !== '#'){
        node.right = createTreeNode(treeStringSplit[i]);
        q.push(node.right);
      }
      else{
        node.right = null;
        q.push(null);
      }
      i++;
    }

    return root;
  }

  console.log(createTree("1,2,3"));


})(typeof window === 'undefined' ? module.exports : window)
