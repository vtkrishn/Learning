var _stack = function (){
}
var stack = _stack.prototype;

stack.a = [];

stack.isEmpty = function (){
	return this.a.length == 0;
}

stack.push = function (element){
	this.a.push(element);
	console.log(element + " pushed to the stack");
}

stack.peek = function (){
	if(!this.isEmpty()){
	    var size = this.a.length;
		var element = this.a[size-1];
		console.log(element + " peeked from the stack");
	}
	else{
		console.log("No element to peek");
	}
}
stack.pop = function (element){
	if(!this.isEmpty()){
		var element = this.a.pop();
		console.log(element + " popped from the stack");
	}
	else{
		console.log("No element to pop");
	}
}
