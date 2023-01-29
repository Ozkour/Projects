package competition;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.competitor.*;
import competition.observer.Bookmaker;

public abstract class CompetitionTest {

    protected abstract Competition createCompetition();


    protected Competitor competitor;
    protected Competitor competitor2;
    protected Competitor competitor3;
    protected List<Competitor> competitors = new ArrayList<Competitor>();
    protected Competition compet;

    @BeforeEach
    public void Before() {
        this.competitor = new Competitor("Mina");
        this.competitor2 = new Competitor("Nico");
        this.competitor3 = new Competitor("Antoine");
        this.competitors.add(this.competitor);
        this.competitors.add(this.competitor2);
        this.competitors.add(this.competitor3);
        this.compet = this.createCompetition();
    }


    @Test
    public void rankingWellSortsTheCompetitors(){
        this.competitor.addPoints(3); 
        this.competitor2.addPoints(4);
        this.competitor3.addPoints(2);

        HashMap<Competitor, Integer> wellSortedMap = new HashMap<Competitor, Integer>();
        
        wellSortedMap.put(competitor2,4);
        wellSortedMap.put(competitor,3);
        wellSortedMap.put(competitor3,2);

        assertEquals(wellSortedMap,compet.ranking());
    }

    @Test
    public void theMethodIsWellLanchedWhenMatchOver(){
        MockMatchObserver journalist = new MockJournalist();
        MockMatchObserver bookmaker = new MockBookmaker();
        this.register(journalist);
        this.register(bookmaker);
        assertEquals(0, journalist.applyCalled);
        assertEquals(0, bookmaker.applyCalled);
        compet.matchOver(competitor, competitor2);
        assertEquals(1, journalist.applyCalled);
        assertEquals(1, bookmaker.applyCalled);
    }

}
