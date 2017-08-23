package com.learning.scratchpad;

public class ScratchPad {
    static int area;
    static int top;
    static int bottom;
    static int left;
    static int right;

    public ScratchPad() {
        super();
    }

    public static void main(String[] args){
        int[][] image  = {
                          {0,0,1,0},
                          {0,1,1,0},
                          {0,1,0,0}
                       };
        boolean[][] visited = new boolean[image.length][image[0].length];
        top = 2;
        bottom = 2;
        left = 0;
        right = 0;
        findSolution(image,0,2,visited);
        System.out.println(area);
    }

    public static void findSolution(int[][] image,int x, int y,boolean[][] visited){
        if(x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == 0 || visited[x][y] == true)
            return;

        visited[x][y] = true;

        top = Math.min(top,y);
        bottom = Math.max(bottom, y);
        left = Math.min(left,x);
        right = Math.max(right, x);

        int currArea = (right-left + 1) * (bottom - top + 1);
        area = Math.max(area,currArea);

        findSolution(image,x,y-1,visited);
        findSolution(image,x,y+1,visited);
        findSolution(image,x-1,y,visited);
        findSolution(image,x+1,y,visited);

    }

}
