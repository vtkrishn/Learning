(function(exports){
    'use strict';


 console.clear();
 var method = function(arr){
   var result = [];
   var j = 0;
   for(var i = 0;i<arr.length;i++){
       if(arr[i] in result){
         result.shift(arr.indexOf(arr[i]));
       }
     else{
       result.push(arr[i]);
     }
   }

   return result;
 };

 var arr = [1, 2, 1];
 var result  = method(arr);
 console.log(result);

})(this)
