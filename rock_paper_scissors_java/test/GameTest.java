import org.junit.*;
import static org.junit.Assert.*;

import pfc.*;
import pfc.strategy.*;

public class GameTest{

    @Test
    public void gameCreationAndGetPlayers(){
        Strategy offensive = new PaperStrategy();
        Strategy defensive = new RockStrategy();
        Player futureWinner = new Player("Hubert", offensive);
        Player futureLooser = new Player("Patrick", defensive);
        Game wow = new Game(futureWinner,futureLooser);
        assertSame(futureWinner,wow.getPlayer1());
        assertSame(futureLooser,wow.getPlayer2());
    }

    @Test
    public void oneRoundHasBeenPlayed(){
        Strategy offensive = new PaperStrategy();
        Strategy defensive = new RockStrategy();
        Player futureWinner = new Player("Hubert", offensive);
        Player futureLooser = new Player("Patrick", defensive);
        Game wow = new Game(futureWinner,futureLooser);
        wow.playOneRound();
        assertEquals(2,futureWinner.getPoints());
        assertEquals(0,futureLooser.getPoints());
    }

    @Test
    public void aGameHasBeenPlayed(){
        Strategy offensive = new PaperStrategy();
        Strategy defensive = new RockStrategy();
        Player futureWinner = new Player("Hubert", offensive);
        Player futureLooser = new Player("Patrick", defensive);
        Game wow = new Game(futureWinner,futureLooser);
        assertSame(futureWinner,wow.play(5));
    }

    @Test
    public void pointsHaveBeenGiven(){
        Strategy offensive = new PaperStrategy();
        Strategy defensive = new RockStrategy();
        Player futureWinner = new Player("Hubert", offensive);
        Player futureLooser = new Player("Patrick", defensive);
        Game wow = new Game(futureWinner,futureLooser);
        wow.givePoints(1);
        assertEquals(2,futureWinner.getPoints());
        assertEquals(0,futureLooser.getPoints());
        wow.givePoints(0);
        assertEquals(1,futureLooser.getPoints());
        assertEquals(3,futureWinner.getPoints());
        wow.givePoints(-1);
        assertEquals(3,futureLooser.getPoints());
        assertEquals(3,futureWinner.getPoints());
    }

    @Test
    public void weHaveTheWinner(){
        Strategy offensive = new PaperStrategy();
        Strategy defensive = new RockStrategy();
        Player futureWinner = new Player("Hubert", offensive);
        Player futureLooser = new Player("Patrick", defensive);
        Game wow = new Game(futureWinner,futureLooser);
        futureWinner.addPoints(5);
        assertSame(futureWinner,wow.getWinner());
        futureLooser.addPoints(5);
        assertSame(Player.NOBODY,wow.getWinner());
        futureLooser.addPoints(5);
        assertSame(futureLooser,wow.getWinner());
    }

    @Test
    public void theStringIsRight(){
        Strategy offensive = new PaperStrategy();
        Strategy defensive = new RockStrategy();
        Player futureWinner = new Player("Hubert", offensive);
        Player futureLooser = new Player("Patrick", defensive);
        Game wow = new Game(futureWinner,futureLooser);
        assertEquals("The player 1 is Hubert and the player 2 is Patrick",wow.toString());
    }


// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(GameTest.class);
}

}