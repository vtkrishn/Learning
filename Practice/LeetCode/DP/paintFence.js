console.clear();
(function() {

	var a = [1,1,1,1]; //fence
	var dp = [];
	var k = 3; //paint
	dp[0] = 0;
	dp[1] = k;
	var diff = dp[1];
	var same = 0;
	for(var i=2;i<a.length;i++){
		same = diff;
		var diff = dp[i-1]*k;
		dp[i] = diff + same;
	}
	console.log(dp)
})();
