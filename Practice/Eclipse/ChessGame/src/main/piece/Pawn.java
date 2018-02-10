package main.piece;

import java.util.ArrayList;
import java.util.List;

import main.Tile;
import main.Tile.COLOR;

/**
 * goes only in Straight line
 * initial move will be 2 or 1, after that it will be always 1
 * check if some piece is there immediate diagonal to it then capture it, eg if current position is 1,0, then check for both 1,1 and 1,2
 * if the piece is there then the player loses that piece and the current piece takes that position, maintain players piece count
 * check for enpassant logic
 * if the pawn advances to the init position + 6, then convert the piece (QUEEN, ROOK, KNIGHT, BISHOP)
 * if the x+1, col, has piece then you cannot move, it will invalid move
 * @author vtkrishn
 *
 */
public class Pawn extends Piece{
	public Pawn(COLOR color, String name) {
		super(color, name);
	}
	
	
	public List<int[]> getLegalMove(Tile currentTile){
		List<int[]> result = new ArrayList<int[]>();
		if(!moved) {
			if(color == COLOR.WHITE)
				result.add(new int[] {currentTile.getRow() + 2,currentTile.getColumn()});
			else
				result.add(new int[] {currentTile.getRow() - 2,currentTile.getColumn()});
		}
		
		if(color == COLOR.WHITE)
			result.add(new int[] {currentTile.getRow() + 1,currentTile.getColumn()});
		else
			result.add(new int[] {currentTile.getRow() - 1,currentTile.getColumn()});
		
		return result;
	}
		
	public List<int[]> getCaptureMove(Tile currentTile){	
		List<int[]> result = new ArrayList<int[]>();
		if(color == COLOR.WHITE) {
			result.add(new int[] {currentTile.getRow()+1, currentTile.getColumn() + 1});
			result.add(new int[] {currentTile.getRow()+1, currentTile.getColumn() - 1});	
		}
		else {
			result.add(new int[] {currentTile.getRow()-1, currentTile.getColumn() + 1});
			result.add(new int[] {currentTile.getRow()-1, currentTile.getColumn() - 1});
		}
		
		return result;
	}
}
