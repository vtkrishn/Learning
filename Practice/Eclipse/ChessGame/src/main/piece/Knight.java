package main.piece;

import java.util.ArrayList;
import java.util.List;

import main.Board;
import main.Tile;
import main.Tile.COLOR;

public class Knight extends Piece {
	public Knight(COLOR color, String name) {
		super(color, name);
	}

	@Override
	public List<int[]> getLegalMove(Tile currentTile,Board board) {
		List<int[]> result = new ArrayList<int[]>();
			result.add(new int[] {currentTile.getRow() + 2,currentTile.getColumn() - 1});
			result.add(new int[] {currentTile.getRow() + 2,currentTile.getColumn() + 1});
			result.add(new int[] {currentTile.getRow() - 2,currentTile.getColumn() - 1});
			result.add(new int[] {currentTile.getRow() - 2,currentTile.getColumn() + 1});
			
			result.add(new int[] {currentTile.getRow() + 1,currentTile.getColumn() + 2});
			result.add(new int[] {currentTile.getRow() + 1,currentTile.getColumn() - 2});
			result.add(new int[] {currentTile.getRow() - 1,currentTile.getColumn() + 2});
			result.add(new int[] {currentTile.getRow() - 1,currentTile.getColumn() - 2});
		
		return result;
	}

	@Override
	public List<int[]> getCaptureMove(Tile currentTile,Board board) {
		return getLegalMove(currentTile, board);
	}
}
