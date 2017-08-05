package javaproject;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {
    public Solution2() {
        super();
    }
    
    public static void main(String[] args) {
          int[][] arr = 
         { 
          {1 , 0 , 0 , 0 , 1},
          {0 , 0 , 0 , 0 , 0},
          {0 , 0 , 1 , 0 , 0}
        };
        minTotalDistance(arr);
        }
        
        
        public static int minTotalDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
     
        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
               if(grid[i][j]==1){
                   cols.add(j);
                   rows.add(i);
               }
            }
        }
     
        int sum=0;
     
        for(Integer i: rows){
          int l = rows.size()/2;
          int x = Math.abs(i - rows.get(l));
            sum += x;    
        }
     
        Collections.sort(cols);
     
        for(Integer i: cols){
          int l = cols.size()/2;
          int y = Math.abs(i-cols.get(l));
            sum+= y;
        }
     
        return sum;
    }
}
