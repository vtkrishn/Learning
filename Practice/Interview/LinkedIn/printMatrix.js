(function(exports){
    'use strict';

console.clear();
var arr = [
	[1,2,3,4],
	[5,6,7,8],
	[9,10,11,12]
];

	var printDiag = function(arr){
		var N = arr.length;
		var M = arr[0].length;

		for (var i = N - 1; i >= 0; i--) {
			var row = i;
			var col = 0;
			while (row < N && col < M) {
				console.log(arr[row][col] + "  ");
				row++;
				col++;
			}
			console.log("");
		}

		for (var j = 1; j < M; j++) {
			var col = j;
			var row = 0;
			while (col < M && row < N) {
				console.log(arr[row][col] + "  ");
				col++;
				row++;
			}
			console.log("");
		}
	}

	printDiag(arr);

})(typeof window === 'undefined' ? module.exports : window)
