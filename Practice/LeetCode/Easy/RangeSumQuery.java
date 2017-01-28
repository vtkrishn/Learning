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
