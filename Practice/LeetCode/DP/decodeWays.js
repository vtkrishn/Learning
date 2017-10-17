/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    var n = s.length;
    if(s === null || n === 0) return 0;
    var dp = [];
    dp[0] = 1;
    dp[1] = s.charAt(0) !== '0' ? 1 : 0;
    for(var i=2;i<=n;i++){
        var ch1 = parseInt(s.substring(i-1,i));
        var ch2 = parseInt(s.substring(i-2,i));

        if(ch1 >= 1 && ch1 <=9)
            dp[i] = dp[i-1];
        if(ch2 >= 10 && ch2 <= 26)
            dp[i] += dp[i-2];
    }
    console.log(dp[n]);
};

numDecodings("12");
