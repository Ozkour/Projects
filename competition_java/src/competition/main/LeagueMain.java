package competition.main;

import competition.Competition;
import competition.League;
import competition.competitor.*;
import competition.observer.Bookmaker;
import competition.observer.Journalist;

import java.util.*;


/**
 * The main of a league competition
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 23/09/2021
 */
public class LeagueMain extends GlobalMain{

    /**
     * the main of our tournament
     * @param args no parameters needed 
     * @throws Exception since we use getNbComp()
     */
     public static void main(String[] args)throws Exception{

         List<Competitor> competitors = createCompetitors(getNbComp());
         Competition league = new League(competitors);
         league.register(new Journalist());
         league.register(new Bookmaker());
         league.play();
     }
}

