package game.tile ;

import game.Tile;
import game.util.Position;

/**
 * An ocean tile.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/03/2021
 */

public class Ocean extends Tile {
	
	/**
	 * the constructor of a ocean tile 
	 * @param position the position of the tile
	 */
	public Ocean(Position position) {
		super(0, position);
	}
	
	/**
     * To get the string used to display the tile
     * @return a string that describe the tile
     */
	@Override
	public String getDisplayBoard() {
		return "~";
	}
	
}