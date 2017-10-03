(function(exports){
    'use strict';

  console.clear();

	var E = [];
	var F = [];
	var C = [F];
	var D = [C];
	var B = [D, E];
	var A = [B, C, D];
var root = [A,B,C,D,E,F];
var stack = [];
var i = 0;
stack.push(root);
	while(stack.length > 0){
			var node = stack.pop();
			while(node.length > 0){
				stack.push(node.shift());
			}
		console.log("print" + stack);
	}

})(typeof window === 'undefined' ? module.exports : window)
