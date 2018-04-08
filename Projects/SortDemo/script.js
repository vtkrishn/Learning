var arr = document.getElementById('array');
var count = 0;
var max = 200;
var boxHeight = 1;

for(var i = 0;i<max;i++){
	var c = document.createElement('div');
	c.id = 'child' + (count++);
	c.style.cssText = 'width : ' + parseInt(Math.random()* (100 - 10) + 10) + 'px; height:'+ boxHeight +'px; border: 1px solid #1c6003;transition: .9s;';
	arr.appendChild(c);
}

function getChildWidth(child){
	var childWidth = child.style.width.length;
	return child.style.width.substring(0,childWidth-2);
}

var bubbleSort = function (){
	for(var i=max-1;i>=0;i--){
		for(var j=0;j<=i;j++){
			var child0 = document.getElementById('child'+i);
			var child1 = document.getElementById('child'+j);

			var a = getChildWidth(child0);
			var b = getChildWidth(child1);
				if(b > a){
						child0.style.width = b+'px';
						child1.style.width = a+'px';
				}
		}
	}

}

var selectionSort = function (){
	for(var i=0;i<max;i++){
		var child0 = document.getElementById('child'+i);
		var a = getChildWidth(child0);
		var min = i;
		for(var j=i;j<max;j++){
			var child1 = document.getElementById('child'+j);
			var b = getChildWidth(child1);

			var childMin = document.getElementById('child'+min);
			var c = getChildWidth(childMin);

			if(b < c){
					min = j;
				}
		}
		child0.style.width = c+'px';
		childMin.style.width = a+'px';
	}

}

var insertionSort = function (){
	for(var i = 1; i < max; i++) {
	var a = getChildWidth(document.getElementById('child'+i));
	var key = a;
	var j = i - 1;
	var b = getChildWidth(document.getElementById('child'+j));
	while(j>=0 && b > key){
		b = getChildWidth(document.getElementById('child'+j));
		document.getElementById('child'+(j+1)).style.width = b+'px';
		j--;
	}
	document.getElementById('child'+(j+1)).style.width = key+'px';

   }
}
var mergeSortHelper = function(){
	var total=[];
	for(var i=0;i<5;i++){
		total.push(getChildWidth(document.getElementById('child'+i)));
	}
  mergeSort(total,0, total.length);
}
var mergeSort = function(total,l,r){
	var m = parseInt(l + ((r-l)/2));
	if(l < r){
		mergeSort(total, l, m);
		mergeSort(total, m+1, r);
		merge(total, l,m,r)
	}
}
var merge = function(nums, l, m, r){

		var i,j;
		var n1 = m-l+1;
		var n2 = r - m;
		var left = [];
		for(i=0;i<n1;i++)
			left[i] = nums[l+i];

		var right = [];
		for(j=0;j<n2;j++)
			right[j] = nums[m+1+j];

		while(i<n1 && j<n2){
			if(left[i] <= right[j]){
				document.getElementById('child'+i).style.width= left[i]+'px';
				i++;
			}
			else{
				document.getElementById('child'+j).style.width= right[j]+'px';
				j++;
			}
		}
		while(i<n1){
			document.getElementById('child'+i).style.width= left[i]+'px';
			i++;
		}
		while(j<n2){
			document.getElementById('child'+j).style.width= right[j]+'px';
			j++;
		}
}
