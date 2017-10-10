/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    var currentMax = nums[0];
		var max = nums[0];
		for(var i=1;i<nums.length;i++){
	        currentMax = Math.max(nums[i],currentMax + nums[i]);
		    max = Math.max(max,currentMax);
		}
		return max;
};
// --------------------------
// arr = [-2,1,-3,4,-1,2,1,-5,4]
// currentMax = nums[0] = -2
//
// index  nums[index]	 currentMax (max (value, value + previous currentMax))
// 1       1             max(1, 1 + -2) =   1
// 2      -3             max(-3, -3 + 1) = -2
// 3       4             max(4, 4 + -2) =   4
// 4      -1             max(-1, -1 + 4) =  3
// 5       2             max(2, 2 + 3) =    5
// 6       1             max(1, 1 + 5) =    6
// 7      -5             max(-5, -5 + 6) =  1
// 8       4             max(4, 4 + 1) =    5
//
// max of currentMax = 6
// -----------------------------
//dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
// dp[0] = -2
// dp[1] = 1 + (0) =   1
// dp[2] = -3 + (1) = -2
// dp[3] = 4 + (0)  =  4
// dp[4] = -1 + (4) =  3
// dp[5] = 2 + (3)  =  5
// dp[6] = 1 + (0)  =  6
// dp[7] = -5 + (6) =  1
// dp[8] = 4 + (1)  =  5
//
// max of dp = 6
