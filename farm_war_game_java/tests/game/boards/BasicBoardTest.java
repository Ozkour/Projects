package game.boards;

import game.*;
import game.tile.Ocean;
import game.util.Position;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;  

public class BasicBoardTest extends BoardTest {

	
    /**
     * A board to do the tests.
     * The tiles' positions on this board are chosen.
     * 
     * @author Jeanne Lauwers & Gaelle Fret & Nicolas Kerman & Mina Crapez
     * @version 26/03/2021
     */
    public static class BoardForTest extends BasicBoard {

    	/**
    	 * The constructor
    	 * @param height the height of the board
    	 * @param width the width of the board
    	 * @param factory the factory of the board depending on the type of game
    	 */
    	public BoardForTest(int height, int width, Factory factory) {
    		super(height, width, factory);
    	}

    	/**
    	 * To initialize the board
    	 */
    	@Override
    	public void initBoard() {
    		for(int i = 0; i < this.getWidth(); i ++){
                for(int j = 0; j < this.getHeight(); j ++){
                    this.theTiles[i][j] = new Ocean(new Position(i, j));
                }
            }
    		this.theTiles[2][3] = this.getFactory().buildDesert(new Position(2, 3));
    		this.theTiles[2][4] = this.getFactory().buildDesert(new Position(2, 4));
    		this.theTiles[6][7] = this.getFactory().buildGrassland(new Position(6, 7));
    	}
    	
    }
    
	

	protected BoardForTest createBoard() {
		return new BoardForTest(25, 50, factory);
	}
	
	
	@Test
    public void theBoardIsWellConstructedTest() {
    	assertEquals(25, board.getHeight());
    	assertEquals(50, board.getWidth());
    	
    	int lengthOfTheBoard = 25 * 50;
    	assertEquals(lengthOfTheBoard, board.getSize());
    	assertEquals(factory, board.getFactory());
    }
    

	@Test
    public void theSizeOfTheBoardIsTheGoodOneTest() {
    	int lengthOfTheBoard = 25*50;
    	assertEquals(lengthOfTheBoard, board.getSize());
    }
	
    
    @Test
    public void tileIsWellGetBackTest() {
    	assertSame(board.getArrayTile()[2][3], board.getTile(this.pos));
    }
    
    @Test 
    public void getTileAroundTest() {
    	List<Position> listOfPositions = new ArrayList<>();
    	listOfPositions.add(new Position(3,3));
    	listOfPositions.add(new Position(2,4));
    	listOfPositions.add(new Position(1,3));
    	listOfPositions.add(new Position(2,2));
    	
    	assertEquals(listOfPositions, this.board.getTileAround(this.pos));
    }
    
    @Test 
    public void isAloneTest() {
    	assertFalse(this.board.isAlone(this.pos));
    	assertTrue(this.board.isAlone(new Position(6,7)));
    }
    

}
