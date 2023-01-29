package game.games;

import java.util.ArrayList;
import java.util.List;

import game.*;
import game.actions.*;
import game.character.Army;
import game.players.WarPlayer;
import game.tile.TileExceptOcean;
import game.util.BusyTileException;
import game.util.NotEnoughFoodException;
import game.util.Position;
import game.util.TooMuchSoldierException;

/**
 * A war game.
 * You can deploy armies on the board, fight, collect and exchange resources.
 * If you has the biggest amount of points you win ! 
 * The points are determine by your gold and your armies' gold and your territories.
 *  
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */

public class WarGame extends Game {

	public static final int DEATH_GOLD = 1; // the gold added to the player if an army dies
	
    /**
     * The constructor
     * @param board the board used in the party
     */
    public WarGame(Board board) {
		super(board);
		this.getActions().add(new DeployArmy());
		this.getActions().add(new SkipYourTurnWar());
	}

    /**
    * used to give money to the player if one of his armies cannot survive 
    * @param currentPlayer the current player
    */
    protected void deathMoney(Player currentPlayer){
    	currentPlayer.addGold(DEATH_GOLD);
    }

	/**
	 * To get the stock of food of a player
	 * @param currentPlayer the current player
	 * @return the stock of food of the player
	 */
	public int getStock(Player currentPlayer) {
		WarPlayer player = (WarPlayer) currentPlayer;
		return player.getFoodStock();
	}
	
	/**
	* To know if there are armies around
	* @param tile the tile that we want to check
	* @return a list of all the armies around this tile 
	*/
	public List<Army> adjacentArmies(TileExceptOcean tile) {
		List<Army> adjacentArmies = new ArrayList<>(); // a list for all adjacent armies
		
		List<Position> tiles = this.getBoard().getTileAround(tile.getPosition());
		for(int i = 0; i < tiles.size(); i++) {
			
			Army army = (Army) this.getBoard().getTile(tiles.get(i)).getNpc();// to get the npc on the adjacent tile  
			if(army != null) { // to check if a tile contains a npc
				adjacentArmies.add(army);
			}
		}
		return adjacentArmies;
	}
	
	/**
	 * To know if the adjacent army is an ally or not
	 * @param army the army to check
	 * @param currentPlayer the current player 
	 * @return true if the other army is an ally and false if it is an enemy 
	 */
	public boolean isAlly(Army army, WarPlayer currentPlayer) {
			return army.getPlayer().equals(currentPlayer);
	}

	/**
	 * To convert resources of a player to food
	 * @param currentPlayer the current player 
	 * @throws Exception for the method dealAction()
	 */
	public void convertInFood(Player currentPlayer) throws Exception {
		
		Action convert = new ExchangesResourcesWar();
		convert.dealAction(currentPlayer, this);
	}

	/**
	 * To feed the armies
	 * @param npc the army of the player to feed
	 * @param currentPlayer the current player 
	 * @throws NotEnoughFoodException for the method removeFood()
	 * @throws BusyTileException for the method suppNpc()
	 */
	public void maintain(NPC npc, Player currentPlayer) throws NotEnoughFoodException, BusyTileException {
		WarPlayer player = (WarPlayer) currentPlayer; // cast of Player in WarPlayer
		
		if (this.canSurvive(npc, player)) {
			player.removeFood(npc.getPosition().getCost() * npc.getSize());
		}
		else {
			System.out.println("\nYou don't have enough resources to maintain the npc at the tile : " + npc.getPosition().toString());
			npc.getPosition().suppNpc();
			throw new NotEnoughFoodException("You don't have enough food to maintain your armies.");
		}
	}


	
	/**
	 * To deal a fight between 2 armies
	 * @param army the npc of the first player 
	 * @param otherArmy the npc of the second player
	 * @throws TooMuchSoldierException for the method setSize()
	 */
	public void fight(Army army, Army otherArmy) throws TooMuchSoldierException {
		
		System.out.println(army.getPlayer().getName() + " wins the fight !");
		
		otherArmy.decrease(); // The other army is divided by 2 
		
		if ( otherArmy.getPosition().getPerlimpinpinSize() < 1 ) { // if the other army is totally destroyed
			
			System.out.println(otherArmy.getPlayer().getName() + " loose his army." );
			
			army.getPlayer().addTerritory(otherArmy.getPosition()); // the territory is our
			otherArmy.getPlayer().removeTerritory(otherArmy.getPosition()); // remove the territory to the other player 
			otherArmy.setSize(1); // an army of one soldier
			otherArmy.setPlayer(army.getPlayer()); // the army becomes our
			army.addGold(2); // our army wins 2 golds
			
			System.out.println("Now, " + otherArmy.getPlayer().getName() + " has an army of " + otherArmy.getSize() + " at the tile " + otherArmy.getPosition());
			System.out.println( army.getPlayer().getName() + "'s deployed army has now " + army.getGold() + " golds.\n");
		}
		else {
			System.out.println(otherArmy.getPlayer().getName() + " loose and now his army's size is " + otherArmy.getSize());
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
			
			System.out.println("\nFinally, your territory(ies) are :");
			this.displayTerritories(this.getPlayers().get(i));
			
			if (this.getPlayers().get(i).getTerritories().size() >= 10) {
				System.out.println("\n" + this.getPlayers().get(i).getName() + " have received the bonus of 5 points.");
				cpt += 5;
			}
			System.out.println("\n" + this.getPlayers().get(i).getName() + " has " + this.getPlayers().get(i).getGold() + " gold(s).\n");
			cpt += this.getPlayers().get(i).getGold();
			
			for(TileExceptOcean territory : this.getPlayers().get(i).getTerritories() ) {
				System.out.println("His army at the tile " + territory.toString() + " has " + territory.getNpc().getGold()+ " gold(s).");
				cpt += territory.getNpc().getGold();
				cpt += territory.getNbPoints();
			}
			thePoints.add(cpt);
			System.out.println("\n" + this.getPlayers().get(i).getName().toUpperCase() + " OBTAINS " + cpt + " POINT(S).\n");
		}
		return thePoints;
	}

