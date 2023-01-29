package goosegame;
import goosegame.cells.*;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest{
Player player1;
Cell cell;

@Before
public void before(){
    this.cell = new NormalCell(2);
    this.player1 = new Player("Britney",cell);
}

@Test
public void aPlayerHasBeenCreatedSuccessfuly(){
    assertSame(cell,player1.getCell());
    assertEquals("Britney", player1.toString());        
}

@Test
public void WeCanModifyTheCellWhereAPlayerIs(){
    Cell cell2 = new NormalCell(3);
    assertSame(cell,player1.getCell());
    player1.setCell(cell2);
    assertSame(cell2,player1.getCell());
}


       // ---Pour permettre l'execution des tests ----------------------
   public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.PlayerTest.class);
 }

}