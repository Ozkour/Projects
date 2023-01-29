package game.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


import game.Factory;
import game.FactoryTest;
import game.resource.Rock;
import game.resource.Sand;
import game.resource.Wheat;
import game.resource.Wood;
import game.Resources;

public class FarmFactoryTest extends FactoryTest {
	
	
	public Factory createFactory() {
		return new FarmFactory();
	}
	
	
	@Test 
	public void isWellConstructedTest() {
		assertEquals("FarmFactory", this.factory.getName());
		
		assertEquals(3, this.factory.getDesertCost());
		assertEquals(1, this.factory.getForestCost());
		assertEquals(1, this.factory.getGrasslandCost());
		assertEquals(5, this.factory.getMountainCost());
		
		assertEquals(5, this.factory.getSandValue());
		assertEquals(2, this.factory.getWoodValue());
		assertEquals(2, this.factory.getWheatValue());
		assertEquals(8, this.factory.getRockValue());
	}
	
	@Test
	public void buildSandTest() {
		Resources resource = this.factory.buildSand();
		assertEquals(new Sand(5), resource);
	}
	
	@Test
	public void buildWoodTest() {
		Resources resource = this.factory.buildWood();
		assertEquals(new Wood(2), resource);
	}
	
	@Test
	public void buildWheatTest() {
		Resources resource = this.factory.buildWheat();
		assertEquals(new Wheat(2), resource);
	}
	
	@Test
	public void buildRockTest() {
		Resources resource = this.factory.buildRock();
		assertEquals(new Rock(8), resource);
	}
	
	
	@Test
	public void equalsTest() {
		WarFactory otherFact = new WarFactory();
		FarmFactory otherFact2 = new FarmFactory();
		
		assertTrue(this.factory.equals(otherFact2));
		assertFalse(this.factory.equals(otherFact));
	}
	
}