<!DOCTYPE HTML5>
<html>
<script>
function a(){
var requestUEL = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json";
var request = new XMLHttpRequest();
request.open('GET',requestUEL);
request.responseType = 'json';
	request.send();
	var response = request.response;
	request.onload = function(){
	var response = request.response;
	var responseElement = document.createElement('div');
	responseElement.innerHTML = response["squadName"];
	document.body.appendChild(responseElement);
}
	var responseElement = document.createElement('div');
	responseElement.innerHTML = response;
	document.body.appendChild(responseElement);
}
</script>
<body>
<input type='button' value='click' onclick='a()'/>
</body>
</html>
