package game.strategy;

import java.util.Random;

import game.Game;

/**
 * A random strategy of a player for the war game.
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class RandomStrategyWar extends RandomStrategy{
	
	private Random alea = new Random(); //to create a new random object
	
	/**
	 * The constructor
	 * @param game the game chosen
	 */
	public RandomStrategyWar(Game game) {
		super(game);
		this.name = "RandomStrategyWar";
	}
	
	/**
	 * To get the size of a new npc deployed
	 * @return the size of this npc
	 */
	@Override
	public int getSizeOfNpc() {
		return alea.nextInt(5) + 1;
	}

}

