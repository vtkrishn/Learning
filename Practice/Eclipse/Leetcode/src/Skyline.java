import java.applet.Applet;
import java.applet.AppletContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Skyline {

	public static void main(String[] args) {
		Applet 
		
		Skyline sky = new Skyline();
		int[][] buildings = {
				{2,9,10},
				{3,7,15},
				{5, 12, 12},
				{15, 20, 10},
				{19, 24, 8}
		};

		sky.getSkyline(buildings);
	}

	static class Point implements Comparable<Point>{
		int x;
		int height;
        boolean start;

		public Point(int x, int height, boolean start) {
			this.x = x;
			this.height = height;
            this.start = start;
		}

        public int compareTo(Point p){
            if(this.x != p.x)
                return this.x-p.x;
            else
                return (this.start ? -this.height : this.height) - (p.start ? - p.height : p.height);
        }
	}

    public List<int[]> getSkyline(int[][] buildings) {
        List<Point> points = new ArrayList<>();
		for(int[] b: buildings) {
			points.add(new Point(b[0],-b[2],true));// when you sort x will be first always
			points.add(new Point(b[1],b[2],false)); // when you sort y will be second always
		}

		//sort based on x
		Collections.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x == o2.x)
					return 0;
				else if(o1.x > o2.x)
                    return 1;
                else
					return -1;
			}
		});

		//sort based on height
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(points.size(),new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		pq.offer(0);
		List<int[]> result  = new ArrayList<>();

		int pre = 0;
		for(Point p: points) {
			if(p.height < 0) // if height is negative then add the start point
				pq.offer(-p.height);
			else
				pq.remove(p.height); // if height is positive then remove from the pq, end point

			int curr = pq.peek(); // peek gives the max
			if(pre != curr) {
				result.add(new int[] {p.x, p.height});
				pre = curr;
			}

		}

		return result;

}
}
