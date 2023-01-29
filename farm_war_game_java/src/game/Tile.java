package game;

import game.util.Position;

/**
* A tile of the board where can be only one NPC.
* A tile has a type (for example, it can be an ocean, a desert, ...).
* 
* @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
* @version 03/03/2021
*/


public abstract class Tile {

    protected NPC npc; // the npc on the tile
    protected int maintainingCost; // the maintaining cost for the npc on the tile
    protected boolean walking; // if a npc can walk on the tile 
    protected Position position; // the position of the tile on the board
    
    
    /**
    * the constructor
    * @param cost the cost of the tile 
    * @param position the position of the tile on the board
    */
    protected Tile(int cost, Position position){
        this.npc = null;
        this.walking = false;
        this.maintainingCost = cost;
        this.position = position;
    }

    /**
     * To know if a npc can walk on the tile 
     * @return true if it is a "walking" tile and false otherwise
     */
    public boolean isWalking(){
        return this.walking;
    }
    
    /**
     * To get the npc on the tile
     * @return the npc on the tile
     */
    public NPC getNpc(){
        return this.npc;
    }
    
    /**
     * To get the maintaining cost of a npc if he is on this tile
     * @return the maintaining cost that corresponds to the tile
     */
    public int getCost(){
        return this.maintainingCost;
    }
    
    /**
     * To get the position of the tile
     * @return the position of the tile
     */
    public Position getPosition() {
    	return this.position;
    }
    
    
    /**
     * To know if the tile is busy
     * @return true if the tile is busy and false otherwise
     */
    public boolean isBusy(){
        return this.npc != null;
    }

    
    /**
     * To know if a tile is equals to an other object
     * @return true if two tiles are equal and false otherwise
     */
    public boolean equals(Object o) {
		if(o instanceof Tile) {
			Tile other = (Tile) o;
			if (other.getPosition() == this.getPosition() && other.getCost() == this.getCost()) {
				return true;
			}
		}
		return false;
    }
    
    /**
     * To get the string used to display the tile
     * @return a string that describe the tile
     */
    public abstract String getDisplayBoard();
    


}