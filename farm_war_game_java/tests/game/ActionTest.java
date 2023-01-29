package game;

import org.junit.Before;

import game.boards.BasicBoardTest;
import game.factory.FarmFactory;
import game.factory.WarFactory;
import game.games.FarmGame;
import game.games.WarGame;
import game.players.FarmPlayer;
import game.players.WarPlayer;

public abstract class ActionTest {
	
	protected Action action;
	
	protected FarmGame farmgame; 
	protected WarGame wargame;
	
	protected FarmFactory farmfactory;
	protected WarFactory warfactory;
	protected BasicBoardTest.BoardForTest warboard;
	protected BasicBoardTest.BoardForTest farmboard;
	
	
	protected StrategyTest.StrategyForTest strat1;
	protected StrategyTest.StrategyForTest strat2;
	protected FarmPlayer farmplayer;
	protected WarPlayer warplayer;
	 
	
	@Before
	public void Before() {
		this.action = createAction();
		
		this.farmfactory = new FarmFactory();
		this.warfactory = new WarFactory();
		
		this.farmboard = new BasicBoardTest.BoardForTest(8, 8, this.farmfactory);
		this.warboard = new BasicBoardTest.BoardForTest(8, 8, this.warfactory);
		
		this.farmgame = new FarmGame(this.farmboard);
		this.wargame = new WarGame(this.warboard);
		
		this.strat1 = new StrategyTest.StrategyForTest(this.wargame);
		this.strat2 = new StrategyTest.StrategyForTest(this.farmgame);
		this.farmplayer = new FarmPlayer("Gaelle", strat2);
		this.warplayer = new WarPlayer("Jeanne", strat1);
		
	}


	protected abstract Action createAction();
	
	

	
}