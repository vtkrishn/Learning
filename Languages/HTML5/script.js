var canvas = document.querySelector("canvas");
var ctx = canvas.getContext("2d");
var slider = document.getElementById("slider");

var draw = function() {
  var length = document.getElementById("length").value;
  var depth = document.getElementById("depth").value;
  canvas.width = length * 2;
  canvas.height = length * 2;
  context.clearRect(0, 0, canvas.width, canvas.height);
  var x = canvas.width/2;
  var y = canvas.height;
  var value = 0.1 * slider.value;
  drawBranch(x,y,100,depth);
}

var drawBranch = function(x,y,length, depth) {

  if(depth == 0)
    return;

  drawLine(x,y,x,y-length);
  //left
  drawLine(x,y-length,x-length/depth,y-length*value);
  //right

  drawLine(x,y-length,x+length/depth,y-length*value);

  drawBranch(x-length/depth,y-length*value,length/2,depth-1);
  drawBranch(x+length/depth,y-length*value,length/2,depth-1);
}


var drawLine = function(x1,y1,x2,y2) {
  ctx.moveTo(x1,y1);
  ctx.lineTo(x2,y2);
  ctx.strokeStyle="rgba(120,134,156,.5)";
  ctx.stroke();
}

var drawCircle = function(x,y,radius) {
  ctx.arc(x, y, radius, 0, 2 * Math.PI, false);
        ctx.lineWidth = 1;
        ctx.stroke();
}
