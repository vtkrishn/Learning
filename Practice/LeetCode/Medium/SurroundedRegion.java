class Solution {
    public void solve(char[][] board) {
            //base case
            if (board.length == 0 || board[0].length == 0)
		        return;
            if (board.length < 2 || board[0].length < 2)
                return;

            int row = board.length;
            int col = board[0].length;
            //check the first row
            for(int j=0;j<col;j++){
                if(board[0][j] == 'O')
                    bfs(board, 0, j);
                if(board[row-1][j] == 'O')
                    bfs(board, row-1, j);
            }

            //check the first column
            for(int i=0;i<row;i++){
                if(board[i][0] == 'O')
                    bfs(board, i, 0);
                if(board[i][col-1] == 'O')
                    bfs(board, i, col-1);
            }


        //find U and change it to O
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] == 'O')
                  board[i][j] = 'X';
                if(board[i][j] == '1')
                  board[i][j] = 'O';
            }
        }

    }

    public void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'X' || board[i][j] == 'U')
            return;

            board[i][j] = 'X';
            dfs(board, i, j+1);
            dfs(board, i, j-1);
            dfs(board, i+1, j);
            dfs(board, i-1, j);
    }

    public void bfs(char[][] board, int i, int j){
        int row = board.length;
        int col = board[0].length;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(i*col + j);
        board[i][j]='1';

        while(!queue.isEmpty()){
            int k = queue.poll();
            int m = k / col;
            int n = k % col;
            if(m-1 >=0 && board[m-1][n] == 'O'){
                board[m-1][n] = '1';
                queue.offer((m-1)*col + n);
            }
            if(n-1 >=0 && board[m][n-1] == 'O'){
                board[m][n-1] = '1';
                queue.offer(m*col + (n-1));
            }
            if(m+1 < row && board[m+1][n] == 'O'){
                board[m+1][n] = '1';
                queue.offer((m+1)*col + n);
            }
            if(n+1 < col && board[m][n+1] == 'O'){
                board[m][n+1] = '1';
                queue.offer(m*col + (n+1));
            }

        }

    }

}
