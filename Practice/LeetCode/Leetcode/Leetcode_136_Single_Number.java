public class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null)
            return -1;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            count = count ^ nums[i];
        }
        return count;    
    }
}
