class Solution {
    int[] nums;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        int total = 0;
        int res = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target){
                int x = rand.nextInt(++total);
                res = x == 0 ? i : res;
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
