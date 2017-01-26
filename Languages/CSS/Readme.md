CSS

<head>
  <link rel="stylesheet" href="styles.css">
</head>

The CSS padding property defines a padding (space) between the text and the border:
The CSS margin property defines a margin (space) outside the border:
To define a specific style for one special element, add an id attribute to the element:

<p id="p01">I am different</p>


'#p01 {
    color: blue;
}'

To define a style for a special type of elements, add a class attribute to the element:

<p class="error">I am different</p>

p.error {
    color: red;
}

external references
 <link rel="stylesheet" href="http://www.w3schools.com/html/styles.css">

 <link rel="stylesheet" href="/html/styles.css">
  <link rel="stylesheet" href="styles.css">

  <style>
a:link    {color:green; background-color:transparent; text-decoration:none}
a:visited {color:pink; background-color:transparent; text-decoration:none}
a:hover   {color:red; background-color:transparent; text-decoration:underline}
a:active  {color:yellow; background-color:transparent; text-decoration:underline}
</style>

imagemap
<img src="planets.gif" alt="Planets" usemap="#planetmap" style="width:145px;height:126px;">

<map name="planetmap">
 <area shape="rect" coords="0,0,82,126" alt="Sun" href="sun.htm">
 <area shape="circle" coords="90,58,3" alt="Mercury" href="mercur.htm">
 <area shape="circle" coords="124,58,8" alt="Venus" href="venus.htm">
</map>


<meta charset="UTF-8">
<meta name="description" content="Free Web tutorials">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="John Doe">



<meta name="viewport" content="width=device-width, initial-scale=1.0">

The <base> element specifies the base URL and base target for all relative URLs in a page:
<base href="http://www.w3schools.com/images/" target="_blank">
