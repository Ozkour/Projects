package game.actions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import game.Action;
import game.ActionTest;
import game.tile.TileExceptOcean;
import game.util.Position;



public class SkipYourTurnFarmTest extends ActionTest {
	
	@Override
	protected Action createAction() {
		return new SkipYourTurnFarm();
	}
	
	@Test 
	public void equalsTest() {
		SkipYourTurnFarm other = new SkipYourTurnFarm();
		assertTrue(this.action.equals(other));
	}
	
	@Test 
	public void dealActionTest() throws Exception {
		Position pos = new Position(2,3);
		Position pos2 = new Position(2,4);
		
		TileExceptOcean tile = (TileExceptOcean) this.farmboard.getTile(pos);
		TileExceptOcean tile2 = (TileExceptOcean) this.farmboard.getTile(pos2);
		
		this.farmplayer.addTerritory(tile);
		this.farmplayer.addTerritory(tile2);
		
		this.action.dealAction(this.farmplayer, this.farmgame);
		
		assertEquals(19 , this.farmplayer.getGold());
		
	}

	
	
}