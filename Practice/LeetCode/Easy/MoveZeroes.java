public class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
                //check if the array is empty
                    for(int i=0;i<nums.length;i++){
                        if(nums[i] != 0){
                            nums = swap(i,j,nums);
                            j++;
                        }
                    }
        }


    private int[] swap (int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        return nums;
    }
}
-------------
public class Solution {
        public void moveZeroes(int[] nums) {
            int j=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] != 0)
                    nums[j++] = nums[i];
            }

            while(j<nums.length)
                nums[j++] = 0;
        }
}
