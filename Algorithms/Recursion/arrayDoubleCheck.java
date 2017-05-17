//Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0.
//array220([1, 2, 20], 0) → true
//array220([3, 30], 0) → true
//array220([3], 0) → false

public boolean array220(int[] nums, int index) {
  if(nums == null || index >= nums.length-1)
    return false;
  if(nums[index + 1] == nums[index] * 10)
    return true;
   return array220(nums,index + 1);
}

//array220([1, 2, 3, 4, 5, 50, 6], 0) → true
/*
  2 = 1*10 = 2 == 10 ->
  3 = 2*10 = 3 == 20 ->
           4 == 30 ->
           5 == 40 ->
           50 == 50 -> true
*/
