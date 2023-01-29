package game.tile;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Tile;
import game.util.Position;

public class OceanTest{

	@Test
	public void isWalkingTest() {
		Tile tile3 = new Ocean(new Position(3,4));
		assertFalse(tile3.isWalking());	
		assertEquals(new Position(3,4), tile3.getPosition());
	}

}
