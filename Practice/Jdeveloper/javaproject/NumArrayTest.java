package javaproject;

public class NumArrayTest {
    static int[] sum=null;
    public NumArrayTest(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = nums[0];
        for(int i=0;i<nums.length;i++){
           sum[i+1] = sum[i] + nums[i]; //0 -2 -2 1 -4 -2 -3
            //sum[i] = sum[i-1] + nums[i]; //-2 5 8 3 5 4 0
        }
    }
    public static int sumRange(int i, int j) {
      return sum[j+1] - sum[i];
    }

    public static void main(String[] args){
      int[] a = {-2, 7, 3, -5, 2, -1};
      NumArrayTest obj = new NumArrayTest(a);

      System.out.println(obj.sumRange(2,5)); // -1
    }
}
