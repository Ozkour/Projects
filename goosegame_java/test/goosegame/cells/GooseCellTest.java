package goosegame.cells;

import static org.junit.Assert.*;

import org.junit.Test;

public class GooseCellTest{
    @Test
    public void youBounceIfYouAreOnAGooseCell(){
        GooseCell cell = new GooseCell(15);
        assertEquals(18,cell.bounce(3));
    }

       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.cells.GooseCellTest.class);
 }
}