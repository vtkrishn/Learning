//count 11 in array
public int array11(int[] nums, int index) {
  if(nums == null || nums.length == 0 || index == nums.length)
    return 0;
  if(nums[index] == 11)
    return 1 + array11(nums,index+1);
  return array11(nums,index+1);
}
