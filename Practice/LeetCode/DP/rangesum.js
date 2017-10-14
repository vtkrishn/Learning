console.clear();
(function() {

	var a = [-2, 0, 3,-5,2,-1];
	var dp = [];
	dp[0] = 0;
	for (var i = 0; i < a.length; i++)
    dp[i + 1] = dp[i] + a[i];

	console.log(dp);
	console.log(dp[3]-dp[0]);
	console.log(dp[6]-dp[2]);
	console.log(dp[6]-dp[0]);
	console.log(dp[4]-dp[1]);

})();
