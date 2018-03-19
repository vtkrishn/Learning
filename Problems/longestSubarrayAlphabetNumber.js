console.clear();
function func(a,b){
  console.log("Showing values :: [" + a + "]");
  var result = operation(a);
  console.log("result :: " + result);
};

function operation(a) {
  var delta = 0;
  var d = [];
  //get the delta
  for(var i=0;i<a.length;i++){
    if(a[i] === 0)
      delta++;
    else
      delta--;

    d[i] = delta;
  }

  console.log(d);
  //range definition
  var max = [0,0];
  var m = new Map();
  //loop detla values
  for(i=0;i<d.length;i++){
      //if map not contains the delta, then set the index
      if(!m.has(d[i]))
        m.set(d[i], i);
      else{
        //get the previous index
        var match = m.get(d[i]);
        //subtract previous index with the current index to get the length
        var distance = i - match;
        //find the max
        var largest = max[1] - max[0];
        //update the max
        if(distance > largest){
          max[1] = i;
          max[0] = match;
        }
      }
  }
  //print the max range
  console.log(max[1]-max[0]);

};

--------------
function operation(a) {
  var max = 0;
  var m = new Map();
  m.set(0,-1);
  var delta = 0;
  for(i=0;i<a.length;i++){
      delta = delta + (a[i] === 0 ? 1 : -1);
    if(m.has(delta))
        max = Math.max(max, i - m.get(delta));
      else
        m.set(delta, i);
  }
  console.log(max);
};
