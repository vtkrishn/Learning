var canvas = document.getElementById('canvas');
var context = canvas.getContext('2d');
width = canvas.width = window.innerWidth;
height = canvas.height = window.innerHeight;

var centerX = width/2;
var centerY = height/2;
var radius = 100;
var speed = 0.1;
var angle = 0;
var x,y;

render();

function render(){
	 //context.clearRect(0,0,width,height);
	 x = centerX  + Math.sin(angle) * radius;
	 y = centerY  + Math.cos(angle) * radius;
	context.beginPath();
	context.arc(x, y, 2, 0 ,Math.PI * 2, false);
	context.fill();

	angle += speed;

	requestAnimationFrame(render);
}
