public class YourClassNameHere {
	    public static void main(String[] args) {
	        findSum(8);
	    }

	    public static int findSum(int value){
	      int[] dp = new int[value+1];

	      dp[0] = 1;
	      dp[1] = 1;
	      dp[2] = 1;
	      dp[3] = 2;
	      for(int i=4;i<=value;i++){
	        dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
	      }

	      return dp[value];
	    }
	}
