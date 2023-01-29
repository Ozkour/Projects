package game.character;

import game.*;
import game.tile.TileExceptOcean;
/**
 * One of the game's npc : the farmers
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 07/02/2021
 */

public class Farmer extends NPC {
    
    /**
     * the constructor
     * @param tile the position of the farmer on the board
     * @param player the player having this army
     */
    public Farmer(TileExceptOcean tile, Player player){
        super(tile, player);
    }

    /**
     * To know if two objects are equal
     * @param o the object to compare with
     * @return true if the objects are equal and false otherwise
     */
    public boolean equals(Object o){
        if (o instanceof Farmer){
            Farmer other = (Farmer) o;
            return this.position.equals(other.position);
        }
        else{
            return false;
        }
    }
    
    /**
     * To get the object in textual
     * @return a sentence that describes the object
    */
    public String toString(){
        return "a farmer";
    }



}
