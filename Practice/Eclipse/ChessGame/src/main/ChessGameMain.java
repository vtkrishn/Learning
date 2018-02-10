package main;

import java.util.Scanner;

public class ChessGameMain {
	
	public static void main(String[] args) {
		Board board = new Board();
		board.placePieces();
		board.printBoardStatus();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("White piece to move first");
		System.out.println("Enter which piece to move ::from <ROW>,<COL> ::");
		String move = scan.nextLine();
		while(!move.equals("ABORT")) {
			
			String[] fromString = move.split(",");
			int[] fromPoint = {Integer.parseInt(fromString[0]), Integer.parseInt(fromString[1])};
			
			System.out.println("Enter which piece to move ::to <ROW>,<COL> ::");
			move = scan.nextLine();
			String[] toString = move.split(",");
			int[] toPoint = {Integer.parseInt(toString[0]), Integer.parseInt(toString[1])};
			
			try {
				board.move(fromPoint[0], fromPoint[1], toPoint[0], toPoint[1]);	
			}
			catch(Exception e) {
				System.out.println("Some Error, start again");
			}
			
			board.printBoardStatus();
			System.out.println("Enter which piece to move ::from <ROW>,<COL> ::");
			move = scan.nextLine();
		}
		
		scan.close();
	}
}
