class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int max = 0;
        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                int len = dfs(matrix, i, j, dp, Integer.MAX_VALUE);
                max = Math.max(max,len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] dp,int pre){
        if(i<0 || i>= matrix.length || j<0 || j>= matrix[0].length || matrix[i][j] >= pre)
            return 0;
        if(dp[i][j] > 0)
            return dp[i][j];
        int sum = 0;
        sum = Math.max(sum, dfs(matrix, i-1, j, dp, matrix[i][j]));
        sum = Math.max(sum, dfs(matrix, i+1, j, dp, matrix[i][j]));
        sum = Math.max(sum, dfs(matrix, i, j+1, dp, matrix[i][j]));
        sum = Math.max(sum, dfs(matrix, i, j-1, dp, matrix[i][j]));
        dp[i][j] = ++sum;
        return sum;
    }
}
