package game.tile;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Army;
import game.factory.WarFactory;
import game.resource.Wheat;
import game.util.BusyTileException;
import game.util.Position;
import game.util.TooMuchSoldierException;


public class GrasslandTest extends TileExceptOceanTest{

	public Grassland createTile() {
		return new Grassland(new Position(8,9), this.factory);
	}
	
	@Test
	public void tileIsWellConstructedTest() {
		assertEquals(1, this.tile.getCost());
		assertEquals(new Position(8,9), this.tile.getPosition());
		assertEquals(1, this.tile2.getTurnGold());
		assertEquals(new WarFactory(), this.tile.getFactory());
	}
	
	@Test 
	public void getPerlimpinpinSizeTest() throws TooMuchSoldierException, BusyTileException {
		Army army = new Army(this.tile2, this.player , 2);
		this.tile2.addNpc(army);
		assertEquals(2, this.tile2.getPerlimpinpinSize());
	}
	
	@Test 
	public void getNbPointsTest() {
		assertEquals(1, this.tile2.getNbPoints());
	}
	
	@Test 
	public void getResourcesOfWarTest() {
		assertEquals(new Wheat(5), this.tile2.getResources());
		
	}
	
	@Test
	public void getResourcesOfFarmTest() {
		Grassland g = new Grassland(new Position(7, 6), this.factory2);
		assertEquals(new Wheat(2), g.getResources());
	}
	
	
}
