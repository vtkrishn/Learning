package main.piece;

import java.util.ArrayList;
import java.util.List;

import main.Board;
import main.Tile;
import main.Tile.COLOR;

public class Rook extends Piece {
	public Rook(COLOR color, String name) {
		super(color, name);
	}

	@Override
	public List<int[]> getLegalMove(Tile currentTile,Board board) {
		List<int[]> result = new ArrayList<int[]>();
		result = addToResult(board, result, currentTile.getRow()+1, currentTile.getColumn(), true);
		result = addToResult(board, result, currentTile.getRow(), currentTile.getColumn()+1, false);
		return result;
	}

	private List<int[]> addToResult(Board board, List<int[]> result, int i, int j,boolean flag){
		Tile tile = board.getTiles(i,  j);
		if(tile == null || tile.getPiece() != null)
			return result;
		result.add(new int[] {i, j});
		if(flag)
			result = addToResult(board, result, i+1, j, flag);
		else
			result = addToResult(board, result, i, j+1,flag);
		return result;
	}
	
	private List<int[]> addToCapture(Board board, List<int[]> result, int i, int j,boolean flag){
		Tile tile = board.getTiles(i,  j);
		if(tile == null || tile.getPiece() != null) {
			result.add(new int[] {i, j});
			return result;
		}
		if(flag)
			result = addToCapture(board, result, i+1, j, flag);
		else
			result = addToCapture(board, result, i, j+1,flag);
		return result;
	}
	
	@Override
	public List<int[]> getCaptureMove(Tile currentTile,Board board) {
		List<int[]> result = new ArrayList<int[]>();
		result = addToCapture(board, result, currentTile.getRow()+1, currentTile.getColumn(), true);
		result = addToCapture(board, result, currentTile.getRow(), currentTile.getColumn()+1, false);
		return result;
	}
}
