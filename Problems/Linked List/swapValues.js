console.clear();
var Node = function(data){
	this.val = data;
	this.next = null;
}


var node1 = new Node(1);
var node2 = new Node(2);
var node3 = new Node(3);
var node4 = new Node(4);
var node5 = new Node(5);
node1.next =node2;
node2.next =node3;
//node3.next =node4;
node4.next =node5;

var prev = node1;
var head = prev.next;
while(prev.next !== null){
	var next = prev.next.next;
	prev.next.next = prev;

	if(next.next != null)
		prev.next = next.next;
	else
		prev.next = next;

	prev = next;
}
while(head !== null){
	console.log(head.val);
	head = head.next;
}
