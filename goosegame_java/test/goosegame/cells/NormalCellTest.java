package goosegame.cells;
import goosegame.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NormalCellTest{

    Cell cell;
    Player p;

    @Before
    public void before(){
        this.cell = new NormalCell(2);
        this.p = new Player("Jason",cell);
    }

    @Test
    public void playerCanAlwaysplay(){
        assertTrue(cell.canPlay());
    }

    @Test
    public void indexIsTheRightIndex(){
        assertEquals(2,cell.getIndex());
    }

    @Test
    public void noBounceOnNormalCell(){
        assertEquals(2,cell.bounce(5));
    }

    @Test
    public void weCanAddAPlayer(){
        cell.setPlayer(p);
        assertSame(p,cell.getPlayer());
    }

    @Test
    public void playerIsAlreadyOnTheCell(){
        cell.setPlayer(p);
        assertTrue(cell.isBusy());
    }

    @Test
    public void noPlayerOnTheCell(){
        assertFalse(cell.isBusy());
    }



       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.cells.NormalCellTest.class);
 }
}