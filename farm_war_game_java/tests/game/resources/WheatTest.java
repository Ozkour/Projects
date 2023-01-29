package game.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import game.ResourcesTest;

public class WheatTest extends ResourcesTest{
	
	@Test
	public void wheatIsWellConstructedTest() {
		assertEquals(5, this.wheat.getValue());
	}
	
	@Test
	public void equalsTest() {
		assertTrue(this.wheat.equals(this.wheat2));
	}
	
}
