<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
<canvas id="canvas" />
</body>
</html>
-------------
console.clear();
var canvas = document.getElementById('canvas');
var ctx=canvas.getContext("2d");
var width = canvas.width = window.innerWidth;
var height = canvas.height = window.innerHeight;

for(var i = 0;i<100;i++){
	ctx.beginPath();
	ctx.moveTo(Math.random()*width , Math.random()*height);
		ctx.lineTo(Math.random()*width , Math.random()*height);
	ctx.stroke();
}
