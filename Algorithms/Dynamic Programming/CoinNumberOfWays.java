package javaproject;

import java.util.Arrays;

public class Solution8 {
    public Solution8() {
        super();
    }
    static int count;
    static StringBuilder stb = new StringBuilder();
    public static void main(String[] args){
        //int[] numbers = {2,3,7};
        //findNubmer(12,numbers);
        int[] nums = {3,5,10};
        findNubmer(13,nums);
        //findNubmer(20,nums);

    }


    public static void findNubmer(int n,int[] nums){
        //assign a dp array 1 more than n
        int[] dp = new int[n+1];
        //iterate for the length
        for(int i=0;i<dp.length;i++){
            //the least coin is 3, and anything less than that will have 0 stored in the dp for the index
            if(i < nums[0])
                dp[i] = 0;
            //if anything is getting exactly divided then we set the value to 1
            if(i%nums[2] == 0 || i%nums[1] == 0 || i%nums[0] == 0)
                dp[i] = 1;
                //we repeatedly divide by the highest number only if the value is greater than that number,
                //26-10=16 which makes sense to divide again with the same number
                //13-10=3 which does makes sense to divide with 10 again
                if(i-nums[2] > nums[2])
                    dp[i] = dp[i-nums[2]] + 1; //we have to check the previous value and add it to 1 to compute
                else if(i-nums[1] > nums[1])
                    dp[i] = dp[i-nums[1]] + 1;
                else if(i-nums[0] > nums[0])
                    dp[i] = dp[i-nums[0]] + 1;

        }
        System.out.println(Arrays.toString(nums) +"/"+n +" : "+ dp[n]);
    }
}
