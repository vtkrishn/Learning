var x = new Map();
x.set('name','vinod');

----
//iteration
var x = new Map();
x.set('name','vinod');
for(var i of x){
  console.log(i);
}
---
//convert from set
var y = Array.from(x);
console.log(y[0][1])
