public class Solution {

    public int climbStairs(int n) {
        int[] sum = new int[n+2];
        sum[0] = 0;
        sum[1] = 1;
        if(n == 1)
            return sum[1];
        if(n == 0)
            return sum[0];

        for(int i=2;i<=n+1;i++){
            sum[i] = sum[i-1] + sum[i-2];
        }
        return sum[n+1];
    }
}
