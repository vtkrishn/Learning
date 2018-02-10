package main;

import java.util.ArrayList;
import java.util.List;

import main.Tile.COLOR;
import main.piece.Piece;
import main.piece.PieceFactory;

public class Board {
	
	private Tile[][] tiles;
	private List<Piece> whiteCapturedPieces = new ArrayList<>();
	private List<Piece> blackCapturedPieces = new ArrayList<>();
	private boolean currentPlayerWhite;
	private int gameTurn = 0;
	public boolean isCurrentPlayerWhite() {
		return currentPlayerWhite;
	}

	public void setCurrentPlayerWhite(boolean currentPlayerWhite) {
		this.currentPlayerWhite = currentPlayerWhite;
	}

	public Board() {
		this.tiles = new Tile[8][8];
		for(int i=0;i<tiles.length;i++) {
			for(int j=0;j<tiles[0].length;j++) {
				tiles[i][j] = new Tile(i, j , j%2 == 0 ? Tile.COLOR.WHITE : Tile.COLOR.BLACK);
			}
		}
	}
	
	public void placePieces() {
		placePieces(COLOR.WHITE);
		placePieces(COLOR.BLACK);
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}
	
	public Tile getTiles(int x, int y) {
		for(Tile[] tile : tiles) {
			for(Tile t : tile) {
				if(t.getRow() == x && t.getColumn() == y)
					return t;
			}
		}
		return null;
	}
	
	private String displayCapturedPiece(List<Piece> list) {
		StringBuilder stb = new StringBuilder();
		for(Piece p: list) {
			stb.append(p.getName() + " | ");
		}
		return stb.toString();
	}
	public void printBoardStatus() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("White captured pieces :" + displayCapturedPiece(whiteCapturedPieces));
		System.out.println("-----------------------------------------------------------------------------");
		for(Tile[] tile : getTiles()) {
			for(Tile t : tile) {
				if(t.getPiece() != null)
					//System.out.print(t.getPiece() +"-"+ t.getPiece().getColor() + "\t");
					System.out.print(t.getPiece() + "  ");
				else
					System.out.print("." + "  ");
			}
			System.out.println("");
		}
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Black captured pieces :" + displayCapturedPiece(blackCapturedPieces));
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	private int[] getWhiteRows() {
		return new int[] {0,1};
	}
	
	private int[] getBlackRows() {
		return new int[] {6,7};
	}
	
	private void placePieces(Tile.COLOR color) {
		for(Tile[] tiles : getTiles()) {
			for(Tile t : tiles) {
				if(color == COLOR.WHITE) {
					if(t.getRow() == 0) {
						addBaseTerritory(color, t);	
					}
					else if(t.getRow() == 1) {
						addPawns(color, t);
					}
				}
				else {
					if(t.getRow() == 7) {
						addBaseTerritory(color, t);	
					}
					else if(t.getRow() == 6) {
						addPawns(color, t);
					}
				}
			}
		}
	}
	
	public void move(int fromX, int fromY, int toX, int toY) throws Exception {
		Tile fromTile = getTiles(fromX, fromY);
		Piece fromPiece = fromTile.getPiece();
		
		//for the first time white should always start the game
		if(gameTurn == 0)
			setCurrentPlayerWhite(true);
		
		//for the first time , if the piece moved is black or not knight or pawn then throw error
		if(gameTurn == 0 && fromPiece.getColor().equals("BLACK") && !(fromPiece.getName().equals("KNIGHT") && fromPiece.getName().equals("PAWN"))) {
			System.out.println("White piece should start the game first");
			return;
		}
		
		//if its white turn but the piece is black then throw error
		if(isCurrentPlayerWhite() && fromPiece.getColor().equals("BLACK")) {
			System.out.println("White piece turn..");
			return;
		}
		
		//if its black turn but the piece is white then throw error
		if(!isCurrentPlayerWhite() && fromPiece.getColor().equals("WHITE")) {
			System.out.println("BLACK piece turn..");
			return;
		}
		
		Tile toTile = getTiles(toX, toY);
		Piece toPiece = toTile.getPiece();
		
		//if there is no piece to move from the location then throw error
		if(fromPiece == null) {
			System.out.println("There is no piece to move in the from location");
			return;
		}
		
		//if the target piece is null then proceed for legal move
		if(toPiece == null) {
			List<int[]> legalMoves = fromPiece.getLegalMove(fromTile);
			boolean valid = false;
			for(int[] val : legalMoves) {
				if(val[0] == toTile.getRow() && val[1] == toTile.getColumn()) {
					valid = true;
					break;
				}
			}
			
			if(valid) {
				toTile.setPiece(fromPiece);
				System.out.println(fromPiece.getName() + " moved from [" + fromX +","+ fromY  +"] to [" + toX +","+ toY  +"]");
				fromPiece.setMoved();
				fromTile.setPiece(null);
				gameTurn++;
				setCurrentPlayerWhite(!currentPlayerWhite);
			}
			else
				System.out.println("Invalid Move");
		} // if the target piece is not null then its a capturing move
		else if(toPiece != null) {
			List<int[]> captureMoves = fromPiece.getCaptureMove(fromTile);
			boolean valid = false;
			for(int[] val : captureMoves) {
				if(val[0] == toTile.getRow() && val[1] == toTile.getColumn()) {
					valid = true;
					break;
				}
			}
			
			if(valid) {
				if(toPiece.getColor().equals("WHITE"))
					blackCapturedPieces.add(toPiece);
				else
					whiteCapturedPieces.add(toPiece);
				
				toTile.setPiece(fromPiece);
				System.out.println(fromPiece.getName() + " moved from [" + fromX +","+ fromY  +"] to [" + toX +","+ toY  +"]");
				fromPiece.setMoved();
				fromTile.setPiece(null);
				gameTurn++;
				setCurrentPlayerWhite(!currentPlayerWhite);
			}
			else
				System.out.println("Invalid Move");
			
		}
	}
	
	private void addPawns(Tile.COLOR color, Tile t) {
		t.addPiece(PieceFactory.getPiece(Piece.PIECES.PAWN,color, "PAWN"));
	}
	private void addBaseTerritory(Tile.COLOR color, Tile t) {
		if(t.getColumn() == 0 || t.getColumn() == 7)
			t.addPiece(PieceFactory.getPiece(Piece.PIECES.ROOK, color, "ROOK"));
		else if(t.getColumn() == 1 || t.getColumn() == 6)
			t.addPiece(PieceFactory.getPiece(Piece.PIECES.KNIGHT, color, "KNIGHT"));
		else if(t.getColumn() == 2 || t.getColumn() == 5)
			t.addPiece(PieceFactory.getPiece(Piece.PIECES.BISHOP, color, "BISHOP"));
		else if(t.getColumn() == 3)
			t.addPiece(PieceFactory.getPiece(Piece.PIECES.QUEEN, color, "QUEEN"));
		else
			t.addPiece(PieceFactory.getPiece(Piece.PIECES.KING, color, "KING"));
	}
}
