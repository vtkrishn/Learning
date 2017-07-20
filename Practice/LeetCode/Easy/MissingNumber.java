public class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum =  (len)*(len+1)/2;
        for(int n : nums)
            sum -= n;
        return sum;
    }
}
