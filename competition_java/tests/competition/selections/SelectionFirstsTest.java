package competition.selections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import competition.competitor.Competitor;

import java.util.List;

public class SelectionFirstsTest extends SelectionTest{
    
    @Test
    public void theFirstCompetitorsAreWellSelected(){
        //on fait une selection
        Selection sel = new SelectionFirsts(1);
        //on selectionne
        List<Competitor> res = sel.selected(this.pools);
        //on verifie que cest bien selectionne

        assertEquals(2,res.size());
        assertTrue(res.contains(cpt));
        assertTrue(res.contains(cpt5));
    }

}

