package game.players;


import static org.junit.Assert.*;
import game.strategy.*;
import game.util.NotEnoughFoodException;

import org.junit.*;

public class WarPlayerTest {
	
	private WarPlayer player;
	
	@Before
	public void Before() {
		this.player = new WarPlayer("Damien", new HumanStrategyWar(null));
		
	}
	
	@Test
	public void isWellConstructedTest() {
		assertEquals(0, player.getGold());
		assertEquals(10, player.getFoodStock());
		assertEquals(35, player.getSoldiersStock());
	}
	
	
    @Test
    public void weCanAddAndRemoveFoodTest() throws NotEnoughFoodException {
    	assertEquals(10,player.getFoodStock());
    	player.addFood(5);
    	assertEquals(15,player.getFoodStock());
    	player.removeFood(4);
    	assertEquals(11,player.getFoodStock());
    }
    
    @Test(expected = NotEnoughFoodException.class)
    public void weCantRemoveFoodTest() throws NotEnoughFoodException{
    	player.removeFood(12);
    }
    
    @Test
    public void weCanRemoveSoldiersTest() {
    	assertEquals(35,player.getSoldiersStock());
    	player.removeSoldiers(4);
    	assertEquals(31,player.getSoldiersStock());
    }
}
