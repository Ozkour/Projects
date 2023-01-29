package competition.competitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompetitorTest{
    private Competitor competitor;
    private Competitor competitor2;

    @BeforeEach
    public void Before() {
        this.competitor = new Competitor("Mina");
        this.competitor2 = new Competitor("Nico");
    }

    @Test
    public void isWellConstructedTest() {
        assertEquals(0,this.competitor.getPoints());
        assertEquals("Mina",this.competitor.getName());
    }

    @Test
    public void weCanAddPoints() {
        competitor.addPoints(5);
        assertEquals(5,this.competitor.getPoints());
    }

    @Test
    public void equalsCorrectTest(){
        assertTrue(this.competitor2.equals(new Competitor("Nico")));
    }

    @Test
    public void equalsNotCorrectTest(){
        assertFalse(this.competitor.equals(this.competitor2));
    }

}