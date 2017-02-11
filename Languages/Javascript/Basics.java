var myHeading = document.querySelector('h1');
myHeading.textContent = 'vinod';
-----------------------------
<h1>d</h1>
will change to
<h1>vinod</h1>

-----------------------------
Variable Data Types

String - '', or ""
Number - 10,3.4
Boolean - true/false
Array - []
Object - {};
----------------------------
difference between == and ===
var one = 1;
var oneString = '1';
alert(one == oneString); // true
alert(one === oneString); // false
type Coercion
=== is string equality
== compares the value
---------------
alert(NaN == 1);//false
alert(NaN === 1);//false
alert(typeof NaN);//number
---------------------------
difference between '' and ""
can "" can be used inside the '' like

Template literals
like <pre> tag in html
newline we do not want to escape with \n character
alert(`single quoted




single`);
---------------------------
change image
<img src="http://www.w3schools.com/tags/smiley.gif"/>
var myImage = document.querySelector('img');

myImage.onclick = function() {
    var mySrc = myImage.getAttribute('src');
    if(mySrc === 'http://www.w3schools.com/tags/smiley.gif') {
      myImage.setAttribute ('src','https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png');
    } else {
      myImage.setAttribute ('src','http://www.w3schools.com/tags/smiley.gif');
    }
}
-----------------------
dialog with imnput text
use prompt();
function setUserName() {
  var myName = prompt('Please enter your name.');
  localStorage.setItem('name', myName);
  myHeading.textContent = 'Mozilla is cool, ' + myName;
}
localStorage.setItem is used to store the value, like key value pair
see in profiles in localStorage in google chrome
localStorage.getItem to get the item using the key
-----------------
