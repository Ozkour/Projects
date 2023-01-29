import org.junit.*;
import static org.junit.Assert.*;

import pfc.strategy.*;
import pfc.*;


public class PlayerTest {



    @Test 
    public void ourChoiceIsTheSameAsInTheMethodeChoose(){
        Strategy strat = new PaperStrategy();
        Player people = new Player("people",strat);
        Choice strat2 = people.choose();
        assertEquals(Choice.PAPER,strat2);
    }

    @Test 
    public void canWeAddTheCorrectNumberOfPoints(){
        Strategy strat = new PaperStrategy();
        Player people = new Player("people",strat);
        people.addPoints(2);
        assertEquals(2,people.getPoints());
    }

    @Test 
    public void weObtainTheGoodNumberOfPoints(){
        Strategy strat = new PaperStrategy();
        Player people = new Player("people",strat);
        assertEquals(0,people.getPoints());
    }

    @Test 
    public void weObtainTheGoodName(){
        Strategy strat = new PaperStrategy();
        Player people = new Player("people",strat);
        assertEquals("people",people.getName());
    }
    
  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
}

}