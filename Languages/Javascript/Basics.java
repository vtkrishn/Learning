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
alert(typeof(null));//object
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
Create an object in Javascript
var human = {
name : 'vinod',
age : 30,
  wife : {
		name : 'sandhya',
		age : 28
  }
}

alert(human.wife.name);
------
Math
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math
Integer , float, double
arithmetic expression
operator precedence
logical operator
Increment decrement operator
Assignment operator
comparison operator
----
String
https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
Concatenation
alert(typeof Number("1")) // number
alert(tyoeof Number(2).toString()); // string
String length
var x = 'vinod'
//index starts from 0
alert(x.length) // 5
alert(x[0]) // v
alert(x.indexOf('nod')) // 2
alert(x.slice(3)) // od , first 3 character will be sliced
alert(x.slice(-1)) // d , first 3 character will be sliced
alert(x.substr(3)) // od , first 3 character will be sliced

difference between
    string.slice(beginIndex, endIndex) // take two arguments. 1 is required, if begin and end same then it returns empty string
            //NaN is treated as 0
            //use negative number to slice from the end of the string
            //returns the new string
    string.substr(start [, length]) -   //if begin and end same it returns the index,

    substring() , - //extract the substring

charAt() - //like str[4]
charCodeAt() -- // like str[4] but returns the ascii

toLowerCase(), toUpperCase()
