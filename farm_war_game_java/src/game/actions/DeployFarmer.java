package game.actions;

import game.Action;
import game.Game;
import game.Player;
import game.Strategy;
import game.character.*;
import game.players.*;
import game.tile.TileExceptOcean;
/**
 * It is an action possible that a player can choose during his turn.
 * To deploy a farmer during the farm game
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class DeployFarmer extends Action{
	
	/**
	 * the constructor
	 */
	public DeployFarmer() {
		this.name = "deploy a farmer";
	}
    
	/**
	 * to deploy a farmer
	 * @param currentPlayer the current player
	 * @param game the game of the player 
	 * @throws Exception for the method getCoord()
	 */
	public void dealAction(Player currentPlayer, Game game) throws Exception{
		FarmPlayer player = (FarmPlayer) currentPlayer;
		
		// get the strategy of the player
		Strategy strategy = player.getStrategy();
		
		// get the tile where we want to put the farmer
		TileExceptOcean tile = strategy.getCoord();
		
		// check if the tile is busy and request new coord if it is
		while (tile.isBusy()) {
			System.out.println("This tile is busy, please choose another one");
			tile = strategy.getCoord();
		}
		
		// creation of the new farmer
		Farmer farmer = new Farmer(tile, currentPlayer);
		
		tile.addNpc(farmer);
		
		// the territory is added to the player 
		player.addTerritory(tile);
		
		System.out.println(currentPlayer.getName() + " deploys a farmer at the tile : " + tile.toString() );
	}

	
}