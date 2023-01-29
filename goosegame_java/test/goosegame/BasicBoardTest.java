package goosegame;
import goosegame.cells.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BasicBoardTest{
    
    BasicBoard board;

    @Before
    public void before(){
        this.board = new BasicBoard();
    }

    @Test
    public void differentCellsAreWellDefined(){
        Cell cell = new NormalCell(2);
        TrapCell cell2 = new TrapCell(31);
        WaitingCell cell3 = new WaitingCell(19,2);
        TeleportCell cell4 = new TeleportCell(6,12);
        assertEquals(cell,this.board.getCell(2));
        assertEquals(cell2,this.board.getCell(31));
        assertEquals(cell3,this.board.getCell(19));
        assertEquals(cell4,this.board.getCell(6));
    }

    @Test
    public void TheLengthOfTheBoardIsCorrect(){
        assertEquals(63,board.getNbOfCells());
    }

       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.BasicBoardTest.class);
 }
}