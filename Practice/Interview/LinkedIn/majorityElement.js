(function(exports){
    'use strict';

    console.clear()

    var method = function(arr){
      var count=0, ret = 0;
    for (var i = 0;i<arr.length;i++) {
        if (count===0)
            ret = arr[i];
        if (arr[i] !== ret)
            count--;
        else
            count++;
    }
    return ret;

    }

    var arr = [2,2,2,4,1,1,3];
    var x = method(arr);
    console.log(x);
})(typeof window === 'undefined' ? module.exports : window)
