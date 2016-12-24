package oracle.apps;

import java.util.Scanner;

public class TicTacToe{

public static void main(String[] args){
	System.out.println(" ****  WELCOME TO THE TIC TAC TOE GAME **** ");

	Scanner s = new Scanner(System.in);
	//Get the player name
	System.out.println("Please enter your name :: Vinod");
	//setup the board
	Board board = new Board();
	//track the game points

        Controller.startNewGame(board);

}

}

class Controller{

        static boolean gameAlreadyPlayed;
        static GamePoints points;
        static boolean computerWonLast;
        static int turnCount;

        public static void startNewGame(Board board){

                //start a new game
                if(!Controller.gameAlreadyPlayed)
                                Controller.points = new GamePoints();

                //clear the board
                board.clearBoard();

                //playerName = s.next();
                Player player = new Player("Vinod",board);
                //start the AI player
                Player computer = new Player("COMPUTER",board);

                //kick off players
                kickOffPlayers(player, computer);

                while(turnCount < 9){
                    if(!computer.myTurn)
                        computer.myTurn = true;

                    if(!player.myTurn)
                        player.myTurn = true;

                    turnCount++;
                }

        }

    private static void kickOffPlayers(Player player, Player computer) {

            //if the game is started for the first time then human starts first
            if(computerWonLast)
                computer.myTurn=  true;
            else
                player.myTurn = true;

            //prints
            System.out.println(((computerWonLast) ? computer.name + " Will Start the game" : player.name + " should start the game"));

            Thread playerThread = new Thread(player);
            Thread computerThread = new Thread(computer);
            playerThread.start();
            computerThread.start();

    }

}

//track game points
class GamePoints{
	int computer;
	int human;
}

//represent the tic tac toe board
class Board{
	Cell[][] cellArray;

	public Board(){
		cellArray = new Cell[3][3];
	}

	public void clearBoard(){
		int row = cellArray.length;
		int column = cellArray[0].length;
		for(int i = 0;i<row;i++){
			for(int j = 0;j<column;j++){
				cellArray[i][j] = new Cell(i,j," ");
			}
		}
	}

}

//represents each of the cell in the board
class Cell{

	int row;
	int column;
        String value;

        public Cell(int row, int column, String value){
            this.row = row;
            this.column = column;
            this.value = value;
        }

}


//X in the game
class Player implements Runnable{

	int point;
	String name;
        boolean myTurn;
        Board board;

	public Player(String name,Board board){
		this.name = name;
                this.board = board;
	}

	public void run(){
		while(myTurn){
			System.out.println(name + " turn");
                        //place the cell
                        placeMark();
                        //increase the current player point
                        increasePoint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
	}

    public synchronized void placeMark(){
            //place the mark
            identifyPlayerAndPlaceMark();
            //print the current status of the board
            printBoardStatus();
    }

    private synchronized void identifyPlayerAndPlaceMark() {

        int row = getNextRow();
        int column = getNextColumn();

        if(row != -1 && column != -1){
            if(board.cellArray[row][column].value.equals(" ")){
                if(name.equalsIgnoreCase("COMPUTER"))
                    board.cellArray[row][column].value = "O";
                else
                    board.cellArray[row][column].value = "X";
            }
        }
    }

    private synchronized int getNextRow(){
        int row = board.cellArray.length;
        int column = board.cellArray[0].length;
        int value=-1;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                if(board.cellArray[i][j].equals(" ")){
                    value=i;
                }
            }
        }

        return value;
    }

    private synchronized int getNextColumn(){
        int row = board.cellArray.length;
        int column = board.cellArray[0].length;
        int value=-1;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<column;j++){
                if(board.cellArray[i][j].equals(" ")){
                    value=j;
                }
            }
        }
        return value;
    }

    private synchronized void printBoardStatus() {
        System.out.println("-------------");
        System.out.println("| "+board.cellArray[0][0].value+" | "+board.cellArray[0][1].value+" | "+board.cellArray[0][2].value+" |");
        System.out.println("-------------");
        System.out.println("| "+board.cellArray[1][0].value+" | "+board.cellArray[1][1].value+" | "+board.cellArray[1][2].value+" |");
        System.out.println("-------------");
        System.out.println("| "+board.cellArray[2][0].value+" | "+board.cellArray[2][1].value+" | "+board.cellArray[2][2].value+" |");
        System.out.println("-------------");
        System.out.println("====================");
    }


    public synchronized void increasePoint(){
        point = point + 1;
        myTurn= false;
    }

}
