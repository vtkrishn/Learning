console.clear();
function func(a,b){
  console.log("Showing values :: [" + a + "]");
  var result = operation(a);
  console.log("result :: " + result);
};

function operation(a) {

  for (var i = 0;i<a.length;i++){
    var k = rand(0,i);
    swap(a,i,k);
  }
  return a;
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
    for(var i=1;i<=52;i++)
      a.push(i);
   return a;
   }());