	/**
	 * to get the report of the resources of the player 
	 * @param currentPlayer the current player
	 */
	public void getReport(Player currentPlayer) {
		
		WarPlayer player = (WarPlayer) currentPlayer;
		
		System.out.println("You have :");
		System.out.println("- " + player.getFoodStock() + " unit(s) of food");
		System.out.println("- " + player.getSoldiersStock() + " soldier(s) in stock");
		
		if (currentPlayer.getTerritories().isEmpty()) {
			System.out.println("\nYou do not have any territory.");
		}
		else {
			System.out.println("\nYour territory(ies) :");
		
			this.displayTerritories(currentPlayer);
			
		}
	}
	
	/**
	 * to get the initial situation of the players when the game starts
	 */
	public void getInitialSituation() {
		System.out.println("\n\n _____________________________________________________________");
		System.out.println("|                                                             |");
		System.out.println("| The game starts, it will last 10 turns                      |");
		System.out.println("| Each player has 35 soldiers in stock and 10 unities of food |");
		System.out.println("| The players no have gold                                    |");
		System.out.println("|_____________________________________________________________|");
		
		System.out.println("\nThe board is : \n");
		this.getBoard().displayBoard();
		
	}

	/**
     * to display the rules of a victory
     */
	public void rulesOfVictory() {
		System.out.println("\n ______________________________________________________");
		System.out.println("|                                                     |");
		System.out.println("| The points are calculated with :                    |");
		System.out.println("| - 1 point per gold of the player                    |");
		System.out.println("| - 1 point per gold of the armies                    |");
		System.out.println("| - 4 points for a mountain or a desert own           |");
		System.out.println("| - 2 points for a forest own                         |");
		System.out.println("| - 1 point for a grassland own                       |");
		System.out.println("| - 5 bonus points if you have 10 territories or more |");
		System.out.println("|_____________________________________________________|");
	}
	
	/**
	 * to display when the player maintain his army(ies)
	 * @param npc the npc to maintain 
	 */
	@Override
	public void displayMaintain(NPC npc) {
		System.out.println("\nYou have fed " + npc.toString() + " at the tile " + npc.getPosition().toString() + " with " + npc.getPosition().getCost()*npc.getSize() + " units of food");
		
	}
	
	/**
     * to give to the player the resources which correspond to his territories 
     * @param player the current player 
	 * @throws Exception for the method dealAction()
     */
    public void collectResources(Player player) throws Exception {
    	int i;
    	for (TileExceptOcean tile : player.getTerritories()) {
    		i = 0;
    		while(i < tile.getNpc().getSize()) {
    			player.addResources(tile.getResources());
    			i ++;
    		}
    	}
    	System.out.println("\nYour npc have collected :");
    	this.displayResources(player);
    	
    	this.convertInFood(player);
    }

 
}
