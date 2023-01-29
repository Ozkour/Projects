package game.resource;

import game.Resources;

/**
 * A type of resource that is found on the desert tiles.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public class Sand extends Resources{
	
	/**
	 * The constructor of Sand
	 * @param value the conversion value of the sand in food or gold
	 */
	public Sand(int value) {
		super(value);
	}
	
	
    /** 
     * To know if an object is equals to a sand
     * @param o another object
     * @return true if the Sand is equals to the object given in parameters and false otherwise 
     */
    public boolean equals(Object o){
        if (o instanceof Sand){
        	Sand other = (Sand) o;
            return this.value == other.value;
        }
        else{
            return false;
        }
    }
}