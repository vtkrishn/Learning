package main.piece;

import java.util.List;

import main.Board;
import main.Tile;
import main.Tile.COLOR;

public abstract class Piece {
	public String getName() {
		return name;
	}
	
	
	public enum PIECES {PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING}
	COLOR color;
	String name;
	boolean moved;
	boolean supported;
	
	public Piece(COLOR color, String name) {
		this.color = color;
		this.name = name;
	}
	
	public abstract List<int[]> getLegalMove(Tile currentTile, Board board);
	public abstract List<int[]> getCaptureMove(Tile currentTile, Board board);
	
	@Override
	public String toString() {
		String value = "";
		if(name.equals("PAWN"))
			value = "x";
		else if(name.equals("ROOK"))
			value = "|";
		else if(name.equals("KNIGHT"))
			value = "@";
		else if(name.equals("BISHOP"))
			value = "^";
		else if(name.equals("QUEEN"))
			value = "&";
		else if(name.equals("KING"))
			value = "+";
		return value;
	}

	public String getColor() {
		return color.toString();
	}
	
	public boolean isMoved(){
		return this.moved;
	}
	
	public void setMoved() {
		this.moved = true;
	}
	
}
