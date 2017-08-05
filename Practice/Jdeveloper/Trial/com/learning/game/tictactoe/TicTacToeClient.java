package com.learning.game.tictactoe;

import java.util.Scanner;

public class TicTacToeClient {
    public TicTacToeClient() {
        super();
    }
    
    public static void main(String[] args){
        //initialize the board
        //ask for the size of the board in the constructor
        System.out.println("Please provide the size of the board you want to play ::");
        Scanner scanSizeOfTheBoard = new Scanner(System.in);
        Board board = new Board(Integer.parseInt(scanSizeOfTheBoard.next()));
        //X represents - Human always
        //O represents - computer
        
        //human to choose head or tail
        System.out.println("Toss for starting the game, choose your options [HEAD(H) or TAILS(T)]");
        Scanner scanUserInput = new Scanner(System.in);
        //toss to start the game - turn
        boolean isHumanStarting = board.toss(scanUserInput.next());
        System.out.println(isHumanStarting ? "you won the toss and will be starting the game" : "you lost the toss, wait for the computer to start the game");
        //set the current player based on the toss winning
        board.setCurrentPlayer(isHumanStarting ? Board.HUMAN : Board.COMPUTER);
        //game loop
        while(true){
            if(board.getCurrentPlayer().equals(Board.HUMAN)){
                //get coordinates from human
                System.out.println("Please provide the coordinates :: [x,y] [x in range of 0-"+(board.cells[0].length-1) +"] [y in range of 0-" + (board.cells.length-1) + "]");
                Scanner scanCoordinates = new Scanner(System.in);
                String[] coordinates = scanCoordinates.next().split(","); // input comma separated
                if(coordinates.length > 1){
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    //coordinates should be in the range
                    if(x < board.size && y < board.size)
                        //coordinate cell should be empty
                        if(board.cells[x][y].value.equals(Board.EMPTY))
                            board.placeMark(x,y);
                        else{
                            System.out.println("Cell already contains value, Try again");
                            continue;
                        }
                            
                    else{
                        System.out.println("Wrong coordinates, Try again");
                        continue;
                    }
                }
            }
            else{
                //TODO
                //place on the best coordnates - AI, x, y
                if(board.count >= 3)
                    board.doBestMove();
                else
                    board.placeRandomMark();
                System.out.println("Computer moved");
            }
            //check every end of the move
            if(board.isWinning())
                break;
            //this you have to set everytime - turn goes to next if current player is not winning the game
            board.setCurrentPlayer(board.getCurrentPlayer().equals(Board.HUMAN) ? Board.COMPUTER : Board.HUMAN);
        }
        
        //Display winner
        System.out.println("Winner :: " + board.getCurrentPlayer());
    }
}
