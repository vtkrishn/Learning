-----------------------------------------
1 Two Sum 23.0% Easy
-----------------------------------------
var twoSum = function(nums, target) {
      console.log(nums);
      var map = {};

      for(var i=0;i<nums.length;i++){
         if(map[target-nums[i]] !== undefined)
           return [map[target-nums[i]],i];
         else
           map[nums[i]] = i;
      }
    };
------
//python

class Solution(object):
    def twoSum(self, nums, target):
        map = {}
        for i in range(len(nums)):
            if target-nums[i] in map.keys():
                return [map[target-nums[i]],i]
            else:
                map[nums[i]] = i
