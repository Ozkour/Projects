package game.players;


import game.Player;
import game.Strategy;
import game.util.NotEnoughFoodException;

/**
 * The player that is going to play at the war game.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/04/2021
 */

public class WarPlayer extends Player{
    
    private int soldiersStock; // The number of soldiers of the player  
    private int foodStock; // The number of food of the player
 
    
    /**
     * The constructor of Player for a war game
     * @param name the name of the player
     * @param strategy the strategy of the player 
     */
	  public WarPlayer(String name, Strategy strategy){
		  	super(name, strategy);
	        this.soldiersStock = 35;
	        this.foodStock = 10; 
	  }
 
	  /**
	   * To get the number of soldiers of the player's stock 
	   * @return the number of soldiers
	   */
	  public int getSoldiersStock() {
	  	return this.soldiersStock;
	  }
  
	  /**
	   * To get the number of food of the player's stock 
	   * @return the number of food
	   */
	  public int getFoodStock() {
	  	return this.foodStock;
	  }
	  
	  /**
	   * To remove a quantity of food of the stock
	   * @param food the number of food to remove 
	   * @throws NotEnoughFoodException if the player does not have enough food
	   */
	  public void removeFood(int food) throws NotEnoughFoodException{
		  if ( food > this.getFoodStock() ) {
			  	throw new NotEnoughFoodException("You don't have enough food ! ");
		  }
		  this.foodStock -= food;
	  }
	  
	  /**
	   * To add a quantity of food of the stock
	   * @param food the number of food to add
	   */
	  public void addFood(int food) {
	  	this.foodStock += food;
	  }
	  
	  /**
	   * To remove a quantity soldiers of the stock
	   * @param soldiers the number soldiers to remove 
	   */
	  public void removeSoldiers(int soldiers) {
	  	this.soldiersStock -= soldiers;
	  }
}
 