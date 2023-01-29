package game.factory;

import game.Factory;

/**
 * A factory for the game of farm which is used to build tiles and resources.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public class FarmFactory extends Factory {
	
	/**
	 * the constructor of war factory
	 */
	public FarmFactory(){
		this.name = "FarmFactory";
		this.desertCost = 3;
		this.forestCost = 1;
		this.grasslandCost = 1;
		this.mountainCost = 5;
		this.sandValue = 5;
		this.woodValue = 2;
		this.wheatValue = 2;
		this.rockValue = 8;
	}
	
	/**
	 * To know if an object and a warFactory are equal
	 * @param o the other object
	 * @return true if they are equals and false otherwise
	 */
	public boolean equals(Object o) {
		if (o instanceof FarmFactory) {
			FarmFactory other = (FarmFactory) o;
			return other.getName().equals(this.getName());
		}
		return false;
	}

}