public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] a = {7, 1, 5, 3, 6, 4};
	      maxProfit(a);
	    }

	  public static int maxProfit(int[] prices) {
        int max = 0;
        int currMax = 0;
        for(int i=1;i<prices.length;i++){
            currMax = Math.max(0, currMax + prices[i] - prices[i-1]);
            max = Math.max(max,currMax);
        }
        return max;
    }
}
--------------
public class YourClassNameHere {
	    public static void main(String[] args) {
	      int[] a = {7, 1, 5, 3, 6, 4};
	      maxProfit(a);
	    }

	  public static int maxProfit(int[] prices) {
    int maxPro = 0;
    int minPrice = Integer.MAX_VALUE;
    for(int i = 0; i < prices.length; i++){
        minPrice = Math.min(minPrice, prices[i]);
        maxPro = Math.max(maxPro, prices[i] - minPrice);
    }
    return maxPro;
}
}
