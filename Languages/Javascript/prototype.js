var p = {
name: 'vinod'
};
function Person(){
}
Person.prototype.add = function(){
  return x;
}
console.log(typeof Person); //function
console.log(typeof Person.prototype);//object
var c = new Person('vinod');
c.constructor = Person;
console.log(typeof c); //object
console.log(typeof c.constructor); //function
c.constructor = Person.prototype;
console.log(typeof c.constructor); //object
function x(){
 console.log('f');
}
console.log(typeof x); //object
