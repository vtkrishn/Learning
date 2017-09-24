
(function(exports){

  console.clear();

  var treeNode = function(val){
    this.val = val;
    this.left = null;
    this.right = null;
  }

  var serialize = function(root){
     if(root === null)
       return "";

     var s = "";
     var stack = [];
     stack.push(root);
     while(stack.length > 0){
       var node = stack.pop();
       if(node !== null){
         s = s + node.val + ",";
         stack.push(node.right);
         stack.push(node.left);
       }
       else{
         s = s + "#,";
       }
     }

    return s;

  };

  var deserialize = function(data){
    if(data === null || data.length === 0)
       return null;

    var split = data.split(",");
    var stack = [];
    var root = new treeNode(split[0]);
    stack.push(root);

    var i = 1;
    while(stack.length > 0){
      var node = stack.pop();

      if(split[i] !== "#"){
        node.left = new treeNode(split[i]);
        stack.push(node.left);
      }
      else{
        node.left = null;
        stack.push(null);
      }
      i++;

      if(split[i] !== "#"){
        node.right = new treeNode(split[i]);
        stack.push(node.right);
      }
      else{
        node.right = null;
        stack.push(null);
      }

      i++;
    }

    return root;
  };

  var t1 = new treeNode(1);
  var t2 = new treeNode(2);
  var t3 = new treeNode(3);
  var t4 = new treeNode(4);
  var t5 = new treeNode(5);
  var t6 = new treeNode(6);
  var t7 = new treeNode(7);

  t1.left = t2;
  t1.right = t3;

  t2.left = t4;
  t2.right = t5;

  t3.left = t6;
  t3.right = t7;

  //var result1 = serialize(t1);
  //console.log(result1);
  //"1,2,4,#,#,5,#,#,3,6,#,#,7,#,#,"
  var result2 = deserialize("1,2,4,#,#,5,#,#,3,6,#,#,7,#,#,");
  console.log(result2);

  //var result1 = serialize(result2);
  //console.log(result1);
}
)(this);
