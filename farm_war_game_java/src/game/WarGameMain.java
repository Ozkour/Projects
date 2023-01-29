package game;

import java.io.IOException;
import game.boards.BasicBoard;
import game.factory.*;
import game.games.*;
import game.players.WarPlayer;
import game.strategy.HumanStrategyWar;
import game.strategy.RandomStrategyWar;
import game.util.io.Input;

/** 
 * The main to play a party of the war game.
 * 
 * @author Gaelle Fret and Jeanne Lauwers and Nicolas Kerman and Mina Crapez
 * @version 18/04/2021
 */

public class WarGameMain{
	/**
	 * to get the number of players for the game 
	 * @return the number of players
	 * @throws IOException if the input is not correct 
	 */
	public static int getNumberOfPlayers() throws IOException {
		
        System.out.println("How many Player do we have ?");
        
        int nbPlayer = 0;
        try {
        	nbPlayer = Input.readInt();
        }
        catch(IOException e) {
			System.out.println("You have to put a number");
			return WarGameMain.getNumberOfPlayers();
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
           Player player = new WarPlayer(name, strat);
           game.addPlayer(player);
       }
   }

   
   /**
    * the main to play the war game
    * @param args an array of arguments which represents the name of the players
    * @throws Exception for the methods getStrategy() and play()
    */
   public static void main(String[] args) throws Exception {
       Factory factory = new WarFactory();
		
	   Board board = new BasicBoard(10, 10, factory);
		
	   Game game = new WarGame(board);
	   
       Strategy strat = new RandomStrategyWar(game);
       
       if(args.length==0) {
           System.out.println("You didn't put any player's name");
           addThePlayers(strat,game);
       }
       for(int i = 0; i < args.length; i ++) {
           Player player = new WarPlayer(args[i], strat);
           game.addPlayer(player);
       }
     
       game.play();    
   }


	
}