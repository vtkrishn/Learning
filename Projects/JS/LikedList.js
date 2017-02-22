var Node = function(data,next){
	this.data = data;
	this.next = next;
}

Node.prototype.getData = function(){
console.log(this.data);
}

var head = new Node(0,null);
var next = new Node(1,null);

head.next = next;
head.next.getData();
next.getData();
