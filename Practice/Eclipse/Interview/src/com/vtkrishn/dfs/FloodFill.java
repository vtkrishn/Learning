package com.vtkrishn.dfs;

import java.util.LinkedList;
import java.util.Queue;

class FloodFill {
	
	public static void main(String[] args) {
		int[][] image = {
				{1,1,1},
				{1,1,0},
				{1,0,1}
		};
		//floodFil(image, 1, 1, 2);
		dfs(image, 1,1,1, 2);
		
		System.out.println();
	}
	
	public static void dfs(int[][] image, int sr, int sc, int color,int newColor) {
		if(image[sr][sc] == color) {
			image[sr][sc] = newColor;
			if(sr >= 1) dfs(image, sr-1, sc,color,newColor);
			if(sc >= 1) dfs(image, sr, sc-1,color,newColor);
			if(sr+1 < image.length) dfs(image, sr+1, sc,color,newColor);
			if(sc < image[0].length) dfs(image, sr, sc+1,color,newColor);
		}
	}
	
    public static int[][] floodFil(int[][] image, int sr, int sc, int newColor) {
        
    	Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[] {sr, sc});
        int[] move = {0,1,0,-1,0};
        int org = image[sr][sc];
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0;i<move.length-1;i++) {
        		int x = curr[0] + move[i];
        		int y = curr[1] + move[i+1];
        		if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != org)
        			continue;
        		image[x][y] = newColor;
        		q.offer(new int[] {x, y});
        	}
                
        }
        
        return image;
    }
    
    
}
