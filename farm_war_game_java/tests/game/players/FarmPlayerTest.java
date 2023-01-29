package game.players;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import game.strategy.HumanStrategyFarm;


public class FarmPlayerTest {
	
	private FarmPlayer player;
	
	@Before
	public void Before() {
		this.player = new FarmPlayer("Damien", new HumanStrategyFarm(null));
		
	}
	
	@Test
	public void isWellConstructedTest() {
		assertEquals(15, player.getGold());
	}
}