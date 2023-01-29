package game.actions;

import java.util.*;

import game.Action;
import game.Game;
import game.Player;
import game.Resources;
import game.players.WarPlayer;
import game.util.NotEnoughResourcesException;

/**
 * It is an action possible that a player can choose during his turn.
 * To exchange the resources of the player for food.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class ExchangesResourcesWar extends Action{
	
	/**
	 * the constructor
	 */
	public ExchangesResourcesWar() {
		this.name = "exchange your resources";
	}
    
	/**
	 * to convert resources in food 
	 * @param player the current player
	 * @param game the game of the player 
	 * @throws NotEnoughResourcesException if the player don't have enough of this resource
	 */
	public void dealAction(Player player, Game game) throws NotEnoughResourcesException {
		
		WarPlayer warplayer = (WarPlayer) player;
		List<Resources> l = new ArrayList<>(warplayer.getResources());
		
		for (int i = 0; i < l.size(); i ++) {
			
			warplayer.addFood(l.get(i).getValue());
			warplayer.removeResources(l.get(i));
		}
		
		System.out.println( "\nAll the resources of " + warplayer.getName() + " are exchanged for food.");
		System.out.println( "You have now : " + warplayer.getFoodStock() + " units of food." );
	}
	
}