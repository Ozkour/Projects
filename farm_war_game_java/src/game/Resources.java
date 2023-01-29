package game;


/**
 * The class for all the resources possible in the different games.
 * A resource depends on a tile. For example, if a NPC is on a desert tile, the resource associated is the sand.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public abstract class Resources {
	
	protected int value; // the value of the resource (in gold or food)
	
	/**
	 * the constructor of a resource
	 * @param value the value of the resource (in gold or food)
	 */
	protected Resources(int value) {
		this.value = value;
	}
	

	/**
	 * to get the value of the resource
	 * @return the value of the resource
	 */
	public int getValue() {
		return this.value;
	}
	
    /** 
     * To know if an object is equals to a resource
     * @param o another object
     * @return true if the Resource is equals to the object given in parameters and false otherwise 
     */
    public boolean equals(Object o){
        if (o instanceof Resources){
            Resources other = (Resources) o;
            return this.value == other.value;
        }
        else{
            return false;
        }
    }

}
