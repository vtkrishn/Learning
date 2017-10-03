(function(exports){
    'use strict';

console.clear();

	var findOccurance= function(arr,x){
		var i = bs1(arr,0, arr.length-1, x);
		if(i === -1)
			return i;
		var j = bs2(arr,i, arr.length-1, x);
		return j-i+1;
	}

	var bs1 = function(start, end,x){
		if(start <= end){
			var mid = (end + start)/2;
			if((mid === 0 || x > arr[mid-1]) && arr[mid] === x)
				return mid;
			else if(x > arr[mid])
				return bs1(arr,mid + 1, end, x);
			else
				return bs1(arr,start, mid-1, x);
		}
		return -1;
	}

	var bs2 = function(arr,start, end,x){
		if(start <= end){
			var mid = (end + start)/2;
			if((mid === arr.length-1 || x < arr[mid-1]) && arr[mid] === x)
				return mid;
			else if(x < arr[mid])
				return bs2(arr,start, mid - 1, x);
			else
				return bs2(arr,mid + 1, end, x);
		}
		return -1;
	}

	var arr = [1, 1, 2, 2, 2, 2, 3];
	console.log(findOccurance(arr,2));

})(typeof window === 'undefined' ? module.exports : window)
