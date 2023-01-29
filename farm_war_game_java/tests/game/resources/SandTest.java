package game.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import game.ResourcesTest;

public class SandTest extends ResourcesTest{
	
	@Test
	public void sandIsWellConstructedTest() {
		assertEquals(2, this.sand.getValue());
	}
	
	@Test
	public void equalsTest() {
		assertTrue(this.sand.equals(this.sand2));
	}
	
}