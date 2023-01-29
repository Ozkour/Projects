package game.tile ;

import game.Factory;
import game.Resources;
import game.util.Position;

/**
 * A mountain tile.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/03/2021
 */

public class Mountain extends TileExceptOcean {
	
	private static final int MAX_SOLDIER = 3; // The max soldiers which the tile can accept
	private static final int PERLIMPINPIN = 2; // The additional size for the army 
	
	/**
	 * The constructor of a mountain tile 
	 * @param position the position of the tile
	 * @param factory the factory depending on the game to create the tiles
	 */
	public Mountain(Position position, Factory factory) {
		super(factory.getMountainCost(), position, factory);
		this.turnGold = 0;
	}
    
    /**
     * To get the size of an army with the enemy's point of view
     * @return the unreal size
     */
	@Override
	public int getPerlimpinpinSize() {
		return this.npc.getSize() + PERLIMPINPIN;
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
	 * @return a new resource rock
	 */
	@Override
    public Resources getResources() {
    	return this.getFactory().buildRock();
    }

	/**
	 * To get the name of the tile
	 * @return the name of the tile mountain
	 */
	@Override
	public String getName() {
		return "mountain ";
	}
   
	/**
     * To get the string used to display the tile
     * @return a string that describe the tile
     */
	@Override
	public String getDisplayBoard() {
		return "M";
	}

}