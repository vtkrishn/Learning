
public class Solution {
    public static void main(String[] args) {
      int[] nums ={1,1,2};
      singleNonDuplicate(nums);
    }

    public static int singleNonDuplicate(int[] nums) {
         if(nums.length < 3)
            return -1;
        if(nums[0] != nums[1])
            return nums[0];
        return single(nums,0);
    }

    public static int single(int[] nums, int index){
        if(index+2 >= nums.length)
            return nums[index+1];
        if(nums[index] != nums[index+1] && nums[index+1] != nums[index+2])
            return nums[index+1];
        return single(nums,index+1);
    }

}
--------
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        return (nums.length < 3) ? -1 : (nums[0] != nums[1] ? nums[0] : single(nums,0));
    }

    public int single(int[] nums, int index){
        return (index+2 >= nums.length) ? nums[index+1] : (nums[index] != nums[index+1] && nums[index+1] != nums[index+2] ? nums[index+1] : single(nums,index+1));
    }

}
