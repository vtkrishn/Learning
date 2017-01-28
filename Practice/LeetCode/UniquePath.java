public class Solution {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>0;i--){
          dp[i-1][n-1] = 1 ;
          for(int j=n-1;j>0;j--){
            dp[m-1][j-1] = 1 ;
            dp[i-1][j-1] = dp[i-1][j] + dp[i][j-1];
          }
        }
        return m > 1 ? dp[0][0] : 1;
    }
}
