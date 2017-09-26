(function(exports){
    'use strict';


 console.clear();
 var method = function(arr){
   var lmin = [];
   var rmax = [];

   lmin[0] = arr[0];
   for(var i = 1;i<arr.length;i++)
       lmin[i] = Math.min(lmin[i-1],arr[i]);

   console.log(lmin);

   rmax[arr.length-1] = arr[arr.length-1];
   for(i = arr.length-2;i>=0;i--)
     rmax[i] = Math.max(rmax[i+1],arr[i]);

   console.log(rmax);

   var x=0,y=0;
   var result = -1;
   while(x<arr.length && y < arr.length){
     if(lmin[x] < rmax[y]){
       result = Math.max(result, y-x);
       y++;
     }
     else
       x++;
   }


   return result;
 };

 var arr = [34, 8, 10, 3, 2, 80, 30, 33, 1];
 var result  = method(arr);
 console.log(result);

})(this)
