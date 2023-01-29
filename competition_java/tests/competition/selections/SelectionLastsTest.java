package competition.selections;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import competition.competitor.Competitor;

import java.util.List;

public class SelectionLastsTest extends SelectionTest{

    @Test
    public void theLastsCompetitorsAreWellSelected(){
        //on fait une selection
        Selection sel = new SelectionLasts(1);
        //on selectionne
        List<Competitor> res = sel.selected(this.pools);
        //on verifie que cest bien selectionne

        assertEquals(2,res.size());
        assertTrue(res.contains(cpt4));
        assertTrue(res.contains(cpt8));
    }
}
