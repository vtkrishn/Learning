package javaproject;

public class TotalSum {
    static int result;
    public TotalSum() {
        super();
    }
    
    public static void main(String[] args){
        int[] arr = {1,1,1};
        
        long startTime = System.nanoTime();
        helper(arr, 3,0,0);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.println("Time taken : " + (endTime - startTime) + "ms");
    }
    
    private static void helper(int[] arr,int target, int position, int sum){
        if(position == arr.length){
            if(sum == target)
                result++;
                return;
        }
        
        helper(arr, target, position + 1, sum + arr[position]);
        helper(arr, target, position + 1, sum - arr[position]);
    }
}
