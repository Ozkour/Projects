package game.resource;

import game.Resources;

/**
 * A type of resource that is found on the grassland tiles.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public class Wheat extends Resources{
	
	/**
	 * The constructor of the Wheat
	 * @param value the conversion value of the wheat in food or gold
	 */
	public Wheat(int value) {
		super(value);
	}
	
	
    /** 
     * To know if an object is equals to a wheat
     * @param o another object
     * @return true if the Wheat is equals to the object given in parameters and false otherwise 
     */
    public boolean equals(Object o){
        if (o instanceof Wheat){
        	Wheat other = (Wheat) o;
            return this.value == other.value;
        }
        else{
            return false;
        }
    }
	
}