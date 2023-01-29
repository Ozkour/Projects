package game.tile;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Army;
import game.factory.WarFactory;
import game.resource.Wood;
import game.util.BusyTileException;
import game.util.Position;
import game.util.TooMuchSoldierException;

public class ForestTest extends TileExceptOceanTest{

	public Forest createTile() {
		return new Forest(new Position(1,5), this.factory);
	}
	
	public void tileIsWellConstructedTest() {
		assertEquals(1, this.tile.getCost());
		assertEquals(new Position(1,5), this.tile.getPosition());
		assertEquals(1, this.tile2.getTurnGold());
		assertEquals(new WarFactory(), this.tile2.getFactory());
	}
	
	@Test 
	public void getPerlimpinpinSizeTest() throws TooMuchSoldierException, BusyTileException {
		Army army = new Army(this.tile2, this.player , 2);
		this.tile2.addNpc(army);
		assertEquals(2, this.tile2.getPerlimpinpinSize());
	}
	
	@Test 
	public void getNbPointsTest() {
		assertEquals(2, this.tile2.getNbPoints());
	}
	
	@Test 
	public void getResourcesOfWarTest() {
		assertEquals(new Wood(1), this.tile2.getResources());
	}
	
	@Test
	public void getResourcesOfFarmTest() {
		Forest f = new Forest(new Position(8, 4), this.factory2);
		assertEquals(new Wood(2), f.getResources());
	
	}
}
