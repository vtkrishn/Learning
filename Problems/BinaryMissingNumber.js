console.clear();
function func(a,b){
  console.log("Showing values :: [" + a + "]");
  var result = operation(a);
  console.log("result :: " + result);
};

function operation(a) {
  var mask = 1;
  var result = 0;
  for(var col = 0;col <= 31;col++){
    var one = [];
    var zero = [];
    for(var i=0;i<a.length;i++){
      var item = a[i];
      var k = (item & mask) << col;
      if(k === 0)
        zero.push(item);
      else
        one.push(item);
    }
    if(zero.length <= one.length)
      result = (result << 1) | 0;
    else
      result = (result << 1) | 1;
  }

  return result;

};

function rand(start, end){
  return start + parseInt(Math.random() * (end - start + 1));
}

function swap(a, i, j){
  var temp = a[j];
  a[j] = a[i];
  a[i] = temp;
}

(function wrapper(a){
   func(a);
})(function (){
   var a = [];
    for(var i=1;i<=6;i++)
      if(i !== 5)
        a.push(i);
   return a;
   }());
