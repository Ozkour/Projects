package game.actions;

import java.util.ArrayList;
import java.util.List;

import game.Action;
import game.Game;
import game.Player;
import game.Resources;
import game.players.FarmPlayer;
import game.util.NotEnoughResourcesException;

/**
 * It is an action possible that a player can choose during his turn.
 * To exchange the resources of the player for gold.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class ExchangesResourcesFarm extends Action {
	
	/**
	 * the constructor
	 */
	public ExchangesResourcesFarm() {
		this.name = "exchange your resources";
	}
    
	/**
	 * to exchange resources in gold 
	 * @param currentPlayer the current player
	 * @param game the game of the player 
	 * @throws NotEnoughResourcesException if the player don't have enough of this resource
	 */
	public void dealAction(Player currentPlayer, Game game) throws NotEnoughResourcesException {
		
		FarmPlayer farmplayer = (FarmPlayer) currentPlayer;
		List<Resources> l = new ArrayList<>(farmplayer.getResources());
		
		for ( Resources resources : l) {
			farmplayer.addGold(resources.getValue()); // we give the gold equivalents to the player's resources
			farmplayer.removeResources(resources);  // we remove the resources of the player
		}
		
		System.out.println( "\n All resources of " + farmplayer.getName() + " are exchanged for gold.");
		System.out.println(  " This player has now : " + farmplayer.getGold() + " golds.");
	
	}
	
}