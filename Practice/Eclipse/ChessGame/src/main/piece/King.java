package main.piece;

import java.util.ArrayList;
import java.util.List;

import main.Board;
import main.Tile;
import main.Tile.COLOR;

/**
 * King can move only one step
 * @author vtkrishn
 *
 */
public class King extends Piece {
	public King(COLOR color, String name) {
		super(color, name);
	}

	@Override
	public List<int[]> getLegalMove(Tile currentTile, Board board) {
		List<int[]> result = new ArrayList<int[]>();
		result.add(new int[] {currentTile.getRow()+1, currentTile.getColumn()});
		result.add(new int[] {currentTile.getRow()-1, currentTile.getColumn()});
		result.add(new int[] {currentTile.getRow(), currentTile.getColumn()+1});
		result.add(new int[] {currentTile.getRow(), currentTile.getColumn()-1});
		
		result.add(new int[] {currentTile.getRow()+1, currentTile.getColumn()+1});
		result.add(new int[] {currentTile.getRow()-1, currentTile.getColumn()-1});
		result.add(new int[] {currentTile.getRow()+1, currentTile.getColumn()-1});
		result.add(new int[] {currentTile.getRow()-1, currentTile.getColumn()+1});
		
		return result;
	}

	@Override
	public List<int[]> getCaptureMove(Tile currentTile, Board board) {
		return getLegalMove(currentTile, board);
	}
}
