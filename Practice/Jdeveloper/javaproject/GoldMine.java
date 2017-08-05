package javaproject;

public class GoldMine {
    public GoldMine() {
        super();
    }
    
    public static void main(String[] args){
//        int[][] mat = 
//        {
//                {1, 3, 3},
//                {2, 1, 4},
//                {0, 6, 4}
//        };
        
        int[][] mat =         
            {   {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
            };
                 
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        int max=0;
        for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                        max = Math.max(max,findGold(mat, i, j, visited,0));
                }
        }
        System.out.println(max);
    }
    public static int max(int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }
    public static int findGold(int[][] mat, int row, int col, boolean[][] visited, int k){
        if(row < 0 || row >= mat.length || col >= mat[0].length)
            return k;
        visited[row][col] = true;
        int right = findGold(mat, row, col+1, visited, k+mat[row][col]);
        int right_up = findGold(mat, row-1, col+1, visited, k+mat[row][col]);
        int right_down = findGold(mat, row+1, col+1, visited, k+mat[row][col]);
        visited[row][col] = false;
        return max(right, right_up, right_down);
    }
}
