package game.factory;

import game.Factory;

/**
 * A factory for the game of war which is used to build tiles and resources.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */
public class WarFactory extends Factory {
	
	/**
	 * the constructor of war factory
	 */
	public WarFactory() {
		this.name = "WarFactory";
		this.desertCost = 2;
		this.forestCost = 1;
		this.grasslandCost = 1;
		this.mountainCost = 1;
		this.sandValue = 0;
		this.woodValue = 1;
		this.wheatValue = 5;
		this.rockValue = 0;
	}
	
	/**
	 * To know if an object and a warFactory are equal
	 * @param o the other object
	 * @return true if they are equals and false otherwise
	 */
	public boolean equals(Object o) {
		if (o instanceof WarFactory) {
			WarFactory other = (WarFactory) o;
			return other.getName().equals(this.getName());
		}
		return false;
	}
	
	

}