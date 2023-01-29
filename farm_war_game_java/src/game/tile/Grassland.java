package game.tile ;

import game.Resources;
import game.Factory;
import game.util.Position;

/**
 * A grassland tile.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/03/2021
 */

public class Grassland extends TileExceptOcean {
	
	/**
	 * The constructor of a grassland tile 
	 * @param position the position of the tile
	 * @param factory the factory depending on the game to create the tiles
	 */
	public Grassland(Position position, Factory factory) {
		super(factory.getGrasslandCost(), position, factory);
		this.nbPoints = 1;
	}
	
	/**
	 * To get the type of resources of the tile
	 * @return a new resource wheat
	 */
	@Override
	public Resources getResources() {
		return this.getFactory().buildWheat();
	}

	/**
	 * To get the name of the tile
	 * @return the name of the tile grassland
	 */
	@Override
	public String getName() {
		return "grassland ";
	}

	/**
     * To get the string used to display the tile
     * @return a string that describe the tile
     */
	@Override
	public String getDisplayBoard() {
		return "G";
		
	}
}