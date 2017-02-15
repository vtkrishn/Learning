<!DOCTYPE HTML5>
<html>
<script>
function a(){
	var canvas = document.querySelector('canvas');
	var ctx = canvas.getContext('2d');
	ctx.beginPath();
	//ctx.fillStyle = 'rgb(' + Math.random() * 255 + ',' +
    //                 Math.random() * 255 + ',' +
    //                 Math.random() * 255+')';
	ctx.fillStyle = 'blue';
	ctx.arc(Math.random() * 255,Math.random() * 255,Math.random() * 100,0,2*Math.PI);
	//ctx.stroke();
	ctx.fill();
}
</script>
<body>
<input type='button' value='click' onclick='a()'/>
<canvas/>
</body>
</html>
