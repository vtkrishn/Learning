package javaproject;

public class BalloonBurst {
    public BalloonBurst() {
        super();
    }
    

        public static void main(String[] args) {
          int[] num = {3,1,5,8};
          maxCoins(num);
        }
        
        public static int maxCoins(int[] nums) {
            int start = 0;
            int end = 2;
            int cost = compute(nums,start,end);
           // nums = 
            return 0;
        }
        
        public static int compute(int[] nums,int start, int end){
            int max = 0;
            int cost = 0;
            int index = 0;
            while(end < nums.length){
                while(end < nums.length){
                    int tempCost = nums[start] * nums[end];
                    if(tempCost>max){
                        max = tempCost;
                        index = end-1;
                    }
                    start++;
                    end++;
                }
            cost += max;
        }
            return cost;
        }

}
