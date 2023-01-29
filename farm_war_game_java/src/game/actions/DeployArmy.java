package game.actions;

import java.util.List;

import game.*;
import game.character.Army;
import game.games.WarGame;
import game.players.WarPlayer;
import game.tile.TileExceptOcean;
import game.util.TooMuchSoldierException;

/**
 * It is an action possible that a player can choose during his turn.
 * To deploy an army during the war game
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public class DeployArmy extends Action{
	
	/**
	 * the constructor
	 */
	public DeployArmy() {
		this.name = "deploy an army";
	}
    
	/**
	 * to deploy an army 
	 * @param currentPlayer the current player
	 * @param currentPlayer the game of the player 
	 * @throws Exception for the methods getSizeOfNpc(), getCoord(), checkAdjacentArmies() and the creation of an army
	 */
	public void dealAction(Player currentPlayer, Game game) throws Exception {
		
		WarGame wargame = (WarGame) game;
		WarPlayer player = (WarPlayer) currentPlayer;
		
		Strategy strategy = player.getStrategy();
		
		int nbSoldiers = strategy.getSizeOfNpc();
		
		TileExceptOcean tile = strategy.getCoord();
		
		// check if the tile is busy and request new coord if it is
		while (tile.isBusy()) {
			System.out.println("This tile is busy, please choose another one");
			tile = strategy.getCoord();
		}
		
		// check if the tile accept the size of the army and if it's false : we get a new size of army
		while (!tile.accept(nbSoldiers)) {
			nbSoldiers = strategy.getSizeOfNpc();
		}
		
		Army army = new Army(tile, currentPlayer, nbSoldiers);
		
		tile.addNpc(army);
		
		player.removeSoldiers(nbSoldiers);
		player.addTerritory(tile);
		List<Army> adjacentArmies = wargame.adjacentArmies(tile);

		System.out.println( "\n" + currentPlayer.getName() + " deploys " + army.toString() + "at the tile : " + tile.toString() );
		
		this.ifAdjacentArmies(adjacentArmies, wargame, player, army);
		
	}
	
	/**
	 * If there is armies around, there is a fight or gold added or soldier added or nothing
	 * @param adjacentArmies the list of the army.ies around
	 * @param wargame the game
	 * @param player the current player
	 * @param army the army deployed
	 * @throws TooMuchSoldierException for the methods setSize() and fight()
	 */
	private void ifAdjacentArmies(List<Army> adjacentArmies, WarGame wargame, WarPlayer player, Army army) throws TooMuchSoldierException {
		
		for(Army armyAround : adjacentArmies) {
			
			if(wargame.isAlly(armyAround, player)) { // if it's an ally
				
				if (armyAround.getSize() < army.getSize()) { // and if it is smaller
					player.addGold(1); // the player wins 1 gold
					
					System.out.println("You win 1 gold.");
					
					if(armyAround.getPosition().accept(armyAround.getSize() + 1)) { // and if the tile accept the size
						armyAround.setSize(armyAround.getSize() + 1); // the ally wins 1 soldier
						System.out.println("the ally army next to the new army is now composed of " + armyAround.getSize() + ".");
					}
				}
				
				else {
					System.out.println("You are next to an ally army bigger than the new deployed army.\n");
				}
				
			}
			
			else { // if it is an enemy
				if (armyAround.getSize() < army.getSize()) { // if this army is smaller 
					wargame.fight(army, armyAround); // there is a fight
				}
				
				else {
					System.out.println("You are next to an ennemy army bigger than the new deployed army.\n");
				}
			}
		}
	}
	
	
}