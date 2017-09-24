function ListNode(val){
    this.val = val;
    this.next = null;
  }

  var reverse = function(node){
      if(node.next === null)
        return node;

    var nextNode = reverse(node.next);
    node.next.next = node;
    node.next = null;
    return nextNode;
  }


  var l1 = new ListNode(1);
  var l2 = new ListNode(2);
  var l3 = new ListNode(3);
  var l4 = new ListNode(4);
  var l5 = new ListNode(5);

  l1.next = l2;
  l2.next = l3;
  l3.next = l4;
  l4.next = l5;

  var ser = reverse(l1);
  while(ser !== null){
    console.log(ser.val);
    ser = ser.next;
  }
    
