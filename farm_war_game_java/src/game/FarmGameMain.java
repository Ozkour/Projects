package game;

import java.io.IOException;
import game.boards.BasicBoard;
import game.factory.*;
import game.games.*;
import game.players.FarmPlayer;
import game.strategy.HumanStrategyFarm;
import game.strategy.RandomStrategyFarm;
import game.util.io.Input;

/** 
 * The main to play a party of the farm game.
 * 
 * @author Gaelle Fret and Jeanne Lauwers and Nicolas Kerman and Mina Crapez
 * @version 18/04/2021
 */

public class FarmGameMain{
	
	/**
	 * to get the number of players for the game 
	 * @return the number of players
	 * @throws IOException if the input is not correct 
	 */
	public static int getNumberOfPlayers() throws IOException {
		
        System.out.println("How many players do we have ?");
        
        int nbPlayer = 0;
        try {
        	nbPlayer = Input.readInt();
        }
        catch(IOException e) {
			System.out.println("You have to put a number");
			return FarmGameMain.getNumberOfPlayers();
		}
        return nbPlayer;
	}
	
	/**
	 * to add players to the game
	 * @param strat the strategy of the players created
	 * @param game the game in which we want to add the players
	 * @throws IOException if the input is not correct 
	 */
	public static void addThePlayers(Strategy strat,Game game) throws IOException {
		int nbPlayer = getNumberOfPlayers();
		for(int i = 1; i <= nbPlayer; i ++) {
			
			System.out.println("What's the name of the player number "+ i +" ?");
			String name = Input.readString();
			Player player = new FarmPlayer(name, strat);
			game.addPlayer(player);
    	}
	}
	
	
    /**
     * the main to play the war game
     * @param args an array of arguments
     * @throws Exception for the methods getStrategy() and play()
     */
    public static void main(String[] args) throws Exception {
		Factory factory = new FarmFactory();
		
		Board board = new BasicBoard(10, 10, factory);
		
		Game game = new FarmGame(board);
		
        Strategy strat = new RandomStrategyFarm(game);
        
        if(args.length==0) {
        	System.out.println("You didn't put any player's name");
        	addThePlayers(strat,game);
        }
        for(int i = 0; i < args.length; i ++) {
            Player player = new FarmPlayer(args[i], strat);
            game.addPlayer(player);
        }
      
        game.play();    
    }
}