//Brute force
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {

        if(points.length <= 1)
            return points.length;

        //sort on keep x as constant, and y as variable
        int max = 1;
        int currentMax = 1;

        int xMax=Integer.MIN_VALUE;
        int yMax = Integer.MIN_VALUE;

        int xMin=Integer.MAX_VALUE;
        int yMin = Integer.MAX_VALUE;

        Map<Integer,Integer> xPoint = new HashMap<Integer,Integer>();
        Map<Integer,Integer> yPoint = new HashMap<Integer,Integer>();

        //get max and min of x and y
        for(int i=0;i<points.length;i++){
            int x = points[i].x;
            int y = points[i].y;
            xMax = Math.max(xMax,x);
            xMin = Math.min(xMin,x);
            if(xPoint.containsKey(x))
            	xPoint.put(x,xPoint.get(x)+1);
            else
                xPoint.put(x,1);

            yMax = Math.max(yMax,y);
            yMin = Math.min(yMin,y);
            if(yPoint.containsKey(y))
            	yPoint.put(y,yPoint.get(y)+1);
            else
                yPoint.put(y,1);
        }

        //get max of x
        for(int i=xMin;i<=xMax;i++){
            for(int j=yMin;j<=yMax;j++){
				if(xPoint.containsKey(i) && yPoint.containsKey(j))
                    currentMax++;
            }
            max = Math.max(max,currentMax);
            currentMax = 1;
        }
        currentMax = 1;
        //get max of y
        for(int i=yMin;i<=yMax;i++){
            for(int j=xMin;j<=xMax;j++){
				if(xPoint.containsKey(j) && yPoint.containsKey(i))
                    currentMax++;
            }
            max = Math.max(max,currentMax);
            currentMax = 1;
        }
        currentMax = 1;

        int xLength = Math.abs(xMax-xMin);
        int yLength = Math.abs(yMax-yMin);

        int minn = Math.min(xLength,yLength);
        int maxx = Math.max(xLength,yLength);

        //get max of x == y
        for(int i=xMin;i<minn;i++){
            for(int j=yMin;j<minn;j++){
				if(xPoint.containsKey(i) && yPoint.containsKey(j) && i == j)
                    currentMax++;
            }
            max = Math.max(max,currentMax);
            currentMax = 1;
        }
        currentMax = 1;

        //get max of x+y == max
        for(int i=maxx;i>xMin;i--){
            for(int j=maxx;j>yMin;j--){
				if(xPoint.containsKey(i) && yPoint.containsKey(j) && i+j == max)
                    currentMax++;
            }
            max = Math.max(max,currentMax);
            currentMax = 1;
        }

        return max;
    }
}
