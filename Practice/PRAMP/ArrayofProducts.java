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
---------------------------
public class Solution{

    public static void main(String[] args){
        int arr = {1,2,3,4};
        findProduct(arr);
    }


    private static int[] findProduct(int[] array){
        int totalProduct = array[0];
        int int[] result = new int[array.length];

        for(int i = 1;i<arr.length;i++){
            totalProduct = totalProduct * array[i];
        }

        for(int i = 0;i<arr.length;i++){
            result[i] = totalProduct / arr[i];
        }
    }

    return result;

    //total - 24
    //result[0] = 24/1 = 24
    //result[1] = 24/2 = 12
    //result[2] = 24/3 = 8
    //result[3] = 24/4 = 6
}
