package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrapCellTest{

    @Test
    public void playerCanNeverPlay(){
        TrapCell cell = new TrapCell(18);
        assertFalse(cell.canPlay());
    }


       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.cells.TrapCellTest.class);
 }

}