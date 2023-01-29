package game.strategy;

import java.io.IOException;

import game.Game;


/**
 * A random strategy of a playerfor the farm game 
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class RandomStrategyFarm extends RandomStrategy{
	

	
	/**
	 * The constructor
	 * @param game the game chosen
	 */
	public RandomStrategyFarm(Game game) {
		super(game);
		this.name = "RandomStrategyFarm";
	}

	/**
	 * To get the size of a new npc deployed
	 * @return the size of this npc
	 * @throws IOException if the input is not correct 
	 */
	public int getSizeOfNpc() throws IOException {
		return 1;
	}

}