package goosegame.cells;
import goosegame.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class WaitingCellTest{
    
    private WaitingCell cell;

    @Before
    public void before(){
        this.cell = new WaitingCell(18,3);
    }

    @Test
    public void cellIsWellCreated(){
        assertEquals(3,cell.getWaitingTime());
        assertEquals(3,cell.getCpt());
    }

    @Test
    public void playerCanPlayOnlyIfCptNegative(){
        assertFalse(cell.canPlay());
        cell.canPlay();
        cell.canPlay();
        cell.canPlay();
        boolean b = cell.canPlay();
        assertTrue(b);
    }

    @Test
    public void cptIsBackToInitValueIfPlayerCome(){
        cell.canPlay();
        assertEquals(2,cell.getCpt());
        Player p = new Player("Kimberley",cell);
        cell.setPlayer(p);
        assertEquals(3,cell.getCpt());
    }

       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.cells.WaitingCellTest.class);
 }
}