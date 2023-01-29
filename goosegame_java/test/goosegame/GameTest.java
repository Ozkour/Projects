package goosegame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import goosegame.cells.*;


public class GameTest{

    private BasicBoard board;
    private Game game;
    private Player player1;
    private Player player2;
    private Cell cell1;
    private Cell cell2;

    @Before
    public void before(){
         this.board = new BasicBoard();
         this.game = new Game(board);
         this.cell1 = new NormalCell(4);
         this.player1 = new Player("Nico",cell1);
         this.game.addPlayer(player1);
         this.cell2 = new NormalCell(2);
         this.player2 = new Player("JL",cell2);
         this.game.addPlayer(player2);
    }

    @Test
    public void aGameHasBeenCreated(){
        assertEquals(0, game.getCurrentPlayer());
        assertSame(board,game.getBoard());
        }

    @Test
    public void aPlayerCanPlayOrNot(){
        Cell cell3 = new TrapCell(31);
        Player player3 = new Player("Mina",cell3);
        game.addPlayer(player3);
        assertTrue(game.playerCanPlay(player1));
        assertFalse(game.playerCanPlay(player3));
    }

    @Test
    public void weCanMoveAPlayerWithoutDifficultyIfTheCaseIsNotBusy(){
        game.movePlayer(player1, cell1);
        assertEquals(4, player1.getCell().getIndex());
    }

    @Test 
    public void the2PlayerSwitchIfOneMoveOnTheOtherOneCell(){
        game.movePlayer(player1, cell2);
        assertEquals(2,player1.getCell().getIndex());
        assertEquals(4,player2.getCell().getIndex());
    }

    @Test
    public void aPlayerIsWellAddedToTheListOfPlayers(){
       assertEquals(2,game.getThePlayers().size());
       assertTrue(game.getThePlayers().contains(player1));
       assertTrue(game.getThePlayers().contains(player2));
    }

    @Test
    public void aPartyIsWellFinished(){
        assertFalse(game.isFinished());
        player1.setCell(board.getCell(63));
        assertTrue(game.isFinished());

    }

    @Test
    public void theNextPlayerIsTheNextOneInTheList(){
        assertSame(player1,game.getThePlayers().get(game.getCurrentPlayer()));
        game.nextPlayer();
        assertSame(player2,game.getThePlayers().get(game.getCurrentPlayer()));
        game.nextPlayer();
        assertSame(player1,game.getThePlayers().get(game.getCurrentPlayer()));
    }






    
// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.GameTest.class);
}
}