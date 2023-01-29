package game; 

import org.junit.Before;


import game.factory.FarmFactory;
import game.util.Position;

public abstract class BoardTest {
	
	protected Board board;
	protected FarmFactory factory;
	protected Position pos;
	
	
    @Before
    public void Before(){
    	this.factory = new FarmFactory();
    	this.board = createBoard();
    	this.pos = new Position(2,3);
    }
    
    protected abstract Board createBoard();
    
    

    
}