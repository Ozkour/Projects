package game;

import static org.junit.Assert.*;

import org.junit.Test;

import game.character.Farmer;
import game.factory.FarmFactory;
import game.factory.WarFactory;
import game.strategy.RandomStrategyFarm;
import game.tile.TileExceptOcean;
import game.util.BusyTileException;

import org.junit.Before;

public abstract class TileTest {
	
	
	protected TileExceptOcean tile;
	protected TileExceptOcean tile2;
	protected Farmer farmer;
	protected Farmer farmer2;
	protected Player player;
	protected Strategy strat;
	protected Factory factory;
	protected Factory factory2;
	
	@Before
	public void Before() {
		this.factory = new WarFactory();
		this.factory2 = new FarmFactory();
		this.tile = createTile();
		this.tile2 = createTile();
		this.strat = new RandomStrategyFarm(null);
		this.player = new Player("Jean", this.strat);
		this.farmer = new Farmer(this.tile, this.player);
		this.farmer2 = new Farmer(this.tile2, this.player);
	}
	
	public abstract TileExceptOcean createTile();
	
	@Test
	public void TileDoesNotHaveDeafaultNpcTest() {
		assertEquals(null, this.tile.npc);
	}
	
	@Test
	public void getNpcTest() {
		assertNull(this.tile.getNpc());
	}
	
	@Test 
	public void isBusyTest() throws BusyTileException {
		this.tile2.addNpc(this.farmer2);
		assertTrue(this.tile2.isBusy());
		assertFalse(this.tile.isBusy());
	}
   

}
