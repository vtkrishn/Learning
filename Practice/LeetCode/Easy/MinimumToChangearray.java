public class Solution {
    public int minMoves(int[] nums) {
        if(nums.length < 2)
            return 0;
        int min = nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            min = Math.min(min,nums[i]);
        for(int n : nums)
            sum = sum + (n- min);
        return sum;
    }
}
