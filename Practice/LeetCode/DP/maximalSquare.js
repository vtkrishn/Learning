console.clear();

var func = function(arr){
	var count = 0;
	var dp = [];
	for(var k = 0;k<=arr.length;k++)
		dp[k] = 0;

	var prev = 0;
	var max = 0;
	for(var i=1;i<arr.length;i++){
		for(var j=1;j<arr[0].length;j++){
				var temp = dp[j];
				if(arr[i-1][j-1] === 1){
						dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j]) + 1;
					  max = Math.max(max,dp[j]);
				}
				else{
					dp[j] = 0;
				}
				prev = temp;
		}
	}
	console.log(max * max);
}

var nums = [
	[0,0,1,0,0],
	[1,0,1,1,1],
	[1,0,1,1,1],
	[1,0,0,1,0]
];
func(nums);
