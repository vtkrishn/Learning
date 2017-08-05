package javaproject.dynamic;

public class PathFinding {
    public PathFinding() {
        super();
    }
    
    public static void main(String[] args){
        int[][] arr = {
                    {1,0,0},
                    {1,0,0},
                    {1,1,1}
                    };
        int row = arr.length-1;
        int col = arr[0].length-1;
        boolean flag = pathExist(arr, row, col,0,0);
        System.out.println(flag);
    }
    
    public static boolean pathExist(int[][] arr, int row, int col, int i , int j){
        if(i > row || j > col || arr[i][j] == 0)
            return false;
        if(i == row && j == col)
            return true;
        //cache the i,j and optimize it
        return pathExist(arr, row, col, i+1, j) || pathExist(arr, row, col, i, j+1);
    }
    
}
