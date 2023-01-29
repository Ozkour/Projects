package game;



import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import game.boards.*;
import game.factory.*;
import game.players.*;
import game.strategy.*;


public abstract class GameTest{

    protected int nbTurns;
    
    protected BasicBoardTest.BoardForTest warBoard;
    protected BasicBoardTest.BoardForTest farmBoard;
    
    protected Factory warFact;
    protected Factory farmFact;
    
    protected List<Action> actions;
    protected Game game;
    
    protected WarPlayer player1;
    protected WarPlayer player2;
    protected Player player3;
    protected Player player4;
    

    @Before
    public void Before() throws Exception {
        this.player1 = new WarPlayer("Danny",new RandomStrategyWar(this.game));
        this.player2 = new WarPlayer("Kimberley",new RandomStrategyWar(this.game));
        this.player3 = new FarmPlayer("Brenda",new RandomStrategyFarm(this.game));
        this.player4 = new FarmPlayer("Clitorine",new RandomStrategyFarm(this.game));
        
        this.warFact = new WarFactory();
        this.farmFact = new FarmFactory();
        
        this.warBoard = new BasicBoardTest.BoardForTest(8, 8, warFact);
        this.farmBoard = new BasicBoardTest.BoardForTest(8, 8, farmFact);
        
        this.game = createGame();
        
    }
    
    /**
     * to create a type of game 
     * @return the game created
     */
    protected abstract Game createGame();
    
    
    @Test
    public void addPlayerTest() {
    	this.game.addPlayer(this.player3);
    	this.game.addPlayer(this.player4);
    	assertEquals(this.player3, this.game.getPlayers().get(0));
    	assertEquals(this.player4, this.game.getPlayers().get(1));
    }
    
    @Test 
    public void setNbturnsTest() {
    	assertEquals(10,this.game.getNbTurns());
    	this.game.setNbturns();
    	assertEquals(9, this.game.getNbTurns());
    }
    

    
    @Test
    public void determineTheWinnerTest() {
    	
    	List<Integer> scores = new ArrayList<>();
    	scores.add(5);
    	scores.add(7);
    	List<Player> winner = new ArrayList<>();
    	winner.add(this.player4);
    	
    	this.game.addPlayer(this.player3);
    	this.game.addPlayer(this.player4);
   
    	assertEquals(winner, this.game.determineTheWinner(scores));
    }
    
    @Test
    public void determineTheWinnerWhenEqualityTest() {
    	
    	List<Integer> scores = new ArrayList<>();
    	scores.add(7);
    	scores.add(7);
    	
    	List<Player> winners = new ArrayList<>();
    	winners.add(this.player3);
    	winners.add(this.player4);
    	
    	this.game.addPlayer(this.player3);
    	this.game.addPlayer(this.player4);
    	
    	assertEquals(winners, this.game.determineTheWinner(scores));
    }   
    
    @Test
    public void playTestEndsWhenAllConquered() throws Exception {
    	this.game.play();
    	// if the test pass, the terminal display the winners, here the 2 players.
    }
    
    

    
}


