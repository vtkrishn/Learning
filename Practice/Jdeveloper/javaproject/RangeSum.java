package javaproject;

public class RangeSum {
    public RangeSum() {
        super();
    }
    static int[] sum;
    public static void main(String[] args){
        int[] arr = {-2, 0, 3, -5, 2, -1};
        //int[] arr = {1,2,3,4,5,6};
        sum = new int[arr.length];
        long startTime = System.nanoTime();
        System.out.println(sumRange(arr,2,4));
        long endTime = System.nanoTime();
        
        System.out.println(endTime - startTime + "ms");
    }
    
    private static int sumRange(int[] arr,int i, int j){
        if(i>j || j+1 > arr.length)
            return 0;
        
        sum[i+1] = sum[i] + arr[i];
        sumRange(arr,i+1,j);
        return sum[j+1]-sum[i];
    }
    
}
