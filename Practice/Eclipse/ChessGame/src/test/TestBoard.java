package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.Board;
import main.Tile;
import main.Tile.COLOR;

public class TestBoard extends TestCase{
	Board board;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	public void restoreStreams() {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}
	
	@Before
	public void setUp() {
		this.board = new Board();
		setUpStreams();
	}
	
	@After
	public void tearDown() {
		this.board = null;
		restoreStreams();
	}
	
	@Test
	public void testBoardClass() {
		assertNotNull(Board.class);
	}
	
	
	@Test
	public void testBoardInstance() {
		assertNotNull(this.board);
	}
	
	@Test
	public void testBoardTiles() {
		Tile[][] tiles = this.board.getTiles();
		assertNotNull(tiles);
		assertTrue(tiles.length == 8);
		for(Tile[] tile : tiles) {
			assertNotNull(tile);
			for(Tile t : tile) {
				assertNotNull(t);	
			}
		}
	}
	
	@Test
	public void testPlacePieces() {
		this.board.placePieces();
		for(Tile[] tile : this.board.getTiles()) {
			for(Tile t : tile) {
				//pieces properly placed or not
				if(t.getRow() == 0 || t.getRow() == 1 || t.getRow() == 6 || t.getRow() == 7)
					assertNotNull(t.getPiece());
				else
					assertNull(t.getPiece());
				
				//pieces colors properly assigned or not
				if(t.getRow() == 0 || t.getRow() == 1)
					assertTrue(t.getPiece().getColor().equals(COLOR.WHITE.toString()));
				if(t.getRow() == 6 || t.getRow() == 7)
					assertTrue(t.getPiece().getColor().equals(COLOR.BLACK.toString()));
				
			}
		}
	}
	
	@Test
	public void testGetTile() {
		Tile tile = this.board.getTiles(0, 0);
		assertNotNull(tile);
		assertEquals(tile.getRow(),0);
		assertEquals(tile.getColumn(),0);
		
		tile = this.board.getTiles(-1, -1);
		assertNull(tile);
		
		tile = this.board.getTiles(100, 100);
		assertNull(tile);
	}
	
	@Test
	public void testMove() throws Exception {
		this.board.placePieces();
		this.board.move(1, 0, 2, 0);
		this.board.move(5, 0, 3, 7);
	}
	
	@Test
	public void testPrintStatus() {
		this.board.printBoardStatus();
		assertEquals("-----------------------------------------------------------------------------\r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				"-----------------------------------------------------------------------------\r\n" + 
				"",outContent.toString());
		outContent.reset();
		this.board.placePieces();
		this.board.printBoardStatus();
		assertEquals("-----------------------------------------------------------------------------\r\n" + 
				"||  @  ^  &  +  ^  @  ||  \r\n" + 
				"x  x  x  x  x  x  x  x  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				".  .  .  .  .  .  .  .  \r\n" + 
				"x  x  x  x  x  x  x  x  \r\n" + 
				"||  @  ^  &  +  ^  @  ||  \r\n" + 
				"-----------------------------------------------------------------------------\r\n" + 
				"" + 
				"",outContent.toString());
	}

}
