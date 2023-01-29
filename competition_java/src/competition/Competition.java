package competition;

import java.util.*;
import util.*;
import competition.competitor.*;
import competition.match.*;
import competition.observer.MatchObserver;

/**
 * The class of a competition.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 23/09/2021
 */
public abstract class Competition{
    private Match match; //a match that we want to have in a competition
    private final List<Competitor> competitors; //the list of competitors of a competition
    private List<MatchObserver> observers; //the list of observers
    
     /**
     * The constructor of a competition
     * @param cmpt the list of competitors of the competition
     */
    public Competition(List<Competitor> cmpt){
        this.match = new Match();
        this.competitors = cmpt;
        this.observers = new ArrayList<MatchObserver>();

    }

    /**
     * Plays the matches of a Competition
     * @param competitors the competitors who play the Competition
     */
    protected abstract void play(List<Competitor> competitors);


    /**
     * Plays a match and adds a point to the winner
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    protected abstract void playMatch(Competitor c1,Competitor c2);


    /**
     * getter of the list of competitors of the competition
     * @return the list of competitors of the competition
     */
    public List<Competitor> getCompetitors(){
        return this.competitors;
    }

    /**
     * getter the match that we want to have in a competition
     * @return the match that we want to have in a competition
     */
    public Match getMatch(){
        return this.match;
    }

    /**
     * set the match of a competition
     * @param match the match
     */
    public void setMatch(Match match){
        this.match = match;
    }

     /**
     * get the observers of the competition
     * @return the observers of the competition
     */
    public List<MatchObserver> getObservers() {
        return this.observers;
    }

    /**
     * register a new observer to our competition
     @param observer the new observer we want to add
     */
    public void register(MatchObserver observer) {
        this.observers.add(observer);
    }

    /**
     * unregister an observer to our competition
     @param observer the observer we want to remove
     */
    public void unregister(MatchObserver observer) {
        this.observers.remove(observer);
    }


    /** 
    *Plays a competition, display the result and the competition
    */
    public void play(){
        System.out.println("Let's start the competition !");
        this.play(this.getCompetitors()); //start a competition depending of its type
        System.out.println("*** Ranking *** \n");
        Map<Competitor, Integer> rank =  this.ranking(); //sort the competitors to create a ranking
        this.displayRanking(rank);
    };


	/**
	 * Sort the competitors to make a ranking
	 * @return the ranking of the competitors
	 */
	public Map<Competitor, Integer> ranking(){
        HashMap<Competitor, Integer> res = new HashMap<Competitor, Integer>();
        List<Competitor> competitors = this.getCompetitors();
        for(Competitor comp : competitors){
            res.put(comp,comp.getPoints());
        }
        return  MapUtil.sortByDescendingValue(res);
    }

    /**
     * Displays the ranking of the competitors
     * @param rank the sorted ranking of the competitors
     */
    public void displayRanking(Map<Competitor, Integer> rank){
        rank.forEach((c,pts)->System.out.println(c.getName()+" - "+ pts));
    
    }

    /**
     * run the observations of a competiton 
     * @param c1 the first competitor of a match 
     * @param c2 the second competitor of a match 
     */
    public void matchOver(Competitor c1, Competitor c2){
        for (MatchObserver observer : this.observers){ observer.reaction(c1, c2);}
    }
}