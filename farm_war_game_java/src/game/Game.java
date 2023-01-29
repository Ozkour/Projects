package game;

import java.util.*;
import game.util.*;
import game.util.NotEnoughStockException;
import game.tile.TileExceptOcean;

/**
 * A general game with the commun rules of the different games.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 03/03/2021
 */

public abstract class Game {
	
	protected List<Action> theActions; // list of all the actions of the game

	protected int nbTurns;  //the number of turns 
	
	protected List<Player> thePlayers; // the list of the players
	
	protected Board board; // the board of the game
	

	
	
	/**
	*the constructor of Game
	*@param board the board of the game
	*/
	protected Game(Board board){
	    this.nbTurns = 10;
	    this.board = board;
	    this.thePlayers = new ArrayList<>();
	    this.theActions = new ArrayList<>();
	} 
	
	/**
	*to get the number of turns 
	*@return the number of turns
	*/
	public int getNbTurns(){
	    return this.nbTurns;
	}
	
	/**
	 * to get the actions
	 * @return the list of the actions
	 */
	public List<Action> getActions() {
		return this.theActions;
	}
	
	
	/**
	* to get the list of the players
	* @return the list of the players
	*/
	public List<Player> getPlayers(){
	    return this.thePlayers;
	}
	
	/**
	* to get the board
	* @return the board
	*/
	public Board getBoard(){
	    return this.board;
	}
	
	/**
	* to add a player to the game
	* @param player the new player
	*/
	public void addPlayer(Player player){
	    this.getPlayers().add(player);
	}
	
	/**
	 * to set the number of turns
	 */
	public void setNbturns() {
		this.nbTurns = this.nbTurns - 1;
	}
	
	
    /**
     * to play a party of this game 
     * @throws Exception for the method playOneRound()
     */
	public void play() throws Exception { 
		
		this.getInitialSituation();
		
		while ((!this.allTerritoriesConquered()) && (this.getNbTurns() > 0) ) {
			this.playOneRound();
			this.setNbturns();
			System.out.println("\n\n\n################");
			System.out.println("Turn(s) left : " + this.getNbTurns());
			System.out.println("################");
		}
		List<Player> theWinners = this.determineTheWinner(this.getScores());
		this.displayWinner(theWinners);
	}
	
	/**
	* to know if all the territories are conquered by npcs
	* @return true if all the territories are occupied and false otherwise
	*/
	public boolean allTerritoriesConquered() {
	    for(int i = 0; i < board.getWidth(); i ++) {
	        for(int j = 0; j < board.getHeight(); j ++) {
	        	Position pos = new Position(i, j);
	            if (board.getTile(pos).isWalking() && !(board.getTile(pos).isBusy())) {
	                    return false;
	            }
	        }
	    }
	    return true;
	}

	/**
	 * to play a round of a game
	 * @throws Exception for the methods dealAction(), chooseTheAction(), suppNpc()
	 */
	protected void playOneRound() throws Exception {
		for ( Player currentPlayer : this.getPlayers()) {
			System.out.println("\n______________________________________________________________");
			System.out.println("\nIT'S THE TURN OF : " + currentPlayer.getName().toUpperCase() + "\n");
			
			this.getBoard().displayBoard(); // to display the board 
			
			Action theAction = currentPlayer.getStrategy().chooseTheAction(); // to choose an action
			System.out.println("You chose the action of " + theAction.getName());
			
			theAction.dealAction(currentPlayer, this);
			
			System.out.println("______________________________________________________________");
			this.collectResources(currentPlayer); // to collect the resources
			System.out.println("______________________________________________________________");
			
			if(currentPlayer.getTerritories().isEmpty()) {
				System.out.println("\nYou do not have any npc so you do not have to maintain them.");
			}
			else {
				for (int i = 0; i < currentPlayer.getTerritories().size(); i ++) {
					try {
						this.maintain(currentPlayer.getTerritories().get(i).getNpc(), currentPlayer); // to maintain the npc 
						this.displayMaintain(currentPlayer.getTerritories().get(i).getNpc());
					}
					catch (NotEnoughStockException e){
					}
				}
			}
			System.out.println("______________________________________________________________");
			System.out.println("\nRound report :");
			this.getReport(currentPlayer);
		}
	}

