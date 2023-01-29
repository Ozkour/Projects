package competition;

import java.util.*;
import competition.competitor.*;
import competition.match.*;

/**
 * A tournament is a type of competition.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 23/09/2021
 */
public class Tournament extends Competition{

    private List<Competitor> currentPlayers; // the player who continue to play in our tournament

    /**
     * The constructor of a tournament
     * @param cmpt the list of competitors of the tournament, the number of competitors must be a power of 2
     */
    public Tournament(List<Competitor> cmpt){
        super(cmpt);
        this.currentPlayers = null;
    }

    /**
     * getter of the list of current competitors of the tournament
     * @return the list of current competitors of the tournament
     */
    public List<Competitor> getPlayers() {
        return this.currentPlayers;
    }

    /**
     * To set the list of current competitors of the tournament
     * @param players the list of current competitors of the tournament
     */
    public void setPlayers(List<Competitor> players) {
        this.currentPlayers = new ArrayList<Competitor>(players);
    }

    /**
     * Plays a match, adds a point to the winner and remove the loser from the list of the current players
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    protected void playMatch(Competitor c1,Competitor c2){
        Match match = this.getMatch();
        match.playAMatch(c1,c2);
        match.getWinner().addPoints(1);
        this.currentPlayers.remove(match.getLooser());
    }


    /**
     * Plays the matches of a Tournament
     * @param competitors the competitors who play the tournament
     */
	protected void play(List<Competitor> competitors) {
        this.setPlayers(competitors); //we set the current players
        List<Competitor> copy = new ArrayList<Competitor>(competitors);//a copy we can modify
        while(this.currentPlayers.size()!=1){//while there is more than 1 competitor
            for(int i=0; i<copy.size(); i+=2){
                this.playMatch(copy.get(i),copy.get(i+1));
                //this.getMatch().displayWinner(copy.get(i),copy.get(i+1));
                this.matchOver(this.getMatch().getWinner(), this.getMatch().getLooser()); //run the observations
            }
            copy = new ArrayList<Competitor>(this.currentPlayers);//we set the copy we can modify
        }
        
    }
        

}


