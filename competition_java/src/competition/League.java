package competition;

import java.util.*;
import competition.competitor.*;

/**
 * A league is a type of competition.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 23/09/2021
 */
public class League extends Competition{
    
	/**
     * The constructor of a league
     * @param cmpt the list of competitors of the league
     */
    public League(List<Competitor> cmpt){
        super(cmpt);
    }

			
	/**
     * Plays a match and adds a point to the winner
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
	protected void playMatch(Competitor c1,Competitor c2) {
		this.getMatch().playAMatch(c1,c2);
        this.getMatch().getWinner().addPoints(1);
	}

	/**
     * Plays the matches of a League
     * @param competitors the competitors who play the league
     */
	protected void play(List<Competitor> competitors) {
		for(int i=0; i<competitors.size(); i+=1){
			for(int j=0; j<competitors.size(); j+=1){
				if(i!=j){ //we don't want a competitor to play against himself
					playMatch(competitors.get(i), competitors.get(j));
					//this.getMatch().displayWinner(competitors.get(i),competitors.get(j));
					this.matchOver(this.getMatch().getWinner(), this.getMatch().getLooser()); //run the observations
				}
			}
		}
	}

}

