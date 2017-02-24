var canvas = document.querySelector("canvas");
var ctx = canvas.getContext("2d");

var draw = function() {
  var length = document.getElementById("length").value;
  var depth = document.getElementById("depth").value;
  canvas.width = length * 2;
  canvas.height = length * 2;
  var x = canvas.width/2;
  var y = canvas.height/2;

  drawHTree(x,y,length,depth);
}

var drawHTree = function(x,y,length,depth) {
  var x1 = x-length/2;
  var x2 = x+length/2;
  var y1 = y-length/2;
  var y2 = y+length/2;

  if(depth === 0)
    return;

  //draw a horizontal line
  drawLine(x,y,x1,y);
  drawLine(x,y,x2,y);

  //draw left Vertical line
  drawLine(x1,y,x1,y1);
  drawLine(x1,y,x1,y2);

  //draw right Vertical line
  drawLine(x2,y,x2,y1);
  drawLine(x2,y,x2,y2);

  //start drawing H tree from four corners
  drawHTree(x1,y1,length/2,depth-1);
  drawHTree(x1,y2,length/2,depth-1);
  drawHTree(x2,y1,length/2,depth-1);
  drawHTree(x2,y2,length/2,depth-1);
}

var drawLine = function(x1,y1,x2,y2) {
  ctx.moveTo(x1,y1);
  ctx.lineTo(x2,y2);
  ctx.strokeStyle="rgba(120,134,156,.5)";
  ctx.stroke();
}
