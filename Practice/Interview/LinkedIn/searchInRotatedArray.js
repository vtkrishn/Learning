//iterative
var search = function(nums, target) {
      var start = 0;
      var end = nums.length-1;
      while(start <= end){
        var mid = start + (end-start)/2;

        if(nums[mid] == target)
          return mid;

        if(nums[start] <= nums[mid]){
            if(target < nums[mid] && target >= nums[start])
              end = mid - 1;
            else
              start = mid + 1;
        }
        if(nums[mid] <= nums[end]){
            if(target > nums[mid] && target <= nums[end])
              start = mid + 1;
            else
              end = mid - 1;
        }
      }
      return -1;
    };
    --------------------
    //recursive
    (function(exports){
        'use strict';

        console.clear();

        var search = function(nums, target) {
           //find the pivot

          // if not then do normal binary search

           var pivot = findPivot(nums, 0 , nums.length-1);
           // if there is a pivot then check where to search
          if(pivot === -1)
             return binarySearch(nums,0, nums.length-1);

           if(target > nums[pivot])
             return binarySearch(nums,pivot+1, nums.length-1,target);
           else
             return binarySearch(nums,0, pivot-1,target);

        };

      var binarySearch = function(nums, start, end,target){
        var mid = start + end / 2;
        if(start <= end){
          if(nums[mid] == target)
            return mid;
          if(nums[mid] > target)
            return binarySearch(nums, mid+1, end);
          if(nums[mid] < target)
            return binarySearch(nums, start, mid-1);
        }
        return -1;

      }
        var findPivot = function(nums, start, end){
          if(start > end)
            return -1;
          var mid = start + end / 2;
          if(nums[mid] > nums[mid+1])
              return mid;
          if(nums[mid] < nums[mid-1])
              return mid-1;
          if(nums[mid] < nums[mid-1])
             return findPivot(nums, start, mid-1);
          return findPivot(nums, mid+1,end);
        }

        var nums = [4,5,6,7,1,2,3];
        console.log(search(nums, 4));

    })(typeof window === 'undefined' ? module.exports : window)
