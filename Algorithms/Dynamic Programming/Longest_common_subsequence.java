public class YourClassNameHere {
    public static void main(String[] args) {
        String s1 = "AGGTAB";//"ABCDH";
        String s2 = "GXTXAYB";//"AEDFHR";
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
          for(int j=0;j<=n;j++){
            if(i==0 || j == 0)
              dp[i][j] = 0;
            else if(s1.charAt(i-1) == s2.charAt(j-1))
              dp[i][j] = dp[i-1][j-1] + 1;
            else
              dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
          }
        }
    System.out.println(dp[m][n]);
  }
}
