package game;

import game.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.tile.*;
import game.factory.FarmFactory;
import game.resource.*;
import game.strategy.*;


public class PlayerTest{

    private Player player1;
    private Strategy strat;

    @Before
    public void Before(){
    	this.strat = new RandomStrategyFarm(null);
        this.player1 = new Player("Roger", this.strat);
    }
    
    @Test
	public void isWellConstructedTest() {
		assertEquals("Roger", player1.getName());
		assertTrue(player1.getResources().isEmpty());
		assertTrue(player1.getTerritories().isEmpty());
		assertEquals(this.strat, player1.getStrategy());
    }
    
    @Test
    public void weCanAddAndRemoveGoldTest() throws NotEnoughGoldException{
        assertEquals(0, this.player1.getGold());
        this.player1.addGold(1);
        assertEquals(1, this.player1.getGold());
        this.player1.removeGold(1);
        assertEquals(0, this.player1.getGold());
    }
    
    @Test(expected = NotEnoughGoldException.class)
    public void weCantRemoveGoldTest() throws NotEnoughGoldException {
    	this.player1.removeGold(255);
    }

    @Test
    public void weCanAddAndRemoveATerritoryTest() {
    	
        assertEquals(0, this.player1.getTerritories().size());
        
        Factory factory = new FarmFactory();
        TileExceptOcean desert = new Desert(null, factory);
        this.player1.addTerritory(desert);
        
        assertTrue(this.player1.getTerritories().contains(desert));
        
        this.player1.removeTerritory(desert);
        
        assertEquals(0, this.player1.getTerritories().size());
    }

    @Test
    public void weCanAddAndRemoveResourcesTest() throws NotEnoughResourcesException {
    	
        assertEquals(0, this.player1.getResources().size());
        
        Resources wheat = new Wheat(5);
        this.player1.addResources(wheat);
        
        assertEquals(new Wheat(5), this.player1.getResources().get(0));
        
        this.player1.removeResources(wheat);
        
        assertEquals(0, this.player1.getResources().size());
    }
    
    @Test(expected = NotEnoughResourcesException.class)
    public void weCantRemoveResourcesTest() throws NotEnoughResourcesException {
    	Resources wheat = new Wheat(5);
    	Resources wood = new Wood(2);
        this.player1.addResources(wheat);
        
    	this.player1.removeResources(wood);
    }
    
    @Test
    public void equalsNotCorrectTest() {
    	
    	assertFalse(this.player1.equals(new Player("Jean-Christophe",new HumanStrategyFarm(null))));
    }
    
    @Test
    public void equalsCorrectTest() {
    	
    	assertTrue(this.player1.equals(new Player("Roger",new RandomStrategyFarm(null))));
    }

}