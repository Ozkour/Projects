package game.games;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import game.Game;
import game.GameTest;
import game.Resources;
import game.actions.DeployFarmer;
import game.actions.ExchangesResourcesFarm;
import game.actions.SkipYourTurnFarm;
import game.boards.BasicBoardTest;
import game.character.Farmer;
import game.resource.Wheat;
import game.tile.*;
import game.util.BusyTileException;
import game.util.NotEnoughGoldException;
import game.util.NotEnoughStockException;
import game.util.Position;
import game.util.TooMuchSoldierException;

public class FarmGameTest extends GameTest {
	
	protected TileExceptOcean tile;
	protected TileExceptOcean tile2;
	protected TileExceptOcean tile3;
	protected Farmer farmer;
	protected Farmer farmer2;
	protected Farmer farmer3;
	
	@Override
	protected Game createGame() {
		return new FarmGame(this.farmBoard);
	}

	
	@Before
	public void before() throws BusyTileException {
		
		this.game.addPlayer(this.player3);
		this.game.addPlayer(this.player4);
		
		this.tile = (TileExceptOcean) this.game.getBoard().getTile(new Position(2,3));
		this.tile2 = (TileExceptOcean) this.game.getBoard().getTile(new Position(2,4));
		this.tile3 = (TileExceptOcean) this.game.getBoard().getTile(new Position(6,7));
    	
		this.farmer = new Farmer(this.tile, this.player3);
		this.farmer2 = new Farmer(this.tile2, this.player3);
		this.farmer3 = new Farmer(this.tile3, this.player4);
    	
		this.tile.addNpc(this.farmer);
		this.tile2.addNpc(this.farmer2);
		this.tile3.addNpc(this.farmer3);
    	
    	this.player3.addTerritory(this.tile);
    	this.player3.addTerritory(this.tile2);
    	this.player4.addTerritory(this.tile3);
    	
	}
	
	@Test
	public void farmGameIsWellConstructedTest() {
		assertEquals(this.farmBoard, this.game.getBoard());
		assertEquals(6, this.game.getNbTurns());
		assertEquals(2, this.game.getPlayers().size());
	}
	
	@Test
	public void containsTheGoodActionsTest() {
		
		assertEquals(new DeployFarmer(), this.game.getActions().get(0));
		assertEquals(new SkipYourTurnFarm(), this.game.getActions().get(1));
		assertEquals(new ExchangesResourcesFarm(), this.game.getActions().get(2));
	}
	
    @Test 
    public void setNbturnsTest() {
    	this.game.setNbturns();
    	assertEquals(5, this.game.getNbTurns());
    }
	
	
	@Test 
	public void collectedResourcesTest() throws Exception {

		List<Resources> resources = new ArrayList<>(); 
		resources.add(new Wheat(2));
		
		this.game.collectResources(this.player4);
		
		assertEquals(resources.get(0), this.player4.getResources().get(0));
		assertEquals(1, this.player4.getResources().size());
	}
	
	
	@Test
	public void getScoresTest() throws BusyTileException {
    	
    	List<Integer> scores = new ArrayList<>();
    	scores.add(2);
    	scores.add(1);
 
    	this.farmer.addGold(1);
    	this.farmer2.addGold(1);
    	this.farmer3.addGold(1);
    	
    	assertEquals(scores, this.game.getScores());
    	
		
	}
	
	@Test
	public void getStockTest() {
		
		assertEquals(15, this.game.getStock(this.player3));
	}
	
	
	@Test
	public void canSurviveTest() throws BusyTileException, NotEnoughGoldException {
		
		assertTrue(this.game.canSurvive(this.farmer, this.player3));
		
		this.player3.removeGold(14);
		
		assertFalse(this.game.canSurvive(this.farmer, this.player3));
		
	}
	
	@Test
	public void maintainFarmersTest() throws Exception {
    	
    	this.game.maintain(this.farmer3, this.player4);
    	
    	assertEquals(1, this.farmer3.getGold());
    	assertEquals(14, this.player4.getGold());
	}
	
	
	@Test (expected = NotEnoughGoldException.class)
	public void maintainWhenYouDontHaveEnoughMoneyTest() throws NotEnoughStockException, Exception {
		
		this.player4.removeGold(15);
    	this.game.maintain(this.farmer3, this.player4);
	}
	
	
    @Test 
    public void allTerritoriesConqueredTest() throws TooMuchSoldierException, BusyTileException {
    	assertTrue(this.game.allTerritoriesConquered());
    	
    	this.player3.removeTerritory(this.tile2);
    	this.tile2.suppNpc();
    	
    	assertFalse(this.game.allTerritoriesConquered());
    	
    }
	

    @Test 
    public void collectResourcesTest() throws Exception {
    	this.game.addPlayer(this.player3);
    	this.player3.addTerritory(tile);
    	this.player3.addTerritory(tile2);

    	this.game.collectResources(this.player3);
    	
    	assertEquals(tile.getResources(), this.player3.getResources().get(0));
    	assertEquals(tile2.getResources(), this.player3.getResources().get(1));
    }
    
    @Test 
    public void playTestEndsAfterNbTurns() throws Exception {
    	BasicBoardTest.BoardForTest farmboard = new BasicBoardTest.BoardForTest(8, 8, farmFact);
    	FarmGame farmgame = new FarmGame(farmboard);
    	farmgame.play();
    	assertEquals(0, farmgame.getNbTurns());
    }
    
}
