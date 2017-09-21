var merge = function(intervals) {
        var result = [];
        var start = [];
        var end = [];
        for(var i=0;i<intervals.length;i++){
          start.push(intervals[i][0]);
          end.push(intervals[i][1]);
        }
      console.log(start);
      console.log(end);
        var j = 0;
        for(i=0;i<intervals.length;i++){
          if(i == intervals.length-1 || start[i+1] > end[i]){
            result.push(start[j],end[i]);
            j = i + 1;
          }
        }
      return result;
    };
