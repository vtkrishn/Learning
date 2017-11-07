console.clear();

var func = function(ring,key){
	var pruneClock  = 0;
	var dp = [Number.MAX,Number.MAX];
	for(var i = 0;i<key.length;i++){
		var clock=1;
		var antiClock=1;
		for(var j = 0;j<ring.length;j++){
			if(key[i] === ring[j]){
				clock += j;
				for(var k = ring.length-1;k>=0;k--){
					if(key[i] === ring[k]){
						antiClock = ring.length-k;
						break;
					}
				}
				console.log("i :" +i+" clock :"+ clock +" antiClock :"+ antiClock);
				dp[i] = Math.min(clock,antiClock);
				console.log(dp[i]);
				pruneClock += dp[i];
				break;
			}
		}
	}
	return pruneClock;
}

var ring = "godding";
var key = "gd";
console.log(func(ring,key));
