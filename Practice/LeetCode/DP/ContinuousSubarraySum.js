console.clear();
var result = function(nums,k){
	var dp = [];
	if(nums.length < 2)
		return false;

	for(var i = 0;i<nums.length;i++){
		for(var j = i;j<nums.length;j++){
			if(i===j){
				dp[j]=nums[i];
			}
			else{
				dp[j] = dp[j-1] + nums[j];
			}
			if ((k != 0 && dp[j] % k == 0) || (k == 0 && dp[j] == 0))
        return true;

			dp[j-1] = 0;
		}
		if(dp[nums.length-1] === 0)
			return false;
	}
}

var nums1 = [23, 2, 4, 6, 7];
var nums2 = [0,0];
console.log(result(nums1,6));
console.log(result(nums1,0));
console.log(result(nums2,0));
