package game.tile ;

import game.Resources;
import game.Factory;
import game.util.Position;

/**
 * A forest tile.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/03/2021
 */

public class Forest extends TileExceptOcean {
	
	/**
	 * The constructor of a forest tile 
	 * @param position the position of the tile
	 * @param factory the factory depending on the game to create the tiles
	 */
	public Forest(Position position, Factory factory) {
		super(factory.getForestCost(), position, factory);
		this.nbPoints = 2;
	}
	
	/**
	 * To get the type of resources of the tile
	 * @return a new resource wood
	 */
	@Override
	public Resources getResources() {
		return this.getFactory().buildWood();
	}

	/**
	 * To get the name of the tile
	 * @return the name of the tile forest
	 */
	@Override
	public String getName() {
		return "forest ";
	}
	
	/**
     * To get the string used to display the tile
     * @return a string that describe the tile
     */
	@Override
	public String getDisplayBoard() {
		return "F";
	}
	
}