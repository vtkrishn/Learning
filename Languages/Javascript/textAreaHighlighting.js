var string = document.getElementById("textArea").value;

var map = {};
var i=0;
var strSplit = string.split(' ');

function button_click(event){
	console.clear();

  indexString();

	var keyWord = document.getElementById("search").value;
	var errorText = document.getElementById("errorText");

	if(errorText === null){
		errorText = document.createElement("span");
		errorText.id="errorText";
		document.body.appendChild(errorText);
	}

	var mapValue = map[keyWord];
	if(mapValue === undefined)
		  errorText.innerHTML="no";
	  else{
		errorText.innerHTML="found in " + mapValue;

			if(mapValue.length === 1){
				var textArea = document.getElementById("textArea");
				var str = textArea.value;
				var firstPart = "<span>" + str.substr(0,str.indexOf(keyWord)) + "</span>";
				var spanPart = "<span style='background-color : grey;'>" +  keyWord + "</span>";
				var lastPart = "<span>" +  str.substr(str.indexOf(keyWord) + keyWord.length, str.length) + "</span>";
				textArea.innerHTML = firstPart + spanPart + lastPart;
			}

		}

}

// var map = {};
// for(var i = 0;i<string.length;i++){
// 	var key = string[i];
// 	 if(map[key] === undefined){
// 	 	var val = [];
// 	 	val.push(i);
// 	 }
// 	 else{
// 	 	var val = map[key];
// 		val.push(i);
// 	 }
// 	map[key] = val;
// }
// console.log(map);

var indexString = function(){
	while(i<strSplit.length){
	  var key = strSplit[i];
		  if(map[key] === undefined){
	 	   var val = [];
	 	   val.push(i);
	    }
	    else{
	 	   var val = map[key];
		   val.push(i);
	    }
		  map[key] = val;
	    i++;
	 }
}
