public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];
        for(int i=1;i<nums.length;i++){
            currentMax = Math.max(currentMax + nums[i],nums[i]);
            max = Math.max(currentMax,max);
        }
        return max;
    }
}
-------------------
public class Solution {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
}
}   
