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

public class WarFactoryTest extends FactoryTest {
	
	
	public Factory createFactory() {
		return new WarFactory();
	}
	
	
	@Test 
	public void isWellConstructedTest() {
		assertEquals("WarFactory", this.factory.getName());
		
		assertEquals(2, this.factory.getDesertCost());
		assertEquals(1, this.factory.getForestCost());
		assertEquals(1, this.factory.getGrasslandCost());
		assertEquals(1, this.factory.getMountainCost());
		
		assertEquals(0, this.factory.getSandValue());
		assertEquals(1, this.factory.getWoodValue());
		assertEquals(5, this.factory.getWheatValue());
		assertEquals(0, this.factory.getRockValue());
	}
	
	@Test
	public void buildSandTest() {
		Resources resource = this.factory.buildSand();
		assertEquals(new Sand(0), resource);
	}
	
	@Test
	public void buildWoodTest() {
		Resources resource = this.factory.buildWood();
		assertEquals(new Wood(1), resource);
	}
	
	@Test
	public void buildWheatTest() {
		Resources resource = this.factory.buildWheat();
		assertEquals(new Wheat(5), resource);
	}
	
	@Test
	public void buildRockTest() {
		Resources resource = this.factory.buildRock();
		assertEquals(new Rock(0), resource);
	}
	
	
	@Test
	public void equalsTest() {
		WarFactory otherFact = new WarFactory();
		FarmFactory otherFact2 = new FarmFactory();
		
		assertTrue(this.factory.equals(otherFact));
		assertFalse(this.factory.equals(otherFact2));
	}
	
}