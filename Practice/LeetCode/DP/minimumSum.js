console.clear();
(function() {

	var a = [
		[1,1,5],
		[1,5,1],
		[2,1,1]
	];

	var m = a.length;
	var n = a[0].length;
	for(var i = 0;i<m;i++){
			for(var j=0;j<n;j++){
				if(i==0 && j != 0)
					a[i][j] = a[i][j] + a[i][j-1];
				else if(j==0 && i != 0)
					a[i][j] = a[i][j] + a[i-1][j];
				else if(j==0 && i == 0)
					a[i][j] = a[i][j];
				else
					a[i][j] = a[i][j] + Math.min(a[i-1][j], a[i][j-1]);
			}
	}
	console.log(a[m-1][n-1]);

})();
