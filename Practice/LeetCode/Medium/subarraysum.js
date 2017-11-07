console.clear();

var func = function(arr,k){
	var m = { 0 : 1};
	var sum = 0;
	var count = 0;
	for(var i=0;i<arr.length;i++){
		sum += arr[i];
		if(m[sum-k] !== undefined){
			count += m[sum-k];
		}
		if(m[sum] === undefined)
			m[sum] = 1;
		 else
			m[sum] = m[sum] + 1;
	}
	return count;
}

var arr = [1,1,1];
console.log(func(arr,2));
