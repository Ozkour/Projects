package competition.observer;

import competition.competitor.Competitor;

/**
 * The class of a journalist.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 24/11/2021
 */
public class Journalist implements MatchObserver{


    /**
     * Displays the results of the current match
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    @Override
    public void reaction(Competitor c1, Competitor c2) {
         System.out.println(c1.getName()+" vs "+c2.getName()+" --> "+c1.getName()+" wins and have "+ c1.getPoints() + " point(s) !");
    }
}