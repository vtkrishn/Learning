public class NumArray {
    int[] a=null;
    public NumArray(int[] nums) {
        this.a = nums;
    }
    public int sumRange(int i, int j) {
        int sum = 0;
        for(int x=i;x < j+1;x++)
            sum += a[x];
      return sum;
    }
}
------------
public class NumArray {
    static int[] sum=null;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for(int i=0;i<nums.length;i++){
           sum[i+1] = sum[i] + nums[i];
        }
    }
    public static int sumRange(int i, int j) {
      return sum[j+1] - sum[i];
    }

    public static void main(String[] args){
      int[] a = {-2, 0, 3, -5, 2, -1};
      NumArray obj = new NumArray(a);

      System.out.println(obj.sumRange(2,5));
    }
}
--------------------------
package javaproject;

public class NumArray {
    public NumArray() {
        super();
    }
    static int[] array;
    static int[] sum=null;

    public NumArray(int[] nums,boolean flag) {
        if(flag){
        array = nums;
        sum = new int[nums.length+1];
            for(int i=0;i<nums.length;i++){
               sum[i+1] = sum[i] + nums[i];
            }
        }
    }

    public static void main(String[] args){
        //int[] array = {-2, 0, 3, -5, 2, -1};
        int[] arr = {1,2,3,4,5,6};
        NumArray n = new NumArray(array,false);
        long startTime = System.nanoTime();
        sum = new int[arr.length];
        System.out.println(n.sumRange3(arr,1,4));
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime + "ms");

    }
        private static int sumRange2(int i, int j) {
          return sum[j+1] - sum[i];
        }

        private static int sumRange1(int i, int j) {
            int x = i;
            int count = 0;
            while(x < j+1){
                count = count + sum[x];
                x++;
            }
          return count;
        }

    private static int sumRange3(int[] array,int i, int j){
        if(i>j || j+1 > array.length)
            return 0;

        sum[i+1] = sum[i] + array[i];
        sumRange3(array,i+1,j);
        return sum[j+1]-sum[i];
    }
}
