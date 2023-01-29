import org.junit.*;
import static org.junit.Assert.*;

import pfc.strategy.*;
import pfc.*;

public class PaperStrategyTest {

    @Test 
    public void ourChoiceIsAlwaysPaper(){
        Strategy strat= new PaperStrategy();
        assertEquals(Choice.PAPER,strat.choose());
    }





  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(PaperStrategyTest.class);
}

}
