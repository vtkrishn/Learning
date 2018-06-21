package vtkrishn.testing;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOfTree {

		public static void main(String[] args) {
			int[][] trees = {
			                 {1,2,3},
			                 {0,0,4},
			                 {7,6,5}
			};
			
			Comparator<int[]> comp = new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			};
			
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>(comp);
			
			for(int[] t: trees)
				pq.offer(t);
			
			int step = 0;
			int[] start = new int[2];
			while(!pq.isEmpty()) {
				int[] cell = pq.poll();
				step = bfs(trees, start,cell, trees.length, trees[0].length);
				
				if(step < 0)
					return;
				
				start[0] = cell[0];
				start[1] = cell[1];
				
			}
			
			System.out.println(step);
		}
		
		public static int bfs(int[][] forest, int[] start,int[] tree, int m, int n) {
			int[][] dirs = {
					{0,1},
					{0,-1},
					{1,0},
					{-1,0}
			};
			int step = 0;
			boolean[][] visited = new boolean[m][n];
			Queue<int[]> q = new LinkedList<int[]>();
			q.offer(start);
			visited[start[0]][start[1]] = true;
			
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0;i<size;i++) {
					int[] s = q.poll();
					if(s[0] == start[0] && s[1] == start[1]) return step;	
					
					for(int[] gg : dirs) {
						int nr = s[0] + gg[0];
						int nc = s[1] + gg[1];
						
						if(nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
							continue;
						
						q.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
						
					}
				}
				
				step++;
				
			}
			
			return -1;
		}
}
