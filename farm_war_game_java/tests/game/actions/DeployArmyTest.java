package game.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;


import game.*;
import game.character.Army;
import game.tile.TileExceptOcean;
import game.util.Position;

public class DeployArmyTest extends ActionTest {
	
	@Override
	protected Action createAction() {
		return new DeployArmy();
	}
	
	@Test 
	public void equalsTest() {
		DeployArmy other = new DeployArmy();
		assertTrue(this.action.equals(other));
	}
	
	@Test 
	public void dealActionTest() throws Exception{
		this.wargame.addPlayer(this.warplayer);
		this.action.dealAction(this.warplayer, this.wargame);
		
		Position pos = new Position(2,3);
		TileExceptOcean tile = (TileExceptOcean) this.warboard.getTile(pos);
		Army army = new Army(tile, this.warplayer, this.strat1.getSizeOfNpc());
		
		List<TileExceptOcean> territory = new ArrayList<>();
		territory.add(tile);
		
		
		assertTrue(this.warboard.getTile(pos).isBusy());
		assertEquals(army, tile.getNpc());
		
		assertEquals(territory, this.warplayer.getTerritories());
	}
}