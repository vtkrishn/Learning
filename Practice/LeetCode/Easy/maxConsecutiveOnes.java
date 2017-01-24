public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1)
                currMax++;
            else{
                    max = Math.max(currMax,max);
                    currMax = 0;
                }
        }

        return Math.max(currMax,max);
    }
}
