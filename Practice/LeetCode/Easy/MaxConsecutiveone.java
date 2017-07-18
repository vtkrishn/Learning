public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1)
                sum += 1;
            else{
                max = Math.max(max,sum);
                sum = 0;
            }
        }
        return Math.max(max,sum);
    }
}
