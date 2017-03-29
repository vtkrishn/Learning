public class YourClassNameHere {
    public static void main(String[] args) {
        int[] a = {3,2};
        //{10, 22, 9, 33, 21, 50, 41, 60};
        //{50, 3, 10, 7, 40, 80};
        //{3,10,2,1,20};
        int[] dp = new int[a.length];
        int j=0;
        dp[0] = 1;
        int max = 0;
        for(int i=1;i<a.length;i++){
          if(a[i] > a[j])
            dp[i] = dp[j] + 1;
          else
            dp[i] = dp[j];
            
          max = Math.max(max,dp[i]);
          j++;
        }
        System.out.println(max);
    }
}
