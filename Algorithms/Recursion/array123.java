// Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.
//
// array123([1, 1, 2, 3, 1]) → true
// array123([1, 1, 2, 4, 1]) → false
// array123([1, 1, 2, 1, 2, 3]) → true
public boolean array123(int[] nums) {
  return array(nums,0);
}

public boolean array(int[] nums,int index){
  if(nums == null || nums.length < 3 || index+2 >= nums.length)
  return false;
  return (nums[index] + nums[index + 1] + nums[index + 2] == 6) ? true : array(nums,index + 1);
}
