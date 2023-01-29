import org.junit.*;
import static org.junit.Assert.*;

import pfc.*;


public class ChoiceTest {


    public void choicesHaveBeenCompared(){
        assertEquals(0,Choice.ROCK.compare(Choice.ROCK));
        assertEquals(1,Choice.ROCK.compare(Choice.SCISSORS));
        assertEquals(-1,Choice.ROCK.compare(Choice.PAPER));
    }


  // ---Pour permettre l'exécution des test----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(PaperStrategyTest.class);
}

}
