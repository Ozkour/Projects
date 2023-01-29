package game.character;

import game.*;
import game.util.TooMuchSoldierException;

import static org.junit.Assert.*;
import org.junit.Test;


public class ArmyTest extends NPCTest{

	protected Army createNPC() throws TooMuchSoldierException {
		return new Army(tile, this.playerW, 4);
	}

	
    @Test 
    public void ArmyWellConstructedTest() {
    	assertEquals(tile, this.npc.getPosition());
    	assertEquals(0, this.npc.getGold());
    	assertEquals(this.playerW, this.npc.getPlayer());
    	assertEquals(4, this.npc.getSize());
    }
    
    
    @Test 
    public void getPositionTest() {
    	this.npc.setPosition(this.tile2);
    	assertEquals(this.tile2, this.npc.getPosition());
    	
    }
    
    @Test 
    public void getGoldTest() {
    	this.npc.addGold(8);
    	assertEquals(8, this.npc.getGold());
    }
	
    @Test
    public void getPlayerTest() {
    	assertEquals(this.playerW, this.npc.getPlayer());
    }
    
    
    @Test 
    public void getSizeTest() throws TooMuchSoldierException{
    	((Army) this.npc).setSize(2);
    	assertEquals(2, this.npc.getSize());
    }
    
    
    @Test 
    public void setPositionTest() {
    	this.npc.setPosition(this.tile2);
    	assertEquals(this.tile2, this.npc.getPosition());
    }
    
    
    @Test 
    public void setPlayerTest() {
    	Player player2 = new Player("Jean", this.strategyW);
    	this.npc.setPlayer(player2);
    	assertEquals(player2, this.npc.getPlayer());
    }
    
    @Test
    public void addGoldTest() {
    	this.npc.addGold(10);
    	assertEquals(10, this.npc.getGold());
    }
    
    
	
	@Test
	public void setSizeTest() throws TooMuchSoldierException {
		((Army) this.npc).setSize(3);
		assertEquals(3,((Army) this.npc).getSize());
	}
	
	
	
	@Test(expected=TooMuchSoldierException.class)
	public void setNbSoldierWhenTooMuchSoldierTest() throws TooMuchSoldierException {
		((Army) this.npc).setSize(8);
	}
	
	
	@Test
	public void compareSizeOfTwoArmiesTest() {
		assertEquals(1, ((Army) this.npc).compare(this.army));
		assertEquals(-1, this.army.compare((Army) this.npc));
	}
	
	
	
	@Test
	public void equalsNotCorrectTest() {
		assertFalse(((Army)this.npc).equals(this.army));
	}
	
	
	
	@Test
	public void equalsCorrectTest() throws TooMuchSoldierException {
		Army army2 = new Army(tile, this.playerW,3);
		army2.setPosition(tile2);
		Army army3 = new Army(tile, this.playerW,3);
		army3.setPosition(tile2);
		assertTrue(army3.equals(army2));
	}
	
	
	
	@Test(expected=TooMuchSoldierException.class)
	public void armyCantBeDeployedTest() throws TooMuchSoldierException  {
		((Army) this.npc).deployment(tile);
		assertSame(tile,((Army) this.npc).getPosition());
		
	}
	
	@Test
	public void armyIsWellDeployedTest() throws TooMuchSoldierException  {
		((Army) this.npc).deployment(tile2);
		assertSame(tile2,((Army) this.npc).getPosition());
		
	}
}
