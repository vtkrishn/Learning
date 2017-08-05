package javaproject;

import java.util.Stack;

public class MatrixTraversal {
    public MatrixTraversal() {
        super();
    }
    
    static Stack s = new Stack();
    public static void main(String[] args){
        int[][] arr = 
            {
            {1,0,0,0,0,1},
            {0,1,0,0,1,0},
            {0,0,1,0,1,0},
            {0,1,0,0,0,1},
            {0,0,1,0,1,0},
            {0,0,1,1,0,0}
            };
        
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        //for(int i=0;i<arr.length;i++){
          //  for(int j=0;j<arr[0].length;j++){
                dfs(arr, visited, 0, 0);
           // }
       // }
                while(!s.isEmpty()){
                    System.out.println(s.peek());
                    s.pop();
                }
    }
    
    private static void dfs(int[][] arr, boolean[][] visited,int x,int y){
        visited[x][y] = true;
        if(arr[x][y] == 1)
            System.out.println("Path ->" + " @ " + x + ", "+ y);
        for(int i=x-1;i<=x+1 && i<arr.length;i++){
            for(int j=y-1;j<=y+1 && j<arr[0].length;j++){
                if(i >=0 && j >=0 && !visited[i][j] && arr[i][j] == 1)
                    dfs(arr, visited, i, j);
            }   
        }
        
        s.push(x + "," + y);
    }
}
