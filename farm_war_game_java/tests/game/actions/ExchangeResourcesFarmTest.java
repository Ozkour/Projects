package game.actions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import game.Action;
import game.ActionTest;
import game.Resources;



public class ExchangeResourcesFarmTest extends ActionTest {
	
	@Override
	protected Action createAction() {
		return new ExchangesResourcesFarm();
	}
	
	
	@Test 
	public void equalsTest() {
		ExchangesResourcesFarm other = new ExchangesResourcesFarm();
		assertTrue(this.action.equals(other));
	}
	
	@Test 
	public void dealActionTest() throws Exception {
		
		Resources sand = this.farmfactory.buildSand();
		Resources wood = this.farmfactory.buildWood();
		
		this.farmplayer.addResources(sand);
		this.farmplayer.addResources(wood);
		
		this.action.dealAction(this.farmplayer, this.farmgame);
		
		assertEquals(22, this.farmplayer.getGold());
		assertTrue(this.farmplayer.getResources().isEmpty());

	}

	
	
}