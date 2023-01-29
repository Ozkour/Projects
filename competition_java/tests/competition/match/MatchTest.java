package competition.match;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import competition.competitor.Competitor;

public class MatchTest{

    private Competitor competitor1;
    private Competitor competitor2;
    private Match match;

    @BeforeEach
        public void Before() {
            this.competitor1 = new Competitor("Mina");
            this.competitor2 = new Competitor("Nico");
            this.match = new Match();

    }

    @Test
    public void oneOfOurTwoCompetitorsWins(){
        this.match.playAMatch(competitor1,competitor2);
        assertNotNull(match.getWinner());
        assertNotNull(match.getLooser());
    }



}


