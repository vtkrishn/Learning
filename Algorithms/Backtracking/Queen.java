package javaproject;

public class Queen {
    public Queen() {
        super();
    }

    public static void main(String[] args){
        int[][] board = new int[8][8];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                placeQueen(i,j,board);
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static boolean isSafe(int row,int col,int[][] board){
        int i,j;
        for(i=0;i<board.length;i++){
            if(board[row][i] == 1)
                return false;
        }

        for(i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1)
                return false;
        }

        for (i=row, j=col; j>=0 && i<board.length; i++, j--){
                if (board[i][j] == 1)
                    return false;
        }

        return true;
    }
    private static boolean placeQueen(int row, int col, int[][] board){
        if(col >= board[0].length){
            return true;
        }
        for(int i=0;i<board[0].length;i++){
            if(isSafe(i, col, board)){
                board[i][col] = 1;
                if(placeQueen(row,col+1,board))
                    return true;
                board[i][col] = 0;
            }
         }
        return false;
    }
}
