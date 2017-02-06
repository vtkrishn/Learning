public class Solution {
    public int rob(int[] nums) {
        int[] dp= new int[nums.length];
        int include = 0;
        int exclude = 0;
        for(int i=0;i<nums.length;i++){
            int temp = include;
            include = exclude + nums[i];
            exclude = Math.max(temp,exclude);
        }
        return Math.max(include,exclude);
    }
}
