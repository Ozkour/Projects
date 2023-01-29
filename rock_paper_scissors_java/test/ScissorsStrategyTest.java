import org.junit.*;
import static org.junit.Assert.*;

import pfc.strategy.*;
import pfc.*;

public class ScissorsStrategyTest {

    @Test 
    public void ourChoiceIsAlwaysScissors(){
        Strategy strat= new ScissorsStrategy();
        assertEquals(Choice.SCISSORS,strat.choose());
    }





  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(ScissorsStrategyTest.class);
}

}