package game.tile ;

import game.Factory;
import game.NPC;
import game.Resources;
import game.Tile;
import game.util.BusyTileException;
import game.util.Position;

/**
* A tile of the board which can only be walking.
* 
* @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
* @version 27/03/2021
*/

public abstract class TileExceptOcean extends Tile{
	
    protected int turnGold; // The gold to add if the player skip his turn
    protected int nbPoints; // The points to attribute to the player if his npc is on this tile 
    protected Factory factory; // A factory to build the resources
    
	/**
	 * the constructor 
	 * @param cost the maintaining cost of a npc if he is on this tile
	 * @param position the position of the tile
	 * @param factory the factory depending on the game to create the tiles
	 */
	protected TileExceptOcean(int cost, Position position, Factory factory) {
		super(cost,position);
		this.walking = true;
		this.turnGold = 1;
		this.nbPoints = 4;
        this.factory = factory;
	}
    
    /**
     * To get the number of gold if the player skip his turn
     * @return the number of gold to add to the player 
     */
    public int getTurnGold() {
    	return this.turnGold;
    }
    
    /**
     * To get the size of army with the enemy's point of view
     * @return the unreal size
     */
	public int getPerlimpinpinSize() {
		return this.npc.getSize();
	}
	
	/**
     * To get the number of points that the tile worth
     * @return the number of points
     */
	public int getNbPoints() {
		return this.nbPoints;
	}
	
    /**
     * To get the factory of the tile
     * @return the factory of the tile
     */
    public Factory getFactory() {
    	return this.factory;
    }
    
    /**
     * To know if the npc can be on this tile 
     * @param size the size of the npc
     * @return true if the npc is accepted and false otherwise
     */
    public boolean accept(int size) {
    	return true;
    }

    /**
	 * To get the type of resources of the tile
	 * @return a new resource sand
	 */
	public abstract Resources getResources();
	
	/**
	 * To get the name of the tile
	 * @return the name of the tile
	 */
	public abstract String getName();
	
	
    /**
     * To put a npc on this tile
     * @param npc the new npc that we want to put on the tile
     * @throws BusyTileException if the tile is already busy by a npc 
     */
    public void addNpc(NPC npc) throws BusyTileException {
        if (this.isBusy() && npc != null){
            throw new BusyTileException("a Npc is already on this tile");
        }
        else {
            this.npc = npc;
        }
    }
    
    /**
     * To delete the NPC on the tile
     * @throws BusyTileException if the tile is already busy by a npc
     */
    public void suppNpc() throws BusyTileException {
		NPC npc2 = this.npc;
		this.npc.getPosition().addNpc(null);
		npc2.setPosition(null);
		
		TileExceptOcean tile = (TileExceptOcean) this;
		npc2.getPlayer().removeTerritory(tile);
   }

     
	
	/**
	 * To get a sentence with the tile's description for the display
	 * @return the tile's description
	 */
	public String toString() {
		return this.getName() + this.getPosition().toString();
	}
	
	/**
     * To know if a tile is equals to an other object
     * @return true if two tiles are equal and false otherwise
     */
	@Override
    public boolean equals(Object o) {
		if (o instanceof TileExceptOcean) {
			TileExceptOcean other = (TileExceptOcean) o;
			if (other.getPosition().equals(this.getPosition())) {
				return true;
			}
		}
		return false;
    }
	
}