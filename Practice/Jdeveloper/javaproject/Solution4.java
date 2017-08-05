package javaproject;

import java.util.*;
public class Solution4 {
    static List<List<Integer>> l = new ArrayList<List<Integer>>();
    
    public static void main(String[] args) {
      int[][] matrix = {
                {1,1,2},
                {2,4,5},
                {6,9,1}
      };
      
      for(int i=0;i<matrix.length;i++){
          List<Integer> ll = new ArrayList<Integer>();
          for(int j=0;i<matrix[0].length;i++){
              System.out.println(findMaxPathLength(matrix,i,j,ll));
              l.add(ll);
          }   
      }
        System.out.println(l);
    }
    
    public static int findMaxPathLength(int[][] matrix,int i,int j,List<Integer> ll){
        if(i>=matrix.length || j >= matrix[0].length){
          ll = new ArrayList<Integer>();
          return 0;
        }
        int current = matrix[i][j];
        int right = findMaxPathLength(matrix,i,j+1,ll);
        int down = findMaxPathLength(matrix,i+1,j,ll);
        
        ll.add(current);
        if(right > down)
          current = current + right;
        else
          current = current + down;
        
        return  current;  
    }
}