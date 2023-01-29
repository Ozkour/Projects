package game.strategy;

import java.io.IOException;

import game.Game;
import game.util.io.*;

/**
 * A human startegy for the war game.
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 05/04/2021
 */

public class HumanStrategyWar extends HumanStrategy{
	
	/**
	 * The constructor
	 * @param game the game chosen
	 */
	public HumanStrategyWar(Game game) {
		super(game);
		this.name = "HumanStrategyWar";
	}

	/**
	 * To get the size of a new npc deployed
	 * @return the size of this npc
	 * @throws IOException if the input is not correct 
	 */
	@Override
	public int getSizeOfNpc() throws IOException {
		System.out.println("Choose the size of your army (between 1 & 5 or 1 & 3 if it's a moutain or a desert).");
		try {
			int choice = Input.readInt();
			if ( choice >= 1 && choice <= 5) {
				return choice;
			}
			else {
				System.out.println("\nWrong choice, an army has a max soldiers of 5 (3 if it's a moutain or a desert).");
				return this.getSizeOfNpc();
			}
		}
		catch (IOException e) {
			System.out.println("\nThe input is not correct.");
			return this.getSizeOfNpc();
		}

	}

	
	
	

	
}