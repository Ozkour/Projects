package game;

import game.resource.Rock;
import game.resource.Sand;
import game.resource.Wheat;
import game.resource.Wood;
import game.tile.Desert;
import game.tile.Forest;
import game.tile.Grassland;
import game.tile.Mountain;
import game.util.Position;

/**
 * A factory is used to build tiles and resources.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public abstract class Factory {
	
	protected String name; //the name of the factory
	protected int desertCost; // the maintaining cost of a npc on a desert tile
	protected int forestCost; // the maintaining cost of a npc on a forest tile
	protected int grasslandCost; // the maintaining cost of a npc on a grassland tile
	protected int mountainCost; // the maintaining cost of a npc on a mountain tile
	protected int sandValue; // the value of the sand when it will be converted in gold or food
	protected int woodValue; // the value of the wood when it will be converted in gold or food
	protected int wheatValue; // the value of the wheat when it will be converted in gold or food
	protected int rockValue; // the value of the rock when it will be converted in gold or food
	
	/**
	 * to get the maintaining cost of a npc on a desert tile 
	 * @return the maintaining cost
	 */
	public int getDesertCost() {
		return desertCost;
	}

	/**
	 * to get the maintaining cost of a npc on a forest tile 
	 * @return the maintaining cost
	 */
	public int getForestCost() {
		return forestCost;
	}

	/**
	 * to get the maintaining cost of a npc on a grassland tile 
	 * @return the maintaining cost
	 */
	public int getGrasslandCost() {
		return grasslandCost;
	}

	/**
	 * to get the maintaining cost of a npc on a mountain tile 
	 * @return the maintaining cost
	 */
	public int getMountainCost() {
		return mountainCost;
	}
	
	/**
	 * to get the conversion value of the sand (in gold or food)
	 * @return the conversion value
	 */
	public int getSandValue() {
		return sandValue;
	}

	/**
	 * to get the conversion value of the wood (in gold or food)
	 * @return the conversion value
	 */
	public int getWoodValue() {
		return woodValue;
	}

	/**
	 * to get the conversion value of the wheat (in gold or food)
	 * @return the conversion value
	 */
	public int getWheatValue() {
		return wheatValue;
	}

	/**
	 * to get the conversion value of the rock (in gold or food)
	 * @return the conversion value
	 */
	public int getRockValue() {
		return rockValue;
	}
	
	/**
	 * to build a desert tile
	 * @param position the position of the tile 
	 * @return the desert tile 
	 */
	public Tile buildDesert(Position position) {
		return new Desert(position, this);
	}
	
	/**
	 * to build a forest tile
	 * @param position the position of the tile 
	 * @return the forest tile 
	 */
	public Tile buildForest(Position position) {
		return new Forest(position, this);

	}
	
	/**
	 * to build a grassland tile
	 * @param position the position of the tile 
	 * @return the grassland tile 
	 */
	public Tile buildGrassland(Position position) {
		return new Grassland(position, this);
	}
	
	/**
	 * to build a mountain tile
	 * @param position the position of the tile 
	 * @return the mountain tile 
	 */
	public Tile buildMountain(Position position) {
		return new Mountain(position, this);
	}
	
	/**
	 * to build a resource of sand 
	 * @return the resource of sand  
	 */
	public Resources buildSand() {
		return new Sand(this.sandValue);
	}
	
	/**
	 * to build a resource of wood
	 * @return the resource of wood 
	 */
	public Resources buildWood() {
		return new Wood(this.woodValue);
	}
	
	/**
	 * to build a resource of wheat
	 * @return the resource of wheat 
	 */
	public Resources buildWheat() {
		return new Wheat(this.wheatValue);
	}
	
	/**
	 * to build a resource of rock
	 * @return the resource of rock 
	 */
	public Resources buildRock() {
		return new Rock(this.rockValue);
	}
	
	/**
	 * to get the name of the factory
	 * @return the name of the factory
	 */
	public String getName() {
		return name;
	}
	
	
	
}
