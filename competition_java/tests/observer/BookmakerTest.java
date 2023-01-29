package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class BookmakerTest {
    
    private Competitor competitor1;
    private Competitor competitor2;
    private BookMaker bookmaker;

  @BeforeEach
    public void Before() {
    this.competitor1 = new Competitor("Nico");
    this.competitor2 = new Competitor("Mina");
    this.bookmaker = new Bookmaker();
    }

    @Test 
    public void aCompetitorIsWellAddedToTheMap(){
        assertFalse(this.bookmaker.rating.containsKey(this.competitor));
        this.bookmaker.addCompIfNotInTheMap(this.competitor);
        assertTrue(this.bookmaker.rating.containsKey(this.competitor));
    }

    @Test 
    public void theRatingIsWellChanged(){
        // on a deux competiteurs c1 et c2, leur rating est de base à 1
        this.bookmaker.reaction(competitor1,competitor2);
        //on verifie que la valeur associé à c1 est 2 et c2 1
        assertEquals(2,this.bookmaker.rating.get(this.competitor1));
        assertEquals(1,this.bookmaker.rating.get(this.competitor2));

        //on vérifie que le perdant a bien perdu 1 point
        this.bookmaker.reaction(competitor2,competitor1);
        assertEquals(1,this.bookmaker.rating.get(this.competitor1));
        assertEquals(2,this.bookmaker.rating.get(this.competitor2));
    }

}
