public class YourClassNameHere {
    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int n = 10;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++){
         for(int j = coins[i];j<=n;j++){
              dp[j]= dp[j] + dp[j-coins[i]];
         }
        }

        System.out.println(dp[n]);
  }
}

----------------
//the above code is simplified version of dp with two dimensional array
//the above code updates the same row again and again
//also int this case our calculation is mosly dependant of the value of j
public class YourClassNameHere {
    public static void main(String[] args) {
        int[] coins = {2,3,5,6};
        int n = 10;
        int[][] dp = new int[n+1][coins.length+1];
        for(int i=0;i<coins.length;i++){
         for(int j = 0;j<n;j++){
           if(j>=coins[i])
              dp[i][j]= dp[i-1][j] + dp[i][j-coins[i]];
           else
             dp[i][j]= dp[i-1][j];
         }
        }

        System.out.println(dp[n-1][coins.length-1]);
  }
}
