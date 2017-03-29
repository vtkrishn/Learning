public class YourClassNameHere {
    public static void main(String[] args) {
        int[][] arr = {
          {1,2,3},
          {4,8,2},
          {1,5,3}
        };
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++)
          dp[i][0] = dp[i-1][0] + arr[i-1][0];
          
        for(int j=1;j<=n;j++)
          dp[0][j] = dp[0][j-1] + arr[0][j-1];
        
        for(int i=1;i<=m;i++){
          for(int j=1;j<=n;j++){
            dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + arr[i-1][j-1]; 
          }
        }
        
    System.out.println(dp[m][n]);
  }
}
