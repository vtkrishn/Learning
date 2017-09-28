(function(exports){
    'use strict';

  console.clear();

  var method = function(arrStrings){
    var result = [];
    var min = Number.MAX_VALUE;
    var item = null;
    for(var i=0;i<arrStrings.length;i++){
       if(arrStrings[i].length < min){
         min = arrStrings[i].length;
         item = arrStrings[i];
       }
    }

    for(var j = 0;j<item.length;j++){
      var ch = item.charAt(j);
      var flag = true;
      for(i = 0;i<arrStrings.length;i++){
        var word = arrStrings[i];
        if(word.indexOf(ch) === -1){
          flag = false;
          break;
        }
      }

      if(flag)
        result.push(ch);

    }

    return result;
  };

  var arr = [
   "aghkafgkit",
   "dfghako",
    "qwemnaarkf"
 ];
  var x = method(arr);
  console.log(x);

})(typeof window === 'undefined' ? module.exports : window)
