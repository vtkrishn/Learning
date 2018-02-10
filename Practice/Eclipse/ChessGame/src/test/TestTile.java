package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import main.Tile;

public class TestTile extends TestCase{
	Tile tile;
	
	@Before
	public void setUp() {
		this.tile = new Tile(0,0,Tile.COLOR.WHITE);
	}
	
	@After
	public void tearDown() {
		this.tile = null;
	}
	
	@Test
	public void testTileClass() {
		assertNotNull(Tile.class);
	}
	
	
	@Test
	public void testTileInstance() {
		assertNotNull(this.tile);
	}
	
	
	
	
	
}
