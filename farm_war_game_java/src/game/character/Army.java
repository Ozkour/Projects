package game.character;

import game.*;
import game.tile.TileExceptOcean;
import game.util.*;

/**
 * One of the game's npc : the army that contains a number of warriors between 1 and 5 (also depending on the tile).
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 11/02/2021
 */
public class Army extends NPC{

    private static final int MAX_SOLDIER = 5; // The maximum size of the army
    
    
    /**
     * The constructor of Army, the position of the army is null on default
     * @param nbSoldiers  the number of soldiers in the army
     * @param player the player having this army
     * @param tile the tile of the army
     * @throws TooMuchSoldierException if the new number of soldiers is too high
     */
    public Army(TileExceptOcean tile, Player player, int nbSoldiers) throws TooMuchSoldierException {
    	super(tile, player);
    	if (nbSoldiers > MAX_SOLDIER) {
    		throw new TooMuchSoldierException("An army is contains 1 to 5 soldiers");
    	}
        this.size = nbSoldiers;
    }
    
    
    /**to set the number of soldiers in the army
     * @param newNumber the new number of soldiers in the army
     * @throws TooMuchSoldierException if the new number of soldiers is too high
    */
    public void setSize(int newNumber) throws TooMuchSoldierException {
        if(newNumber > MAX_SOLDIER) {
            throw new TooMuchSoldierException("An army is contains 1 to 5 soldiers. If the tile is a desert or a mountain, the maximum size is 3.");
        }
        this.size = newNumber;
    }
    
    /**
     * To deploy an army on a tile
     * @param tile the tile where you want to put your army
     * @throws TooMuchSoldierException if the size of army is too big for the tile 
     */
    public void deployment(TileExceptOcean tile) throws TooMuchSoldierException {
    	if(tile.accept(this.getSize())) {
    		this.position = tile;
    	}
    	else {
    		throw new TooMuchSoldierException("An army is contains 1 to 5 soldiers. If the tile is a desert or a mountain, the maximum size is 3.");
    	}
    }

    /**to divide by two the army if it loose the fight*/
    public void decrease() {
        this.size = this.getSize() / 2;
    }

    /**
    * To compare the size of 2 armies for a fight
    * @param otherArmy : an other army 
    * @return : -1 if the other army is bigger, 0 if they are equal, 1 if the other army is smaller
    */
    public int compare(Army otherArmy) {
        if (this.getSize()>otherArmy.getSize()) {             
            return 1; 
        }
        else if (this.getSize()<otherArmy.getSize()) {
            return -1;
        }
        return 0;   
    }


    /** 
     * To know if an object is equals to the army
     * @param o another object
     * @return true if the Army is equals to the object given in parameters, otherwise false 
     */
    public boolean equals(Object o) {
        if (o instanceof Army){
            Army other = (Army) o;
            return this.size == other.size && this.position.equals(other.position);
        }
        else{
            return false;
        }
    }


    /**
     * To get the object in textual
     * @return a sentence that describes the object
    */
    public String toString() {
        return "an army of " + this.getSize() + " soldiers ";
    }



}
