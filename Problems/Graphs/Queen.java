package javaproject.graph;

public class QueenBack {
    public QueenBack() {
        super();
    }

    public static void main(String[] args){
        int[][] board = new int[4][4];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                placeQueen(board,i,j);
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean placeQueen(int[][] board,int row,int col){
        if(col == board[0].length)
            return true;

        for(int j=0;j<board[0].length;j++){
            if(isSafe(board,j,col)){
                board[j][col] = 1;
                if(placeQueen(board, row, col+1))
                    return true;
                board[j][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board,int row,int col){
            for(int j=0;j<board[0].length;j++){
                if(board[row][j] == 1)
                    return false;
            }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1)
                return false;
        }
        for(int i=row,j=col;j>=0 && i<board.length;i++,j--){
            if(board[i][col]==1)
                return false;
        }

        return true;
    }
}
