public class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            int left=0;
            int right=0;
            int up=0;
            int down=0;
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    if(j-1 >= 0 && grid[i][j-1] == 1)
                        left = 1;
                    else
                        left = 0;
                    if(j+1 < grid[0].length && grid[i][j+1] == 1)
                        right = 1;
                    else
                        right = 0;
                    if(i-1 >= 0 && grid[i-1][j] == 1)
                        up = 1;
                    else
                        up = 0;
                    if(i+1 < grid.length && grid[i+1][j] == 1)
                        down = 1;
                    else
                        down = 0;
                    sum = sum + 4 - (left + right + up + down);
                }
            }
        }
        return sum;
    }
}
