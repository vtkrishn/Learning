(function(exports){
    'use strict';

  console.clear();

  var list = [];
  var method = function(arr, target){
    for(var i=0;i<arr.length;i++){
      chkSum(arr, i, target,target,[]);
    }
  }

  var chkSum = function(arr, i, target, sum,result){
    if(sum < 0 || i > arr.length)
        return 0;

    if(sum === 0){
      console.log(result);
    }

    for(var k = i;k<arr.length;k++){
        result.push(arr[k]);
        chkSum(arr, k+1, target, sum - arr[k], result);
        result.pop(arr[k]);
    }
  }

  console.log(method([1,3,4,5,6,15],15));


})(typeof window === 'undefined' ? module.exports : window)
