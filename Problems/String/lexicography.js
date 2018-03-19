console.clear();
function func(a){
  //find the largest i where a[i] < a[i+1]
  var largesti=-1;
  for(var i=0;i<a.length-1;i++){
     if(a[i] < a[i+1])
       largesti=i;
  }

  //find the largest i where a[j] < a[largesti]
  var largestj=-1;
  for(var j=0;j<a.length-1;j++){
    if(a[j] < a[largesti])
      largestj=j;
  }

  //console.log(largesti);
  //console.log(largestj);

  //swap largest i and largest j
  var temp = a[largesti];
  a[largesti] = a[largestj];
  a[largestj] = temp;

  //reverse from largesti+1 to end
  var start = largesti+1;
  var end = a.length-1;

  while(start < end){
    var t = a[start];
    a[start] = a[end];
    a[end] = t;
    start++;
    end--;
  }

  console.log(a);

};

(function lex(a){
   func(a);
})([1,2,3]);
