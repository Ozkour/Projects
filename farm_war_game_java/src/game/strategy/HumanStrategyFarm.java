package game.strategy;


import java.io.IOException;

import game.Game;

/**
 * A human strategy for the farm game.
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 05/04/2021
 */

public class HumanStrategyFarm extends HumanStrategy {
	
	/**
	 * The constructor
	 * @param game the game chosen
	 */
	public HumanStrategyFarm(Game game) {
		super(game);
		this.name = "HumanStrategyFarm";
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