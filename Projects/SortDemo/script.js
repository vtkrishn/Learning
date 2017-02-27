var arr = document.getElementById('array');
var count = 0;
var max = 200;

for(var i = 0;i<max;i++){
	var c = document.createElement('div');
	c.id = 'child' + (count++);
	c.style.cssText = 'width : ' + parseInt(Math.random()* (100 - 10) + 10) + 'px; height:'+ .5 +'px; border: 1px solid;transition: 25s;';
	arr.appendChild(c);
}

var sort = function (){
	for(var i=0;i<max;i++){
		for(var j=0;j<max;j++){
			
			var child0 = document.getElementById('child'+i);
			var child1 = document.getElementById('child'+j);
			
			var child0Width = child0.style.width.length;
			var child1Width = child1.style.width.length;
			
			var a = child0.style.width.substring(0,child0Width-2);
			var b = child1.style.width.substring(0,child1Width-2);
				if(b > a){
						child0.style.width = b+'px';
						child1.style.width = a+'px';
				}
		}
	}

}
