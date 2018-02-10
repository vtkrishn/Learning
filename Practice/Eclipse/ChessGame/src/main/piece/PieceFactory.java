package main.piece;

import main.Tile.COLOR;

public class PieceFactory {
	public static Piece getPiece(Piece.PIECES pieceName, COLOR color, String name){
		if(pieceName == Piece.PIECES.PAWN)
			return new Pawn(color, name);
		else if(pieceName == Piece.PIECES.ROOK)
			return new Rook(color, name);
		else if(pieceName == Piece.PIECES.KNIGHT)
			return new Knight(color, name);
		else if(pieceName == Piece.PIECES.BISHOP)
			return new Bishop(color, name);
		else if(pieceName == Piece.PIECES.QUEEN)
			return new Queen(color, name);
		else if(pieceName == Piece.PIECES.KING)
			return new King(color, name);
		return null;
	}
}
