package game.strategy;

import java.io.IOException;
import java.util.Random;

import game.Game;
import game.Strategy;

/**
 * A random strategy of a player.
 * the player choose the actions randomly.
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public abstract class RandomStrategy extends Strategy{
	
	private Random alea = new Random(); //to create a new random object
	
	/**
	 * The constructor
	 * @param game the game chosen
	 */
	protected RandomStrategy(Game game) {
		super(game);
		this.name = "RandomStrategy";
	}

	/**
	 * To choose the action depending on the strategy choosen
	 * @param nbChoices of possible actions 
	 * @return the number of the action chosen 
	 * @throws IOException if the input isn't correct
	 */
	@Override
	public int choice(int nbChoices) throws IOException {
		return alea.nextInt(nbChoices);
	}
	
	
	/**
	 * To get the horizontal coordinate 
	 * @return the horizontal coordinate
	 * @throws IOException if the input isn't correct
	 */
	@Override
	protected int getX() throws IOException {
		return alea.nextInt(this.getGame().getBoard().getWidth());
	}

	/**
	 * used to get the vertical coordinate 
	 * @return the vertical coordinate
	 * @throws IOException if the input isn't correct
	 */
	@Override
	protected int getY() throws IOException {
		return alea.nextInt(this.getGame().getBoard().getHeight());
	}
	
	
	/**
	 * To get the size of a new npc deployed
	 * @return the size of this npc
	 * @throws IOException if the input is not correct 
	 */
	public abstract int getSizeOfNpc() throws IOException;
	
}