package game.character;

import game.*;

import static org.junit.Assert.*;

import org.junit.Test;


public class FarmerTest extends NPCTest{

	protected Farmer createNPC() {
		return new Farmer(this.tile, this.playerF);
	}
	
    @Test 
    public void farmerWellConstructedTest() {
    	assertEquals(this.tile, this.npc.getPosition());
    	assertEquals(0, this.npc.getGold());
    	assertEquals(this.playerF, this.npc.getPlayer());
    	assertEquals(1, this.npc.getSize());
    }
	

	@Test
	public void equalsNotCorrectTest() {
		Farmer farmer = new Farmer(this.tile2, this.playerF);
		assertFalse(((Farmer)this.npc).equals(farmer));
	}
	
	@Test
	public void equalsCorrectTest() {
		Farmer farmer2 = new Farmer(this.tile, this.playerF);
		assertTrue(((Farmer)this.npc).equals(farmer2));
	}
}