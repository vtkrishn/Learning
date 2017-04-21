package javaproject;

public class LeastCommonSubsequence {
    public LeastCommonSubsequence() {
        super();
    }

    public static void main(String[] args){
        String s1 = "BA";
        String s2 = "BBAB";
        System.out.println(LCS(s1, s2, s1.length(), s2.length()));
    }

    private static int LCS(String s1,String s2,int i, int j){
        if(i == 0 || j == 0)
            return 0;
        if(s1.charAt(i-1) == s2.charAt(j-1))
            return LCS(s1, s2, i-1, j-1) + 1;
        else
            return Math.max(LCS(s1,s2,i-1,j),LCS(s1,s2,i,j-1));
    }
}

------------------------------------
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
