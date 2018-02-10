package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.ChessGameMain;

public class TestChessGameMain extends TestCase{
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
		setUpStreams();
	}
	
	@After
	public void tearDown() {
		restoreStreams();
	}
	
	@Test
	public void testChessMainClass() {
		assertNotNull(ChessGameMain.class);
	}
	
	
	@Test
	public void testMainMethod() {
		ChessGameMain.main(null);
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
				"Enter which piece to move ::from <ROW>,<COL> ::", outContent.toString());
	}
	
}
