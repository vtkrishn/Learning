function outside(x) {
  function inside(y) {
    return x + y;
  }
  return inside;
}
fn_inside = outside(3); // Think of it like: give me a function that adds 3 to whatever you give it
result = fn_inside(5); // returns 8

result1 = outside(3)(5); // returns 8
-------------------
function A(x) {
  function B(y) {
    function C(z) {
      console.log(x + y + z);
    }
    C(3);
  }
  B(2);
}
A(1); // logs 6 (1 + 2 + 3)
---------------
var a = function(){
 var name = 'vinod';
 return function b(value){
    name = value;
    return name;
 }
}

console.log(a()(123));//123
-------------------------
function a(x,y=4){
 return x * y;
}

console.log(a(5));
