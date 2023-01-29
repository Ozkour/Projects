package game.tile ;

import game.Factory;
import game.Resources;
import game.util.*;

/**
 * A desert tile.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/03/2021
 */

public class Desert extends TileExceptOcean {
	
	private static final int MAX_SOLDIER = 3; // The max soldiers which the tile can accept 
	
	/**
	 * The constructor of a desert tile 
	 * @param position the position of the tile
	 * @param factory the factory depending on the game to create the tiles
	 */
	public Desert(Position position, Factory factory) {
		super(factory.getDesertCost(), position, factory);
		this.turnGold = 2;
	}
    
	 /**
     * To know if the npc can be on this tile 
     * @param size the size of the npc
     * @return true if the npc is accepted and false otherwise
     */
	@Override
    public boolean accept(int size) {
    	return size <= MAX_SOLDIER;
    }
    
	/**
	 * To get the type of resources of the tile
	 * @return a new resource sand
	 */
	@Override
	public Resources getResources() {
		return this.getFactory().buildSand();
	}

	/**
	 * To get the name of the tile
	 * @return the name of the tile desert
	 */
	@Override
	public String getName() {
		return "desert ";
	}

	/**
     * To get the string used to display the tile
     * @return a string that describe the tile
     */
	@Override
	public String getDisplayBoard() {
		return "D";
	}

}