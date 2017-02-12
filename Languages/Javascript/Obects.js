//var c = new Object();
//var c = {} //typedef [object Object]
//var c2 = Object.create(c);
//function c(){

}
var c = {
name : "vinod",
age : 13,
child : {
  simple : 'name',
  click : function(){
    alert('something');
  }
},
nano , 14
};
//c.name
//c.child.sinple
//c.child.click()
//c['child']['simple']
---------------
this
//to access the variable in the function inside the class
--
//constructor
var person = new Person('vinod');
function Person(value){
  this.name = value;
}
--------------
//constructor is the prototype object for the Person and it inherits prototype of the Object.prototype
//Prototype

//Object.prototype - every function will have this property by default to support inheritance
//Object.__proto____   - psuedo proerty

if the object is created using Object then protpotype is inherited from the Object.prototype
if the object is created from the constructor then it inherits from the constructor

----
//accesing JSON
//[0]["power"][0]

//var request = new XMLHttpRequest();
//request.open('GET', requestURL);
//request.responseType = 'json';
//request.send()
