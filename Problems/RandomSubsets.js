console.clear();
function func(a,b){
  console.log("Showing values :: [" + a + "]");
  var result = operation(a,3);
  console.log("result :: " + result);
};

function operation(a,m) {
  var s = [];
  for(var i=0;i<m;i++){
    s[i] = a[i];
  }

  for(var i=m;i<a.length;i++){
    var k = rand(0,i);
    if(k < m){
      s[k] = a[i];
    }
  }

  return s;
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
    for(var i=1;i<=10;i++)
      a.push(i);
   return a;
   }());
