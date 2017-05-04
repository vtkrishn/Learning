var canvas = document.querySelector("canvas");
var ctx = canvas.getContext("2d");
var canvasConstant = 200;

var draw = function() {
  var row = document.getElementById("row").value;
  var col = document.getElementById("col").value;
  canvas.width = canvasConstant + (col * 150);
  canvas.height = canvasConstant + (row * 150);

  var x = canvas.width/100;
  var y = canvas.height/100;

  drawMaze(x,y,row,col);
}

var drawMaze = function(x,y,row,col) {
  // drawBox(x,y,row,col, 100);
  // drawBox(x,y,row,col,3);
  // drawBox(x+100,y+100,row,col,1);
  // drawBox(x+200,y+200,row,col,2);
sine(x,y,60);
}

var sine = function(x,y){
  drawLine(x+100,y+100,x+100,y+400);
}

var drawBox = function(x,y,row,col,size){
  //draw the box
  x1 = x+canvasConstant + (col * size);
  y1 = y+canvasConstant + (row * size);
  x2 = x-canvasConstant + (col * size);
  y2 = y-canvasConstant + (row * size);

  drawLine(x,y,x,y1);
  drawLine(x,y1,x1,y1);
  drawLine(x1,y1,x1,y);
  drawLine(x1,y,x,y);
}

var drawLine = function(x1,y1,x2,y2) {
  ctx.moveTo(x1,y1);
  ctx.lineTo(x2,y2);
  ctx.strokeStyle="rgba(120,134,156,.5)";
  ctx.stroke();
}
