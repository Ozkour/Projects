package game.actions;

import game.Action;
import game.Game;
import game.Player;

/**
 * It is an action possible that a player can choose during his turn.
 * To skip turn of a player in a war game
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class SkipYourTurnWar extends Action{
	
	/**
	 * the constructor
	 */
	public SkipYourTurnWar() {
		this.name = "skip your turn";
	}
    
    
	/**
	 * to skip your turn 
	 * @param currentPlayer the current player
	 * @param game the game of the player 
	 */
	public void dealAction(Player currentPlayer, Game game) {
		
		System.out.println(currentPlayer.getName() +" skips his turn.");
	}

	
}