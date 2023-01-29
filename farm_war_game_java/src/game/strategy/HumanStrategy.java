package game.strategy;

import java.io.IOException;

import game.Game;
import game.Strategy;
import game.util.io.*;

/**
 * A strategy of a player.
 * The player choose his actions manually.
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 05/04/2021
 */


public abstract class HumanStrategy extends Strategy{
	
	
	/**
	 * The constructor
	 * @param game the game chosen
	 */
	protected HumanStrategy(Game game) {
		super(game);
		this.name = "HumanStrategy";
	}

	/**
	 * To choose the action depending on the strategy choosen
	 * @param nbChoices of possible actions
	 * @return the number of the action chosen 
	 * @throws IOException if the input isn't correct
	 */
	@Override
	public int choice(int nbChoices) throws IOException {
		try {
			int choice = Input.readInt();
			if ( choice >= 0 && choice < nbChoices) {
				return choice;
			}
			else {
	        	System.out.println("\nWrong choice, please choose between the possible options.");
	            return this.choice(nbChoices);
	        }
		}
		catch (IOException e) {
			System.out.println("The input is not correct, please try again. ");
			return this.choice(nbChoices);
		}
	}
	
	/**
	 * To get the horizontal coordinate 
	 * @return the horizontal coordinate
	 * @throws IOException if the input isn't correct
	 */
	protected int getX() throws IOException {
		System.out.println("Choose the horizontal coordinate where you want to put your army : ");
		try {
			int x = Input.readInt();
			
			if ( x < 0 || x >= this.getGame().getBoard().getWidth()) {
				System.out.println("\nWrong, the coordinate must be between 0 and " + (this.getGame().getBoard().getWidth()-1) );
	            return this.getX();
			}
			
			else {
				return x;
			}
		}
		catch (IOException e) {
			System.out.println("\nWrong, the coordinate must be between 0 and " + (this.getGame().getBoard().getWidth()-1) );
			return this.getX();
		}
	}
	
	/**
	 * used to get the vertical coordinate 
	 * @return the vertical coordinate
	 * @throws IOException if the input isn't correct
	 */
	protected int getY() throws IOException {
		System.out.println("Choose the vertical coordinate where you want to put your character : ");
		try {
			int y = Input.readInt();
			
			if ( y < 0 || y >= this.getGame().getBoard().getHeight()) {
				System.out.println("\nWrong, the coordinate must be between 0 and " + (this.getGame().getBoard().getHeight()-1) );
	            return this.getY();
			}
			else {
				return y;
			}
		}
		catch (IOException e) {
			System.out.println("\nWrong, the coordinate must be between 0 and " + (this.getGame().getBoard().getHeight()-1) );
            return this.getY();
		}
	}
	
	/**
	 * To get the size of a new npc deployed
	 * @return the size of this npc
	 * @throws IOException if the input is not correct 
	 */
	public abstract int getSizeOfNpc() throws IOException;
	
}