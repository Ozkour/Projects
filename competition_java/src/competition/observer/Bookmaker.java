package competition.observer;

import java.util.HashMap;
import java.util.Map;

import competition.competitor.Competitor;

/**
 * The class of a bookmaker.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 24/11/2021
 */
public class Bookmaker implements MatchObserver{

    private Map<Competitor,Integer> rating;//the association of a competitor and a rating that our bookmaker is observing

    /**
    * The constructor of a bookmaker
    */
    public Bookmaker(){
        this.rating = new HashMap<Competitor,Integer>();
    }

    /**
    * add a competitor to our rating if he isn't in it
    @param c the competitor we want to test
    */
    public void addCompIfNotInTheMap(Competitor c){
        if(!this.rating.containsKey(c)){ 
            this.rating.put(c,1);
        }
    }

    /**
    * the bookmaker changes the ratings of the competition
    * @param c1 the first competitor of the match
    *@param c2 the second competitor of the match
    */
    @Override
    public void reaction(Competitor c1, Competitor c2) {
        int rating1, rating2, newRating1, newRating2;
        this.addCompIfNotInTheMap(c1);
        this.addCompIfNotInTheMap(c2);
        
        rating1 = this.rating.get(c1);
        rating2 = this.rating.get(c2);
        this.rating.replace(c1,rating1 + 1);// c1 is the winner, he has a higher rating
        if(rating2 != 1){ // if our looser has a rating of 0, it doesn't decrease
            this.rating.replace(c2,rating2 - 1); //c2 is the looser, he has a lower rating
        }
        newRating1 = this.rating.get(c1);
        newRating2 = this.rating.get(c2);

        displayRating(c1,rating1, newRating1);
        displayRating(c2, rating2, newRating2);
        System.out.println("\n");
    }

    /**
    * display the rating of a player
    @param c the competitor we want to display the new rating
    @param rating the former rating
    @param newRating the new rating of the player
     */
    public void displayRating(Competitor c,int rating, int newRating){
        System.out.println("The rating of "+c.getName()+" was "+ rating +" and is now "+ newRating +".");
    }
}
