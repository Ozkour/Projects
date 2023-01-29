package game.players;


import game.Player;
import game.Strategy;

/**
 * The player that is going to play at the farm game.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/04/2021
 */
public class FarmPlayer extends Player{
	
	  /**
	   * The constructor of Player for a farm game
	   * @param name the name of the player
	   * @param strategy the strategy of the player 
	   */
	  public FarmPlayer(String name, Strategy strategy){
	      super(name, strategy);
	      this.gold = 15;
	}
    
}