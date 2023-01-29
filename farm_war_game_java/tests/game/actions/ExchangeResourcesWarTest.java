package game.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import game.Action;
import game.ActionTest;
import game.Player;
import game.players.WarPlayer;
import game.resource.Wood;
import game.util.NotEnoughResourcesException;

public class ExchangeResourcesWarTest extends ActionTest {
	
	@Override
	protected Action createAction() {
		return new ExchangesResourcesWar();
	}
	
	@Test 
	public void equalsTest() {
		ExchangesResourcesWar other = new ExchangesResourcesWar();
		assertTrue(this.action.equals(other));
	}
	
	
	@Test
	public void dealActionTest() throws NotEnoughResourcesException{
		
		Player player = new WarPlayer("Routrout",null);
		
		for(int i = 0; i < 5; i ++) {
			player.addResources(new Wood(i));
		}
		
		assertEquals(5, player.getResources().size());
		
		ExchangesResourcesWar erwar = new ExchangesResourcesWar();
		erwar.dealAction(player, null);
		
		assertEquals(0, player.getResources().size());
	}
}