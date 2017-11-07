console.clear();

var func = function(key){
	var count = 0;
	while(key > 0){
		var rem = key % 2;
		if(rem == 1)
			count++;
		else
			count--;
		key = key >> 1;

		if(count > 1 || count < -1)
			return false;
	}
	return true;
}

for(var i=0;i<=10;i++)
	console.log("i :: " + i + " - > "+func(i));



-----------------
console.clear();

var func = function(number){
	let tmp = ( number >> 1 ) + number;
return( (tmp & tmp + 1) === 0);
}

for(var i=0;i<=10;i++)
	console.log("i :: " + i + " - > "+func(i));
