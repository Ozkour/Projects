package game.tile;

import game.character.Army;
import game.factory.WarFactory;
import game.resource.Sand;
import game.util.BusyTileException;
import game.util.Position;
import game.util.TooMuchSoldierException;

import static org.junit.Assert.*;

import org.junit.Test;

public class DesertTest extends TileExceptOceanTest {
	
	public Desert createTile() {
		return new Desert(new Position(1,2), this.factory);
	}
	
	public void tileIsWellConstructedTest() {
		assertEquals(2, this.tile.getCost());
		assertEquals(new Position(1,2), this.tile.getPosition());
		assertEquals(2, this.tile2.getTurnGold());
		assertEquals(new WarFactory(), this.tile2.getFactory());
	}
	
	
	@Test
	public void acceptTest() throws TooMuchSoldierException {
		assertTrue(this.tile2.accept(1));
	    assertFalse(this.tile2.accept(4));
	}
	
	@Test 
	public void getPerlimpinpinSizeTest() throws TooMuchSoldierException, BusyTileException {
		Army army = new Army(this.tile2, this.player , 2);
		this.tile2.addNpc(army);
		assertEquals(2, this.tile2.getPerlimpinpinSize());
	}
	
	
	@Test 
	public void getResourcesOfWarTest() {
		assertEquals(new Sand(0), this.tile2.getResources());
	}
	
	@Test
	public void getResourcesOfFarmTest() {
		Desert d = new Desert(new Position(5,2), this.factory2);
		assertEquals(new Sand(5), d.getResources());
	}
	
}
