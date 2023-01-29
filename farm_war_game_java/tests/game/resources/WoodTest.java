package game.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import game.ResourcesTest;

public class WoodTest extends ResourcesTest{
	
	@Test
	public void woodIsWellConstructedTest() {
		assertEquals(1, this.wood.getValue());
	}
	
	@Test
	public void equalsTest() {
		assertTrue(this.wood.equals(this.wood2));
	}
	
}