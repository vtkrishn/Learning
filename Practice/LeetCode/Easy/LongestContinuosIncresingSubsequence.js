/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
    if(nums.length === 0)
        return 0;
    var max = 1;
    var currentMax  = 1;
    for(var i=1;i<nums.length;i++){
        if(nums[i] > nums[i-1])
          currentMax += 1;
        else{
          max = currentMax > max ? currentMax : max
          currentMax = 1;
        }
    }
    return currentMax > max ? currentMax : max;
  };
