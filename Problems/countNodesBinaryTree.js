var node = function (data){
  var val;
  var left;
  var right;
  this.val = data;
}

var n1 = new node(1);
var n2 = new node(2);
var n3 = new node(3);

n1.left = n2;
n1.right = n3;

var l1 = new node(1);
var l2 = new node(2);

n2.left = l1;
n2.right = l2;

var r1 = new node(1);
var r2 = new node(2);

n3.left = r1;
n3.right = r2;

function count(node){
  if(node === undefined)
    return 0;
  return 1 + count(node.left) + count(node.left);
};

console.log(count(n1));
