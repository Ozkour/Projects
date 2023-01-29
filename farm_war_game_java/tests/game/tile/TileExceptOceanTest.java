package game.tile;

import static org.junit.Assert.*;

import org.junit.Test;

import game.TileTest;
import game.util.BusyTileException;
import game.util.TooMuchSoldierException;

public abstract class TileExceptOceanTest extends TileTest {
	
	@Test
	public void isWalkingTest() {
		assertTrue(this.tile.isWalking());
	}
	
	@Test
	public void getStrategyTest() {
		assertEquals(this.factory, this.tile.getFactory());
	}

	@Test 
	public void acceptTest() throws TooMuchSoldierException{
		assertTrue(this.tile2.accept(4));
	}
	
	@Test 
	public void getNbPointsTest() {
		assertEquals(4, this.tile2.getNbPoints());
	}
	
	@Test
	public void setNpcTest() throws BusyTileException{
		this.tile.addNpc(this.farmer);
		assertSame(this.farmer, this.tile.getNpc());
	}
	
	@Test(expected = BusyTileException.class)
	public void setNpcWhenTheTileIsAlreadyBusyTest() throws BusyTileException{
		this.tile.addNpc(this.farmer);
		this.tile.addNpc(this.farmer2);
	}
	
	@Test 
	public void suppNpcTest() throws BusyTileException {
		this.tile.addNpc(this.farmer);
		this.tile.suppNpc();
		
		assertNull(this.tile.getNpc());
		assertNull(this.farmer.getPosition());
		
		boolean found = false;
		for (TileExceptOcean territory : this.farmer.getPlayer().getTerritories()) {
			if (this.tile.equals(territory)) {
				found = true;
			}
		}
		assertFalse(found);	
	}
	
}