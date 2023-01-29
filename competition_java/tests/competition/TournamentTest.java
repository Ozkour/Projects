package competition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TournamentTest extends CompetitionTest {

    protected Competition createCompetition() {
        return new Tournament(this.competitors);
    }

    @Test
    public void wePlayAMatchTheLoserIsDeletedAndTheWinnerGetsAPoint(){
        ((Tournament) this.compet).setPlayers(this.competitors);
        assertEquals(0,competitor.getPoints());
        assertEquals(0,competitor2.getPoints());

        compet.playMatch(competitor,competitor2);

        assertEquals(2,((Tournament) this.compet).getPlayers().size());
        assertEquals(1,Math.max(competitor.getPoints(),competitor2.getPoints()));
    }
}