	/**
	* to maintain the npc
	* @param npc the npc to maintain 
	* @param currentPlayer the current player
	* @throws NotEnoughStockException if the player doesn't have enough resources
	* @throws Exception for the action of exchange 
	*/
	public abstract void maintain(NPC npc, Player currentPlayer) throws NotEnoughStockException, Exception;

	
	/**
	 * to determine the winner(s) of the game
	 * @param thePoints a list of all the scores
	 * @return a list of the winner(s) of the game
	 */
	public List<Player> determineTheWinner(List<Integer> thePoints) {
		List<Player> theWinners = new ArrayList<>();
		int max = 0;
		for(int i = 0; i < thePoints.size(); i ++) {
			if (thePoints.get(i) > max) {
				max = thePoints.get(i);				
			}
		}
		for(int i = 0; i < thePoints.size(); i ++) {
			if (thePoints.get(i) == max) {
				theWinners.add(this.getPlayers().get(i));
			}
		}
		return theWinners;
	}
	
	
	/**
     * to give to the player the resources which correspond to his territories 
     * @param player the current player 
	 * @throws Exception for the method dealAction()
     */
    public void collectResources(Player player) throws Exception{
    	int i;
    	for (TileExceptOcean tile : player.getTerritories()) {
    		i = 0;
    		while(i < tile.getNpc().getSize()) {
    			player.addResources(tile.getResources());
    			i ++;
    		}
    	}
    	
    	System.out.println("Your npc have collected :");
    	this.displayResources(player);
    }
	
	/**
	* to know if the npc can survive if the player has enough food or gold to maintain him.
	* @param npc the npc
	* @param currentPlayer the current player
	* @return True if the npc can survive and false otherwise
	*/
	public boolean canSurvive(NPC npc, Player currentPlayer) {
		return ((npc.getPosition().getCost()*npc.getSize()) <= this.getStock(currentPlayer));
	}
	
	/**
	 * to get the stock of a player to maintain the npc
	 * @param currentPlayer the current player
	 * @return the stock of the player
	 */
	public abstract int getStock(Player currentPlayer);
	
	
	
	/**
	 * to calculate the points of the players
	 * @return a list of all scores  
	 */
	public abstract List<Integer> getScores();
		
	
	/**
	 * to get the report of the resources of the player 
	 * @param currentPlayer the current player
	 */
	public abstract void getReport(Player currentPlayer);
	
	
	/**
	 * display the winner
	 * @param winners the list of the winner(s) of the game
	 */
	public void displayWinner(List<Player> winners) {
		
		
		System.out.println("So the winner(s) is/are :\n");
		for (Player winner : winners) {
			System.out.println("	- " + winner.getName());
		}
		System.out.println("\nCONGRATULATIONS :p !!!");
	}
	
	/**
	 * to get the initial situation of the players when the game starts
	 */
	public abstract void getInitialSituation();
	
	
    /**
	 * to display the resources
	 * @param player the current player
	 */
    public void displayResources(Player player) {
    	
    	int cpt1 = 0;
    	int cpt2 = 0;
    	int cpt3 = 0;
    	int cpt4 = 0;
    		
    	for(Resources resource : player.getResources()) {
    		
    		if(resource.equals(this.getBoard().getFactory().buildSand())) {
    			cpt1 ++;
    		}
    		
    		else if (resource.equals(this.getBoard().getFactory().buildWood())) {
    			cpt2 ++;
    		}
    		
    		else if (resource.equals(this.getBoard().getFactory().buildWheat())) {
    			cpt3 ++;
    		}
    		
    		else if (resource.equals(this.getBoard().getFactory().buildRock())) {
    			cpt4 ++;
    		}
    	}
    	
    	System.out.println("	- " + cpt1 + " sand(s)");
    	System.out.println("	- " + cpt2 + " wood(s)");
    	System.out.println("	- " + cpt3 + " wheat(s)");
    	System.out.println("	- " + cpt4 + " rock(s)");
    }
    
    
	/**
	 * to display the territory of a player 
	 * @param player the player
	 */
    public void displayTerritories(Player player) {
    	
		for(TileExceptOcean territory : player.getTerritories()) {
			System.out.println("	- " + territory.toString() + " with " + territory.getNpc().toString());
		}
    }
    
    /**
     * to display the rules of a victory
     */
    public abstract void rulesOfVictory();
    
    /**
     * to display when a player maintains his npc
     * @param npc the maintained npc
     */
    public abstract void displayMaintain(NPC npc);

}
