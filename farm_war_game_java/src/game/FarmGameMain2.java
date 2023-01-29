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

public class FarmGameMain2 extends FarmGameMain{
	
	/**
	 * to choose a strategy between a random strategy and a human strategy
	 * @return the strategy chosen
	 * @throws IOException if the input is not correct
	 */
	public static Strategy getStrategy(Game game) throws IOException {

       
        System.out.println("Which strategy is used ?");
		System.out.println("1 - Human Strategy ");
		System.out.println("2 - Random Strategy ");
		
		
		int choice = 0;
		try {
			choice = Input.readInt();
		}
		catch(IOException e) {
			System.out.println("You have to put a number between 1 & 2");
			return FarmGameMain2.getStrategy(game);
		}
		
		if (choice == 1) {
			return new HumanStrategyFarm(game);
		}
		else if (choice == 2) {
			return new RandomStrategyFarm(game);
		}
		else {
			System.out.println("You have to put a number between 1 & 2");
			return FarmGameMain2.getStrategy(game);
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
        Strategy strat = FarmGameMain2.getStrategy(game);
        
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