(function(exports){
    'use strict';


 console.clear();
 var method = function(arr,merge){

   var result = [];

   var i = 0;
    while(i < arr.length && arr[i][1] < merge[0]){
      result.push([arr[i][0],arr[i][1]]);
      i++;
    }

   while(i < arr.length && arr[i][0] <= merge[1]){
    merge = [Math.min(merge[0],arr[i][0]), Math.max(merge[1],arr[i][1])];
     i++;
    }

   result.push(merge);

   while(i < arr.length){
      result.push([arr[i][0],arr[i][1]]);
      i++;
    }

   return result;
 };

 var arr = [[1,2],[3,5],[6,7],[8,10],[12,16]];
 var result  = method(arr,[4,9]);
 console.log(result);

})(this)
