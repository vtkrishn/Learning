package vtkrishn.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SKyline {

	public static void main(String[] args) {
		SKyline sky = new SKyline();
		int[][] buildings = {
				{2,9,10},
				{3,7,15},
				{5, 12, 12},
				{15, 20, 10},
				{19, 24, 8}
		};

		sky.getSkyline(buildings);
	}

	public static void getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<int[]>();
		List<int[]> height = new ArrayList<int[]>();

		for(int[] b : buildings) {
			height.add(new int[] {b[0],-b[2]});
			height.add(new int[] {b[1],b[2]});
		}
//		2,-10
//		9,10
//		3,-15
//		7,15
//		5,-12
//		12,12
//		15,-10
//		20,10
//		19,-8
//		24,8
//		for(int[] h: height) {
//			System.out.println(h[0] + "," + h[1]);
//		}

		//sort based on sort value
		Collections.sort(height, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
			}

		});

//		2,-10
//		3,-15
//		5,-12
//		7,15
//		9,10
//		12,12
//		15,-10
//		19,-8
//		20,10
//		24,8
//		for(int[] h: height) {
//			System.out.println(h[0] + "," + h[1]);
//		}

		Comparator<Integer> comp = new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}

		};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(comp);
		pq.offer(0);
		int prev = 0;
		for(int[] h: height) {
			if(h[1] < 0)
				pq.offer(-h[1]);
			else
				pq.poll();

			int curr = pq.peek();

//			10
//			15
//			15
//			12
//			10
//			0
//			10
//			10
//			8
//			0
//			System.out.println(curr);

			if(prev != curr) {
				result.add(new int[] {h[0], curr});
				prev = curr;
			}
		}
//		2,10
//		3,15
//		7,12
//		9,10
//		12,0
//		15,10
//		20,8
//		24,0
//		for(int[] r : result)
//			System.out.println(r[0] + "," + r[1]);
	}
}
