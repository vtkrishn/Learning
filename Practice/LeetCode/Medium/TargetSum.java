public class Solution {
    int results = 0;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length== 0)
            return results;

        helper(nums,target, 0, 0);
        return results;
    }

    private void helper(int[] nums, int target, int index,int sum){
        if(index == nums.length){
            if(target == sum) results++;
            return;
        }

        helper(nums,target, index + 1, sum + nums[index]);
        helper(nums,target, index + 1, sum - nums[index]);
    }
}
