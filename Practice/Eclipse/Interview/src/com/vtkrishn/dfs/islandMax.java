package com.vtkrishn.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class islandMax {
	
	
	static class Node{
		int i;
		int j;
		
		public Node(int x, int y) {
			this.i = x;
			this.j = y;
		}
	}
	static int max = 0;
	public static void main(String[] args) {
		
		int[][] arr = {
				{0,0,1,0,1},
				{0,0,1,1,0},
				{0,1,0,0,0},
				{0,1,1,0,0}
		};
		
		int[][] bool = {
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
		};
		
		int temp = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j] == 1 && bool[i][j] == 0) {
					//temp = dfs(arr, bool, i, j);
					temp = bfs(arr, bool, i, j);
					max = Math.max(max, temp);	
				}
			}	
		}
		
		System.out.println(max);
	}
	
	public static int dfs(int[][] arr, int[][] bool, int i, int j) {
		if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || bool[i][j] == 1 || arr[i][j] == 0)
			return 0;
		
		bool[i][j] = 1;
		return 1 + dfs(arr, bool, i+1, j) + dfs(arr, bool, i, j+1) + dfs(arr, bool, i-1, j) + dfs(arr, bool, i, j-1) + dfs(arr, bool, i-1, j+1) + dfs(arr, bool, i-1, j-1) + dfs(arr, bool, i+1, j+1) + dfs(arr, bool, i+1, j-1);
	}
	
	public static boolean isValid(int[][] arr,int[][] bool, int i, int j) {
		if(i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || bool[i][j] == 1 || arr[i][j] == 0)
			return false;
		return true;
	}
	
	public static int bfs(int[][] arr, int[][] bool, int i, int j) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(i,j));
		bool[i][j] = 1;
		int count = 0;
		while(!q.isEmpty()) {
			count++;
			for(int x = 0;x < q.size();x++) {
				Node n = q.poll();
					if(n.i+1 < arr.length && arr[n.i+1][n.j] == 1 && isValid(arr, bool, n.i, n.j)) {
						bool[n.i+1][n.j] = 1;
						q.offer(new Node(n.i+1, n.j));
					}
					if(n.j+1 < arr[0].length && arr[n.i][n.j+1] == 1 && isValid(arr, bool, n.i, n.j)) {
						bool[n.i][n.j+1] = 1;
						q.offer(new Node(n.i, n.j+1));
					}
					if(n.i-1 > 0 && arr[n.i-1][n.j] == 1  && isValid(arr, bool, n.i, n.j)) {
						bool[n.i-1][n.j] = 1;
						q.offer(new Node(n.i-1, n.j));
					}
					if(n.j-1 > 0 && arr[n.i][n.j-1] == 1  && isValid(arr, bool, n.i, n.j)) {
						bool[n.i][n.j-1] = 1;
						q.offer(new Node(n.i, n.j-1));
					}
			}
		}
		return count;
	}
	
}
