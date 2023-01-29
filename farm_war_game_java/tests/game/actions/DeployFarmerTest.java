package game.actions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import game.Action;
import game.ActionTest;
import game.character.Farmer;
import game.tile.TileExceptOcean;
import game.util.Position;



public class DeployFarmerTest extends ActionTest {
	
	@Override
	protected Action createAction() {
		return new DeployFarmer();
	}
	
	
	@Test 
	public void equalsTest() {
		DeployFarmer other = new DeployFarmer();
		assertTrue(this.action.equals(other));
	}
	
	@Test 
	public void dealActionTest() throws Exception {
		
		this.farmgame.addPlayer(this.farmplayer);
		this.action.dealAction(this.farmplayer, this.farmgame);
		
		Position pos = new Position(2,3);
		TileExceptOcean tile = (TileExceptOcean) this.farmboard.getTile(pos);
		Farmer farmer = new Farmer(tile, this.farmplayer);
		
		List<TileExceptOcean> territory = new ArrayList<>();
		territory.add(tile);
		
		
		assertTrue(this.farmboard.getTile(pos).isBusy());
		assertEquals(farmer, tile.getNpc());
		
		assertEquals(territory, this.farmplayer.getTerritories());
	}
	
	
	
}