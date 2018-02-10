package main;

import main.piece.Piece;

public class Tile {
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public enum COLOR {WHITE, BLACK};
	COLOR color;
	private int row;
	private int column;
	Piece piece;
	
	public Tile(int row, int col, COLOR color) {
		this.row = row;
		this.column = col;
		this.color = color;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	
	public void addPiece(Piece piece) {
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}
	
	
	
}
