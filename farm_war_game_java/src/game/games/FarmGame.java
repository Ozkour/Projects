	package game.games;

import java.util.ArrayList;
import java.util.List;

import game.*;
import game.players.FarmPlayer;
import game.tile.*;
import game.util.BusyTileException;
import game.util.NotEnoughGoldException;
import game.actions.*;

/**
 * A farm game.
 * You can deploy farmers on the board, collect and exchange resources.
 * If your farmers have the bigger amount of gold you win !
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */

public class FarmGame extends Game {

    /**the constructor
    * @param board the board for the party
    */
	public FarmGame(Board board) {
		super(board);
		this.nbTurns = 6;
		this.getActions().add(new DeployFarmer());
		this.getActions().add(new SkipYourTurnFarm());
		this.getActions().add(new ExchangesResourcesFarm());
	}
	
	/**
	 * To get the stock of gold of the player
	 * @param currentPlayer the player
	 * @return the stock of gold of the player
	 */
	public int getStock(Player currentPlayer) {
		return currentPlayer.getGold();
	}
	
	/**
	 * To give the salary to the NPC
	 * @param npc the farmer to pay
	 * @param currentPlayer the current player
	 * @throws NotEnoughGoldException if the player doesn't have enough gold
	 * @throws BusyTileException for the method suppNpc()
	 */
	public void maintain(NPC npc, Player currentPlayer) throws NotEnoughGoldException, BusyTileException {
		
		FarmPlayer player = (FarmPlayer) currentPlayer;
		
		if (this.canSurvive(npc, player)) {
			int salary = npc.getPosition().getCost();
			player.removeGold(salary); // to remove the gold of the player 
			npc.addGold(salary); // to give the salary to his npc
		}
		else {
			System.out.println("yessss");
			System.out.println("\nYou don't have enough resources to maintain the npc at the tile : " + npc.getPosition().toString());
			npc.getPosition().suppNpc();
			throw new NotEnoughGoldException("You don't have enough gold to maintain your farmers." );
		}
	}

	
	/**
	 * To calculate the points of the players
	 * @return a list of all the scores  
	 */
	public List<Integer> getScores() {
		this.rulesOfVictory();
		
		List<Integer> thePoints = new ArrayList<>();
		for(int i = 0; i < this.getPlayers().size(); i ++) {
			int cpt = 0;
			
			for(TileExceptOcean territory : this.getPlayers().get(i).getTerritories() ) {
				System.out.println("His farmer at the tile " + territory.toString() + " has " + territory.getNpc().getGold()+ " gold(s)");
				cpt += territory.getNpc().getGold();
			}
			thePoints.add(cpt);
			System.out.println("\n" + this.getPlayers().get(i).getName().toUpperCase() + " OBTAINS " + cpt + " POINT(S)\n");
		}
		return thePoints;
	}
	
	/**
	 * to get the report of the resources of the player 
	 * @param currentPlayer the current player
	 */
	public void getReport(Player currentPlayer) {
		
		System.out.println( "- " + currentPlayer.getName() + " has " + currentPlayer.getGold() + " gold(s)");
		
		if (currentPlayer.getResources().isEmpty()) {
			System.out.println("- You do not have any resource");
		}
		else {
			System.out.println("\n- Your resource(s) :");
			this.displayResources(currentPlayer);
		}
		
		if (currentPlayer.getTerritories().isEmpty()) {
			System.out.println("- You do no thave any territory");
		}
		else {
			System.out.println("\n- Your territory(ies) :");
			
			for(TileExceptOcean territory : currentPlayer.getTerritories()) {
				System.out.println("	- " + territory.toString());
			}
		}
	}
	
	/**
	 * to get the initial situation of the players when the game starts
	 */
	public void getInitialSituation() {
		
		System.out.println("\n\n _____________________________________________________________");
		System.out.println("|                                                             |");
		System.out.println("| The game starts, it will last 6 turns                       |");
		System.out.println("| Each player has 15 golds                                    |");
		System.out.println("|_____________________________________________________________|");
		
		System.out.println("\nThe board is : \n");
		this.getBoard().displayBoard();
	}

	/**
	 * to display the rules of a victory
	 */
	@Override
	public void rulesOfVictory() {
		System.out.println("\n __________________________________________________________");
		System.out.println("|                                                         |");
		System.out.println("| The points are calculated with the gold of each farmer  |");
		System.out.println("|_________________________________________________________|\n");
	}
	
	/**
	 * to display when a player maintain his farmer(s)
	 * @param npc the farmer to maintain 
	 */
	@Override
	public void displayMaintain(NPC npc) {
		System.out.println("\nYou have payed " + npc.toString() + " with " + npc.getPosition().getCost() + " golds at the tile " + npc.getPosition().toString());
	}
	


}
