package com.learning.game.tictactoe;

public class Board {
    private String currentPlayer;
    public static final String HUMAN = "X";
    public static final String COMPUTER = "O";
    public static final String EMPTY = "";
    public static final String HEAD = "H";
    public static final String TAILS = "T";
    Cell[][] cells;
    
    String[][] board = {
        {"............................"},
        {"|        |        |        |"},
        {"|        |        |        |"},
        {"|        |        |        |"},
        {"|........|........|........|"},
        {"|        |        |        |"},
        {"|        |        |        |"},
        {"|        |        |        |"},
        {"|........|........|........|"},
        {"|        |        |        |"},
        {"|        |        |        |"},
        {"|        |        |        |"},
        {"|........|........|........|"},
    };
    
    String[][] humanMark = {
            {"*  *"},
            {" ** "},
            {"*  *"}
    };
    
    String[][] computerMark = {
            {"****"},
            {"*  *"},
            {"****"},
    };
        
    
    class Cell{
        int x;
        int y;
        String value;
        
        public Cell(int x, int y, String value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    
    public Board(int size) {
        cells = new Cell[size][size];
        //init the board
        initialize(size);
    }
    
    private void initialize(int size){
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                cells[i][j] = new Cell(i,j,EMPTY);
    }
    
    public boolean toss(String humanOption){
        double random = Math.random()*1;
        if(random > .5 && humanOption.equalsIgnoreCase(HEAD))
            return true;
        return false;
    }
    
    public void doBestMove(){
        //TODO    
        System.out.println("Computer moved");
    }
    
    public boolean isWinning(){
        //get the currentPlayer
        // any column with row same
        // any row with same column
        // row and column increasing
        // row and column decreasing
        return false;
    }
    
    public void placeMark(int x, int y){
    //TODO 
        int offSetX = 0;
        int offSetY = 0;
        if(x == 0)
            offSetX = 2;
        if(y == 0)
            offSetY = 4;
        
        for(int i=0;i<board.length;i++){
            for(int i=0;i<board.length;i++){
                
            }
        }
        
        cells[x][y].value = HUMAN;
    }

    public void printCurrentBoardStatus(){
        //print the board
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
                System.out.print(board[i][j]);
            System.out.println("");
        }
            
        
    }
    
    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
