package game.resource;

import game.Resources;

/**
 * A type of resource that is found on the forest tiles.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public class Wood extends Resources{
	
	/**
	 * The constructor of Wood
	 * @param value the conversion value of the wood in food or gold
	 */
	public Wood(int value) {
		super(value);
	}
	
    /** 
     * To know if an object is equals to a wood
     * @param o another object
     * @return true if the Wood is equals to the object given in parameters and false otherwise 
     */
    public boolean equals(Object o){
        if (o instanceof Wood){
        	Wood other = (Wood) o;
            return this.value == other.value;
        }
        else{
            return false;
        }
    }
}