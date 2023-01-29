package competition.observer;

import competition.competitor.Competitor;

/**
 * The class of a MatchObserver.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 24/11/2021
 */
public interface MatchObserver{

    /**
    * run a reaction of an observer of the match
    * @param c1 the first competitor of the match
    *@param c2 the second competitor of the match
    */
    public void reaction(Competitor c1, Competitor c2);
    
}