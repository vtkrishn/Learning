var canvas = document.querySelector("canvas");
var ctx = canvas.getContext("2d");

var draw = function() {
  var length = document.getElementById("length").value;
  var depth = document.getElementById("depth").value;
  canvas.width = length * 2;
  canvas.height = length * 2;
  var x = canvas.width/2;
  var y = canvas.height/2;

  drawCircle(x,y,length/50);
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
