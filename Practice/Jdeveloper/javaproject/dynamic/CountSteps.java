package javaproject.dynamic;

public class CountSteps {
    public CountSteps() {
        super();
    }
    
    public static void main(String[] args){
        int n = 37;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        //options of hop 1,2,3
        //System.out.println(count(n));
        System.out.println(countDP(n,dp));
    }
    
    public static int count(int n){
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        return count(n - 1) + count(n-2) + count(n-3);
    }
    
    public static int countDP(int n,int[] dp){
        if(n < 0)
            return 0;
        if(n == 0)
            return 1;
        dp[n] = countDP(n-1, dp) + countDP(n-2, dp) + countDP(n-3, dp);
        return dp[n];
    }
}
