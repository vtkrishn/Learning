console.clear();
var nums = [0,1,0,2,1,0,1,3,2,1,2,1];
var left = 0;
var right = nums.length-1;
var left_max =0;
var right_max = 0;
var ans = 0;
while(left < right){
		if(nums[left] < nums[right]){
				(nums[left] >= left_max) ? left_max = nums[left] : ans += left_max - nums[left];
				left++;
		}
		else{
			(nums[right] >= right_max) ? right_max = nums[right] : ans += right_max - nums[right];
			right--;
		}
}

console.log(ans);
