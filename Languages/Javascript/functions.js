//function can be like
function myfunction(){ // normal function
  //your code
};
//or
function myfunction(parameter){ //function with parameter
  //your code
};
//or
function(){ //anonymous
  //your code
};
//or
 var myFunction = function(){ // function can be reused by assigning to a variable
   //your code
 };
//invoked by
myFunction();
//or can be passed a parameter
div.addEventListenner('click',myFunction);

//function can call another function
//Scopes
//Global Scope
//anything outise the function

//local Scope
//anything inside the function

-----------------
<!DOCTYPE HTML5>
<html>
<script>
var global = 12; //global scope
function a(){
var x = 11; // local scope
alert('inside a' + x);
alert('value of global' + global);
b();
}

function b(){
var y = 10;
alert('inside b' + x); // x is not defined inside b, even its called from a()
}
</script>
<body>
<input type='button' value='click' onclick='a()'/>
</body>
</html>
------------------
//Callback function
function a(x,callback){
alert('I am doing something',x);
if(typeof callback === 'function')
  callback();
}

a(1,function(){
alert('I am done');
});
----------------------------
 e.preventDefault() // prevent the alert message to be shown to the user
//event Bubbling
two event called on the same element
div.onclick = function (){
  video.pause();
}

divBox.onclick = function (){
  video.play();
}
//bubbling phase
//capturing phase
----------
