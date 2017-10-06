(function(exports){
    'use strict';

console.clear();

var arr = [];

var heap = function(){
	this.arr = [];
	this.arr[0] = 0;
	this.size = 1;
};

heap.prototype.insert = function(item){
	this.arr[++this.size] = item;
	this.bubble(this.arr.length-1);
	return this.arr[this.size];
}

heap.prototype.sink = function(item){

}

heap.prototype.bubble = function(length){
	if(length > 0){
		var parentIndex = this.getParent(length);
		//while(parentIndex > 0){
			if(this.arr[parentIndex] > this.arr[length--])
				this.swap(length,parentIndex);
				this.bubble(length);
		//}
	}
}

//peek min
heap.prototype.getMin = function(item){

}

//remove min, rearrange
heap.prototype.extractMin = function(item){

}

//get the parent node
heap.prototype.getParent = function(index){
	return Math.floor(index/2);
}

//get the left node
heap.prototype.getLeft = function(index){
	return 2 * this.size;
}
//get the right node
heap.prototype.getRight = function(index){
	return 2 * this.size + 1;
}
//swap
heap.prototype.swap = function(x, y){
	var temp = this.arr[x];
	this.arr[x] = this.arr[y];
	this.arr[y] = temp;
	console.log(this.arr);
}

var h = new heap();
console.log(h.insert(6));
console.log(h.insert(2));
//console.log(h.insert(1));
// console.log(h.insert(4));
// console.log(h.insert(5));
// console.log(h.insert(6));

})(typeof window === 'undefined' ? module.exports : window)
