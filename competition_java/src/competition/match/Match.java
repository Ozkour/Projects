package competition.match;
import java.util.*;
import competition.competitor.*;

/**
 * A match will occur between competitors in a competition.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 22/09/2021
 */
public class Match{
    public static final Random alea = new Random(); 
    
    protected Competitor looser; // the looser of the competition
    protected Competitor winner; // the winner of the competition
    /**
     * The constructor of Match
    */
    public Match() {
        this.winner = null;
        this.looser = null;
    }
    
	/**
	 * Returns the winner of the Match
	 * @return the winner the Match
	 */
	public Competitor getWinner() {
		return this.winner;
	}

    /**
	 * Returns the looser of the Match
	 * @return the looser the Match
	 */
	public Competitor getLooser() {
		return this.looser;
	}


    /**
     * Plays a match
     *@param c1 the first competitor
     *@param c2 the seconde competitor
     */
    public void playAMatch(Competitor c1,Competitor c2) {
        int value = alea.nextInt(2);
        if (value==0){
            this.winner = c1;
            this.looser = c2;
        }
        else{
            this.winner = c2;
            this.looser = c1;
        }
    }

    /**
     * Displays the results of the current match
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    /* public void displayWinner(Competitor c1,Competitor c2){
        System.out.println(c1.getName()+" vs "+c2.getName()+" --> "+this.getWinner().getName()+" wins and have "+ this.getWinner().getPoints() + " point(s) !\n");
    } */

}
