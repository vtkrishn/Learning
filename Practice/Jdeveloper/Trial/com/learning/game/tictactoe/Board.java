package com.learning.game.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    private String currentPlayer;
    public static final String HUMAN = "X";
    public static final String COMPUTER = "O";
    public static final String EMPTY = "";
    public static final String HEAD = "H";
    public static final String TAILS = "T";
    Cell[][] cells;
    Display display;

    public Display getDisplay() {
        return display;
    }

    class Cell{
        int x;
        int y;
        String value;
        
        Cell(int x, int y, String value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    
    class Score{
        int x;
        int y;
        int score;
        
        Score(int x,int y, int value){
            this.x = x;
            this.y = y;
            this.score = value;
        }
    }
    
    public Board(int size) {
        this.size = size;
        display = new Display();
        cells = new Cell[size][size];
        //init the board
        initializeCells(size);
    }
    private void initializeCells(int size){
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
    
    private boolean isFull(){
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                if(cells[i][j].value.equals(EMPTY))
                    return false;
            }
        }
        return true;
    }
    
    private int tryCell(int x, int y,String player,boolean[][] visited){
        if(x >= cells.length || y >= cells.length)
            return 0;
        if(cells[x][y].value.equals(EMPTY) && !visited[x][y]){
            visited[x][y] = true;
            cells[x][y].value=player;
            if(isWinning() && currentPlayer.equals(COMPUTER)){
               return 10;
            }
            else if(isWinning() && currentPlayer.equals(HUMAN)){
               return -10;
            }
            else if(!isWinning() && currentPlayer.equals(HUMAN)){
               return 5;
            }
            cells[x][y].value=EMPTY;
        }
        return Math.max(tryCell(x+1, y+1, HUMAN,visited),Math.max(tryCell(x+1, y, HUMAN,visited),tryCell(x, y+1, HUMAN,visited))); 
    }
    //TODO no choosing the best move
    public void doBestMove(){
//        check is full
        if(!isFull()){
            boolean[][] visited = new boolean[size][size];
            Score s = new Score(Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);
            int score = Integer.MIN_VALUE;
            for(int i=0;i<cells.length;i++){
                for(int j=0;j<cells[0].length;j++){
                    // tryEachCell with no value
                    if(cells[i][j].value.equals(EMPTY)){
                        score = tryCell(i, j, COMPUTER,visited);
                        if(score == 10){
                            s.x = i;
                            s.y = j;
                            //s.score = score;
                            continue;
                        }
                        else if(score == -10){
                            break;
                        }
                        s.x = Math.max(s.x,i);
                        s.y = Math.max(s.y,j);
                        //s.score = Math.max(s.score,score);
                    }
                }
            }
            
            if(cells[s.x][s.y].value.equals(EMPTY)){
                //set the cell value
                cells[s.x][s.y].value = COMPUTER;
                //display the change
                display.replaceCell(s.x,s.y,COMPUTER);
            }
            else{
                for(int i=0;i<cells.length;i++){
                    for(int j=0;j<cells[0].length;j++){
                        if(cells[i][j].value.equals(EMPTY)){
                            cells[i][j].value = COMPUTER;
                            //display the change
                            display.replaceCell(i,j,COMPUTER);
                            return;
                        }
                    }
                }
            }
        }
    }
    
    //TODO winning logic not correct
    public boolean isWinning(){
        
        boolean columnInRow = false;
        boolean rowInColumn = false;
        boolean increasingFromTopToBotton = false;
        boolean decreasingFromLastToStart = false;
        // any column with same value
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                if(!cells[i][j].value.equals(EMPTY)){
                    if(cells[i][j].value.equals(currentPlayer)){
                        columnInRow = columnInRow && true;
                    }
                    else{
                        columnInRow = false;   
                        break;
                    }
                        
                }
                else
                    columnInRow = false;   
            }   
            if(columnInRow)
                return columnInRow;
        }
        
        // any row with same value
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                if(!cells[j][i].value.equals(EMPTY)){
                    if(cells[j][i].value.equals(currentPlayer)){
                        rowInColumn = rowInColumn && true;
                    }
                    else{
                        rowInColumn = false;
                        break;
                    }
                }
                else
                    rowInColumn = false;
            }   
            if(rowInColumn)
                return rowInColumn;
        }
        // row and column increasing
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                if(!cells[i][j].value.equals(EMPTY)){
                    if(i == j){
                        if(cells[i][j].value.equals(currentPlayer)){
                            increasingFromTopToBotton = increasingFromTopToBotton && true;
                        }
                        else{
                            increasingFromTopToBotton = false;
                            break;
                        }
                    }
                }
                else
                    increasingFromTopToBotton = false;
            }
        }
        if(increasingFromTopToBotton)
            return increasingFromTopToBotton;
        
        // row and column decreasing
        for(int i=0;i<cells.length;i++){
            for(int j=cells.length-1;j>=0;j--){
                if(!cells[i][j].value.equals(EMPTY)){
                    if(i == j){
                        if(cells[i][j].value.equals(currentPlayer)){
                            decreasingFromLastToStart = decreasingFromLastToStart && true;
                        }
                        else{
                            decreasingFromLastToStart = false;
                            break;
                        }
                    }
                }
                else
                    decreasingFromLastToStart = false;
            }  
        }
        if(decreasingFromLastToStart)
            return decreasingFromLastToStart;
        
        return columnInRow || rowInColumn || increasingFromTopToBotton || decreasingFromLastToStart;
    }
    
    public void placeMark(int x, int y){
            //set the cell value
            cells[x][y].value = HUMAN;
            //display the change
            display.replaceCell(x,y,HUMAN);
    }
    
    public static void main(String[] args){
        Board b = new Board(3);
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                b.placeMark(i,j);
    }
    
    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
