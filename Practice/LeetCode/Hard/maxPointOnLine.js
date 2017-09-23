(function(exports){
   console.clear();

  function Point(x,y){
    this.x = x;
    this.y = y;
  }

  var p1 = new Point(1,2);
  var p2 = new Point(2,4);
  var p3 = new Point(3,9);
  var p4 = new Point(4,12);
  var p5 = new Point(5,15);
   var p6 = new Point(7,4);
   var p7 = new Point(8,3);
   var p8 = new Point(6,5);
   var p9 = new Point(4,5);
   var p10 = new Point(13,7);

  var p = [p1,p2,p3,p4,p5,p6,p7,p8,p9,p10];

  var maxPoints = function(points) {
    var map = new Map();

    if(points === null | points.length === 0)
      return 0;

    for(var i = 0;i<points.length;i++){
      var s = slope(points[i].x,points[i].y);
      var sl = map.get(s);
      if(sl === undefined)
        map.set(s,1);
      else
        map.set(s,sl + 1);
    }

    var m = Number.MIN_VALUE;
    var mapIter = map.values();
    map.forEach(function(keys){
      m = Math.max(m,mapIter.next().value);
    });

    return m;
  }

  slope = function(x,y){
    return Math.floor(y/x);
  }

  var max = maxPoints(p);
  console.log(max);

}
)(window);
--------------------------------
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}
