package game.actions;

import game.Action;
import game.Game;
import game.Player;
import game.players.FarmPlayer;
import game.tile.*;

/**
 * It is an action possible that a player can choose during his turn.
 * To skip turn of a player and distribute gold in a farm game
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class SkipYourTurnFarm extends Action{
	
	/**
	 * the constructor
	 */
	public SkipYourTurnFarm() {
		this.name = "skip your turn";
	}
    
    
	/**
	 * to skip your turn and to win golds
	 * @param currentPlayer the current player
	 * @param game the game of the player 
	 */
	public void dealAction(Player currentPlayer, Game game) {
		
		FarmPlayer farmplayer = (FarmPlayer) currentPlayer;
		
		for (TileExceptOcean territory : farmplayer.getTerritories()){  // for each territory of the player
			
			currentPlayer.addGold(territory.getTurnGold());	 // we give to the player the gold equivalents
		
		}
		
		System.out.println(currentPlayer.getName() +" skips his turn. ");
		System.out.println("He has now : " + currentPlayer.getGold() + " golds.");
	}
	
	
}