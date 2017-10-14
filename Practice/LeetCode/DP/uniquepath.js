console.clear();
(function() {

	var a = [
		[1,1,1,1,1,1],
		[1,1,1,1,1,1],
		[1,1,1,1,1,1]
	];

	var m = a.length;
	var n = a[0].length;
	for(var i = 1;i<m;i++){
			for(var j=1;j<n;j++){
				if(i == 0 || j == 0)
					a[i][j] = 1;
				else
					a[i][j] = a[i-1][j] + a[i][j-1];
			}
	}
	console.log(a[m-1][n-1]);

})();
