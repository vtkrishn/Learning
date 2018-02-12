package main.piece;

import java.util.ArrayList;
import java.util.List;

import main.Board;
import main.Tile;
import main.Tile.COLOR;

public class Queen extends Piece {
	public Queen(COLOR color, String name) {
		super(color, name);
	}
	
	@Override
	public List<int[]> getLegalMove(Tile currentTile,Board board) {
		List<int[]> result = new ArrayList<int[]>();
		result = addToResult(board, result, currentTile.getRow()+1, currentTile.getColumn()-1, 1);
		result = addToResult(board, result, currentTile.getRow()+1, currentTile.getColumn()+1, 2);
		result = addToResult(board, result, currentTile.getRow()-1, currentTile.getColumn()-1, 3);
		result = addToResult(board, result, currentTile.getRow()-1, currentTile.getColumn()+1, 4);
		
		result = addToResult(board, result, currentTile.getRow()+1, currentTile.getColumn(), 5);
		result = addToResult(board, result, currentTile.getRow(), currentTile.getColumn()+1, 6);
		return result;
	}

	private List<int[]> addToResult(Board board, List<int[]> result, int i, int j, int count){
		Tile tile = board.getTiles(i,  j);
		if(tile == null || tile.getPiece() != null)
			return result;
		result.add(new int[] {i, j});
		switch(count) {
			case 1:
				result = addToResult(board, result, i+1, j-1, count);
				break;
			case 2:
				result = addToResult(board, result, i+1, j+1, count);
				break;
			case 3:
				result = addToResult(board, result, i-1, j-1, count);
				break;
			case 4:
				result = addToResult(board, result, i-1, j+1, count);
				break;	
			case 5:
				result = addToResult(board, result, i+1, j, count);
				break;
			case 6:
				result = addToResult(board, result, i, j+1, count);
				break;	
		}
		
		return result;
	}
	
	private List<int[]> addToCapture(Board board, List<int[]> result, int i, int j, int count){
		Tile tile = board.getTiles(i,  j);
		if(tile == null || tile.getPiece() != null) {
			result.add(new int[] {i, j});
			return result;
		}
		
		switch(count) {
			case 1:
				result = addToCapture(board, result, i+1, j-1, count);
				break;
			case 2:
				result = addToCapture(board, result, i+1, j+1, count);
				break;
			case 3:
				result = addToCapture(board, result, i-1, j-1, count);
				break;
			case 4:
				result = addToCapture(board, result, i-1, j+1, count);
				break;	
			case 5:
				result = addToCapture(board, result, i+1, j, count);
				break;
			case 6:
				result = addToCapture(board, result, i, j+1, count);
				break;	
		}
		
		return result;
	}

	@Override
	public List<int[]> getCaptureMove(Tile currentTile, Board board) {
		List<int[]> result = new ArrayList<int[]>();
		result = addToCapture(board, result, currentTile.getRow()+1, currentTile.getColumn()-1, 1);
		result = addToCapture(board, result, currentTile.getRow()+1, currentTile.getColumn()+1, 2);
		result = addToCapture(board, result, currentTile.getRow()-1, currentTile.getColumn()-1, 3);
		result = addToCapture(board, result, currentTile.getRow()-1, currentTile.getColumn()+1, 4);
		
		result = addToCapture(board, result, currentTile.getRow()+1, currentTile.getColumn(), 5);
		result = addToCapture(board, result, currentTile.getRow(), currentTile.getColumn()+1, 6);
		return result;
	}
}
