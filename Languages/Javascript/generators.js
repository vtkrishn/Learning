function* idMaker() {
  var index = 0;
  while(true)
    yield index++;
}

var gen = idMaker();

console.log(gen.next().value); // 0
console.log(gen.next().value); // 1
console.log(gen.next().value); // 2
-------

function* gg(){
 yield 1;
 yield 2;
 yield 3;
}

var g  = gg();
for(let x of g){
 console.log(x);
}
