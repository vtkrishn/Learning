public class YourClassNameHere {
    public static void main(String[] args) {
        //int[] arr = {14,13,45,52,60,35,56,78,22,90,100};
        //int[] arr = {10, 22, 5, 75, 65, 80};
        int[] arr = {12, 14, 17, 10, 14, 13, 12, 15};
        findMaxProfit(arr,2);
    }

    public static int findMaxProfit(int[] arr, int k){
       int[] result = new int[arr.length];
       int max;
       int diff;
       for(int i=0;i<result.length;i++){
        max = arr[i];
        diff=0;
        for(int j=i+1;j<result.length;j++){
             if(arr[j] < arr[i]){
                 break;
             }
             else{
              diff = Math.abs(arr[j]-arr[i]);
              max = Math.max(max,diff);
             }
         }
         result[i] = max > arr[i] ? max : diff;
       }
       return 1;
    }
}
-----------
public class YourClassNameHere {
    public static void main(String[] args) {
        //int[] arr = {14,13,45,52,60,35,56,78,22,90,100};
        //int[] arr = {10, 22, 5, 75, 65, 80};
        int[] arr = {12, 14, 17, 10, 14, 13};
        maxProfit(arr,arr.length,3);
    }

    public static int maxProfit(int price[], int n, int k)
{
    int[][] profit = new int[k+1][n+1];

    for (int i = 0; i <= k; i++)
        profit[i][0] = 0;

    for (int j= 0; j <= n; j++)
        profit[0][j] = 0;

    for (int i = 1; i <= k; i++)
    {
        int prevDiff = Integer.MIN_VALUE;
        for (int j = 1; j < n; j++)
        {
            prevDiff = Math.max(prevDiff,
                           profit[i-1][j-1] - price[j-1]);
            profit[i][j] = Math.max(profit[i][j-1],
                               price[j] + prevDiff);
        }
    }

    return profit[k][n-1];
}
}
