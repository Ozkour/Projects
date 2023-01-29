package game.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import game.ResourcesTest;

public class RockTest extends ResourcesTest{
	
	@Test
	public void rockIsWellConstructedTest() {
		assertEquals(4, this.rock.getValue());
	}
	
	@Test
	public void equalsTest() {
		assertTrue(this.rock.equals(this.rock2));
	}
	
}