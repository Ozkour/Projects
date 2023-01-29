package game.resource;

import game.Resources;

/**
 * A type of resource that is found on the mountain tiles.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public class Rock extends Resources{
	
	/**
	 * the constructor of Rock
	 * @param value the conversion value of the rock in food or gold
	 */
	public Rock(int value) {
		super(value);
	}
	
	
    /** 
     * To know if an object is equals to a rock
     * @param o another object
     * @return true if the Rock is equals to the object given in parameters and false otherwise 
     */
    public boolean equals(Object o){
        if (o instanceof Rock){
        	Rock other = (Rock) o;
            return this.value == other.value;
        }
        else{
            return false;
        }
    }
	
}