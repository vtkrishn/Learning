public class Solution {
    public int singleNumber(int[] nums) {
        int out = 0;
        for(int i=0;i<nums.length;i++)
            out = out ^ nums[i];
        return out;
    }
}
