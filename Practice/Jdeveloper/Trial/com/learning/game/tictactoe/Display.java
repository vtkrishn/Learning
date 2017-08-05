package com.learning.game.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Display {
    List<String> humanMark = new ArrayList<String>();
    List<String> computerMark = new ArrayList<String>();
    List<String> board = new ArrayList<String>();
    
    public Display(){
        //display mark for human
        humanMark.add("\\  /");
        humanMark.add(" >< ");
        humanMark.add("/  \\");
        
        //display mark for Computer        
        computerMark.add(",==.");
        computerMark.add("|  |");
        computerMark.add("'=='");
        
        //board display setup
        board.add("............................");
        board.add("|        |        |        |");
        board.add("|        |        |        |");
        board.add("|        |        |        |");
        board.add("|........|........|........|");
        board.add("|        |        |        |");
        board.add("|        |        |        |");
        board.add("|        |        |        |");
        board.add("|........|........|........|");
        board.add("|        |        |        |");
        board.add("|        |        |        |");
        board.add("|        |        |        |");
        board.add("|........|........|........|");
    }
    
    private void printBoard(){
        //print the board
        for(int i=0;i<board.size();i++)
                System.out.println(board.get(i));
    }
    
    public void replaceCell(int x, int y,String player){
        List<String> playerList = player.equals(Board.HUMAN) ? humanMark : computerMark;
       
        int lengthOffsetStart = 0;
        int widthOffsetStart = 0;
       
        if(x == 0)
            lengthOffsetStart = 1;
        else if(x == 1)
            lengthOffsetStart = 5;
        else if(x == 2)
            lengthOffsetStart = 9;
        
        if(y == 0)
            widthOffsetStart = 3;
        else if(y == 1)
            widthOffsetStart = 12;
        else if(y == 2){
            widthOffsetStart = 21;
        }
        
        int k = 0;
        char[] ch = null;
        for(int i=0;i<playerList.size();i++){
            ch = board.get(lengthOffsetStart).toCharArray();
            int l = 0 ;
            String humanString = playerList.get(k);
            for(int j=widthOffsetStart;j<widthOffsetStart+4;j++){
                ch[j] = humanString.charAt(l);
                l++;
            }
            k++;
            board.set(lengthOffsetStart, String.copyValueOf(ch));
            lengthOffsetStart++;
        }
        
        //print the status board
        printBoard();
    }
    
}
