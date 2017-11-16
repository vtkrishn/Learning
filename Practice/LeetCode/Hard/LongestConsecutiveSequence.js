/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {
    var set = {};
for(var i = 0;i<nums.length;i++)
	set[nums[i]] = nums[i];

var longest = 0;
for(var i = 0;i<nums.length;i++){
	if(set[nums[i]-1] === undefined){
		var currNum = nums[i];
		var count =1;
		while(set[currNum + 1] !== undefined){
			currNum +=1;
			count +=1;
		}
		longest = Math.max(longest, count);
	}
}
    return longest;
};
