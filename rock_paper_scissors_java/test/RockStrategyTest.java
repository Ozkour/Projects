import org.junit.*;
import static org.junit.Assert.*;

import pfc.strategy.*;
import pfc.*;

public class RockStrategyTest {

    @Test 
    public void ourChoiceIsAlwaysRock(){
        Strategy strat= new RockStrategy();
        assertEquals(Choice.ROCK,strat.choose());
    }





  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(RockStrategyTest.class);
}

}