package goosegame.cells;
import goosegame.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FirstCellTest{

    private Cell depart;
    
    @Before
    public void before(){
        this.depart=new FirstCell();
    }

    @Test
    public void playerCanAlwaysplay(){
        assertTrue(depart.canPlay());
    }

    @Test
    public void indexIsAlwaysZero(){
        assertEquals(0,depart.getIndex());
    }

    @Test
    public void noBounceOnFirstCell(){
        assertEquals(0,depart.bounce(5));
    }


    @Test
    public void severalPlayersCanBeOnFirstCell(){
        Player p = new Player("Robert",depart);
        depart.setPlayer(p);
        assertFalse(depart.isBusy());
    }

       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.cells.FirstCellTest.class);
 }
}