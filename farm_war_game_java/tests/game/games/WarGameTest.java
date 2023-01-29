package game.games;

import static org.junit.Assert.*;

import java.util.*;

import game.*;
import game.actions.*;
import game.players.*;
import game.tile.*;
import game.character.*;
import game.factory.WarFactory;
import game.util.*;

import org.junit.Test;
import org.junit.Before;

public class WarGameTest extends GameTest{

	protected TileExceptOcean tile1;
	protected TileExceptOcean tile2;
	protected TileExceptOcean tile3;
	protected Army army1;
	protected Army army2;
	protected Army army3;
	protected Position position1;
	protected Position position2;
	protected Position position3;

	protected WarGame createGame() {
		return new WarGame(this.warBoard);
	}
	
	@Before
	public void before() throws Exception {
		
		this.position1 = new Position(2,3);
		this.position2 = new Position(2,4);
		this.position3 = new Position(6,7);
		
		this.tile1 = (TileExceptOcean) this.warBoard.getTile(position1);
		this.tile2 = (TileExceptOcean) this.warBoard.getTile(position2);
		this.tile3 = (TileExceptOcean) this.game.getBoard().getTile(position3);
		
		this.army1 = new Army(this.tile1, player1, 2);
		this.army2 = new Army(this.tile2, player2, 3);
		
		this.tile1.addNpc(army1);
		this.tile2.addNpc(army2);
		
		this.player1.addTerritory(this.tile1);

	}
	
	@Test
	public void weCanGiveTheDeathMoneyToThePlayerTest() {
		((WarGame) this.game).deathMoney(this.player1);
		
		assertEquals(1, this.player1.getGold());
	}
	
	@Test
	public void characterCanSurviveTest() throws TooMuchSoldierException{
		((WarPlayer) this.player1).addFood(5);
		army1.deployment(tile1);
		
		assertTrue(((WarGame) this.game).canSurvive(army1, player1));
	}
	
	@Test
	public void characterCantSurviveTest() throws TooMuchSoldierException, NotEnoughFoodException {
		((WarPlayer) this.player1).removeFood(10);
		army1.deployment(tile1);
		
		assertFalse(((WarGame) this.game).canSurvive(army1, player1));
	}
	
	
	@Test
	public void armiesAreAdjacentTest() throws TooMuchSoldierException {
		army1.deployment(tile1);
		army2.deployment(tile2);
		
		assertEquals(1, ((WarGame) this.game).adjacentArmies(tile1).size());
		assertSame(army2, ((WarGame) this.game).adjacentArmies(tile1).get(0));
	}
	
    @Test 
    public void collectResourcesTest() throws Exception {
    	this.player1.addTerritory(tile1);
    	this.player1.addTerritory(tile2);

    	this.game.collectResources(this.player1);
    	
    	assertEquals(10, this.player1.getFoodStock());
    }
    
    
    @Test
    public void listOfActionsIsWellDefinedTest() {
    	assertEquals(2,this.game.getActions().size());
    	assertTrue(this.game.getActions().contains(new DeployArmy()));
    	assertTrue(this.game.getActions().contains(new SkipYourTurnWar()));
    }
	
    @Test
    public void weCanAddPlayersTest() {
    	assertEquals(0, this.game.getPlayers().size());
    	
    	this.game.addPlayer(this.player1);
    	
    	assertEquals(1, this.game.getPlayers().size());
    	assertTrue(this.game.getPlayers().contains(this.player1));
    }
    
    @Test
    public void weCanGetTheBoardTest() {
    	assertSame(this.warBoard, this.game.getBoard());
    }
    
    @Test
    public void allTerritoriesConqueredTest() throws TooMuchSoldierException, BusyTileException {
    	assertFalse(this.game.allTerritoriesConquered());
    	
    	this.army3 = new Army(this.tile3, player2, 3);
    	this.tile3.addNpc(this.army3);
    	
    	assertTrue(this.game.allTerritoriesConquered());
    }
	
    @Test
    public void weCanMaintainTheFarmerTest() throws Exception {
    	this.game.maintain(this.army1, this.player1);
    	
    	assertEquals(6, ((WarPlayer) this.player1).getFoodStock());
    }
    
    @Test (expected = NotEnoughFoodException.class)
    public void weCantMaintainTheFarmerTest() throws Exception {
    	
    	((WarPlayer) this.player1).removeFood(9);
    	this.game.maintain(this.army1, this.player1);
    }
    
    @Test
    public void weWellHaveTheScoresTest() throws BusyTileException, TooMuchSoldierException {
    	this.game.addPlayer(this.player1);
    	List<Integer> scores = this.game.getScores();
    	
    	assertEquals(1,scores.size());
    	assertTrue(scores.contains(4));
    	
    	TileExceptOcean tile = new Grassland(new Position(0,0),new WarFactory());
    	tile.addNpc(new Army(tile, this.player1, 1));
    	
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	this.player1.addTerritory(tile);
    	
    	scores = this.game.getScores();
    	
    	assertEquals(1, scores.size());
    	assertTrue(scores.contains(18));
    }
    
    @Test
    public void anArmyIsAnAllyOrNotTest() {
    	assertTrue(((WarGame) this.game).isAlly(this.army1, this.player1));
    	assertFalse(((WarGame) this.game).isAlly(this.army2, this.player1));
    }
    
    @Test
    public void aFightIsWellDoneTest() throws TooMuchSoldierException {
    	WarGame wargame = (WarGame) this.game;
    	wargame.fight(this.army1, this.army2);
    	
    	assertEquals(1, this.army2.getSize());
    	assertEquals(2, this.army1.getSize());
    	
    	wargame.fight(this.army1, this.army2);
    	
    	assertEquals(this.army2.getPosition(), this.player1.getTerritories().get(1));
    	assertEquals(1, this.army2.getSize());
    	assertEquals(this.player1, this.army2.getPlayer());
    	assertEquals(2, this.army1.getGold());
    }
    
    @Test 
    public void playTestEndsAfterNbTurns() throws Exception {
    	
    	this.game.play();
    	assertEquals(0, this.game.getNbTurns());
    }
    
}
