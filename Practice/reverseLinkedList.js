(function(exports){
    'use strict';

    console.clear();

  var Node = function(data){
    this.val = data;
    this.next = null;
  }

  var node = new Node(1);
  node.next = new Node(2);
  node.next.next = new Node(3);
  node.next.next.next = new Node(4);
  node.next.next.next.next = new Node(4);
  node.next.next.next.next.next = new Node(5);

  var reverse = function(node){
    if(node === null || node.next === null)
      return node;
    var nextNode = reverse(node.next);
    node.next.next = node;
    node.next = null;
    return nextNode;
  }

  console.log(reverse(node))

})(typeof exports === 'undefined' ? [] : exports)
