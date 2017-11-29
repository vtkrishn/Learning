var canvas = document.getElementById('canvas');
var context = canvas.getContext('2d');
width = canvas.width = window.innerWidth;
height = canvas.height = window.innerHeight;

var centerX = height * .5;
var centerY = width * .5;
//var offset = height * .4;
var baseRadius = 100;
var offset = 50;
var speed = 0.1;
var angle = 0;

render();

function render(){
	//Y changes accordingly with sine value of angle
	//var y = centerY + Math.sin(angle) * offset;
	// context.clearRect(0,0,width,height);
	// context.beginPath();
	// context.arc(centerX, y, 50, 0 ,Math.PI * 2, false);
	// context.fill();

	//Y changes accordingly with sine value of angle
	 var radius = Math.cos(angle/2) * offset;
	 context.clearRect(0,0,width,height);
	 context.beginPath();
	 context.arc(centerX  * Math.sin(angle), centerY * Math.cos(angle/2), 5, 0 ,Math.PI * 2, true);
	 context.fill();

	angle += speed;

	requestAnimationFrame(render);
}
