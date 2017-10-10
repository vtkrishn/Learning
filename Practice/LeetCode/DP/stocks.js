/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    var dp = [];
    var min = prices[0];
    var max = 0;
    for(var i = 1;i<prices.length;i++){
        min = Math.min(min,prices[i]);
        dp[i-1] = prices[i] - min > 0 ? prices[i] - min : 0;
        max = Math.max(max,dp[i-1]);
    }
    return max;
};
