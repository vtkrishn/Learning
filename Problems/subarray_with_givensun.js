(function(exports){
    'use strict';


 console.clear();
 var method = function(arr, val){
   for(var i=0;i<arr.length;i++){
     var j = i;
     var sum = 0;
     while(sum < val){
       sum += arr[j];
       if(sum > val)
         break;
       else if(sum === val)
         return [i,j];
       else
         j++;
     }
   }
 };

 var arr = [1,2,3,4,5,6,7,8,9,10];
 var result  = method(arr,15);
 console.log(result);

})(this)
