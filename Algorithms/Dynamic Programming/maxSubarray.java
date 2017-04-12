public class YourClassNameHere {
    public static void main(String[] args) {
      int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
      int[] dp = new int[arr.length];
      dp[0] = arr[0];
      int max=dp[0];
      for(int i=1;i<arr.length;i++){
        dp[i] = arr[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
        max = Math.max(max,dp[i]);
      }
      System.out.println(dp[arr.length-1]);
    }
}
