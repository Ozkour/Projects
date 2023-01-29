package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TeleportCellTest{

    TeleportCell cell;

    @Before
    public void before(){
        this.cell = new TeleportCell(3,22);
    }

    @Test
    public void destIsWellDefined(){
        assertEquals(22,cell.getDest());
    }

    @Test
    public void weAreTeleported(){
        assertEquals(22,cell.bounce(125));
    }


       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.cells.TeleportCellTest.class);
 }
}