package game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import game.tile.Desert;
import game.tile.Forest;
import game.tile.Grassland;
import game.tile.Mountain;
import game.util.Position;

public abstract class FactoryTest {
	
	
	protected Factory factory;
	protected Position position;
	
	@Before 
	public void Before() {
		this.factory = this.createFactory();
		this.position = new Position(0, 0);
	}
	
	
	public abstract Factory createFactory();
	
	@Test
	public void buildForestTest() {
		Tile tile = this.factory.buildForest(this.position);
		assertEquals(new Forest(this.position, this.factory), tile);
	}
	
	@Test
	public void buildDesertTest() {
		Tile tile = this.factory.buildDesert(this.position);
		assertEquals(new Desert(this.position, this.factory), tile);
	}
	
	@Test
	public void buildGrasslandTest() {
		Tile tile = this.factory.buildGrassland(this.position);
		assertEquals(new Grassland(this.position, this.factory), tile);
	}
	
	@Test
	public void buildMountainTest() {
		Tile tile = this.factory.buildMountain(this.position);
		assertEquals(new Mountain(this.position, this.factory), tile);
	}
	
}
