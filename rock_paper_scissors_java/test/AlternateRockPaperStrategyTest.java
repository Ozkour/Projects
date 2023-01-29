import org.junit.*;
import static org.junit.Assert.*;

import pfc.*;
import pfc.strategy.*;

public class AlternateRockPaperStrategyTest{

    @Test
    public void chooseTest(){
        Strategy strat= new AlternateRockPaperStrategy();
        Choice choice1=strat.choose();
        Choice choice2=strat.choose();
        assertSame(Choice.ROCK,choice1);
        assertSame(Choice.PAPER,choice2);
    }

// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(AlternateRockPaperStrategyTest.class);
}
}
