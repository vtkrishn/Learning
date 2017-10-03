(function(exports){
    'use strict';

console.clear();
	var pow = function(a,b){
		if(b == 1)
			return a;
		return pow(a * a , b - 1);
	}
	console.log(pow(3,3));

})(typeof window === 'undefined' ? module.exports : window)
