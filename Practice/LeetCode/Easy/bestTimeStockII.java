public class Solution {
    public int maxProfit(int[] prices) {
      if(prices.length<1)
          return 0;
      int start = prices[0];
      int end = 0;
      int currentMax = 0;
      int sum=0;
      for(int i=1;i<prices.length;i++){
			end = prices[i];
			if(prices[i] > prices[i-1]){
				if(currentMax<(end-start)){
					currentMax=end-start;
				}
			}
			else{
				start = end;
				sum = sum + currentMax;
				currentMax=0;
			}
		}
		return sum+currentMax;
    }
}
