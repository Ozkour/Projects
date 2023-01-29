package game.tile;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Army;
import game.factory.WarFactory;
import game.resource.Rock;
import game.util.BusyTileException;
import game.util.Position;
import game.util.TooMuchSoldierException;

public class MountainTest extends TileExceptOceanTest{

	public Mountain createTile() {
		return new Mountain(new Position(3,7), this.factory);
	}
	
	public void tileIsWellConstructedTest() {
		assertEquals(2, this.tile.getCost());
		assertEquals(new Position(3,7), this.tile.getPosition());
		assertEquals(0, this.tile2.getTurnGold());
		assertEquals(new WarFactory(), this.tile2.getFactory());
	}
	
	
	@Test
	public void acceptTest() throws TooMuchSoldierException {
		assertTrue(this.tile2.accept(3));
	    assertFalse(this.tile2.accept(4));
	}
	
	
	@Test 
	public void getPerlimpinpinSizeTest() throws TooMuchSoldierException, BusyTileException {
		Army army = new Army(this.tile2, this.player , 2);
		this.tile2.addNpc(army);
		assertEquals(4, this.tile2.getPerlimpinpinSize());
	}
	
	@Test 
	public void getResourcesOfWarTest() {
		assertEquals(new Rock(0), this.tile2.getResources());
	}
	
	@Test
	public void getResourcesOfFarmTest() {
		Mountain m = new Mountain(new Position(2, 8), this.factory2);
		assertEquals(new Rock(8), m.getResources());
	}
}
