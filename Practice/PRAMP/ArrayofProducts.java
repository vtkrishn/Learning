public class YourClassNameHere {
	    public static void main(String[] args) {
	       int[] a = {2,3,4,5};
	       findProduct(a);
	    }

	    public static void findProduct(int[] a){
	      int[] dp = new int[a.length];
	      dp[0] = 1;
	      for(int i=1;i<a.length;i++){
	       dp[i] = dp[i-1] * a[i-1];
	      }
	      int temp  = 1;
	      dp[a.length-1] = a[a.length-1] * dp[a.length-1];
	      for(int i=a.length-1;i>0;i--){
	        temp = temp * a[i];
	        dp[i-1] = temp * dp[i-1];
	      }
	    }
	}
