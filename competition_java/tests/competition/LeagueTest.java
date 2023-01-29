package competition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class LeagueTest extends CompetitionTest{
    

    @Test 
    public void thePointAreWellAddedToOurWinner(){

        assertEquals(0,competitor.getPoints());
        assertEquals(0,competitor2.getPoints());

        compet.playMatch(competitor,competitor2);
        assertEquals(1,Math.max(competitor.getPoints(),competitor2.getPoints()));
    }

	@Override
	protected Competition createCompetition() {
		return new League(this.competitors);
	}

}