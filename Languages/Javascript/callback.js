a(); // functioon hoisting
var x = 0; // global scope
function a(){
var x = 9; // function scope
{
 var x = 1; //function scope
 console.log(x); // 1
}
x++; // 2
console.log(x); // 2, since x is changed
}

console.log(x); // 0
console.log(typeof a); //function
//a.x = 6;
//x = 9;

function mysand(callback){
  console.log('I am doing something');
  //do some thing
  if(callback)
    callback();
}
//cllback function definition
mysand(function(){
  console.log('I am done');
  });
