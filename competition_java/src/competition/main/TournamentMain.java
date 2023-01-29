package competition.main;

import java.util.*;
import java.io.*;
import util.io.*;
import competition.Competition;
import competition.Tournament;
import competition.competitor.*;
import competition.observer.Bookmaker;
import competition.observer.Journalist;
import competition.selections.Selection;

/**
 * The main of a tournament competition
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 23/09/2021
 */
public class TournamentMain extends GlobalMain{

    /**
     * give the number of competitor we want to have in our tournament
     * @return the number of competitor we want to have in our tournament
     * @throws IOException if the number isn't a power of two and if we don't have a number
     */
    public static int getNbComp() throws IOException{
        System.out.println("How many Competitors do we have ? You need to put a power of 2");
        int nbPlayer = 0;

        try {
            nbPlayer = Input.readInt(); //we check if a number has well being enter
            if((!Selection.isPowerOfTwo(nbPlayer))||(nbPlayer < 2)){ // we check that the number is a power of two
                throw new IOException();
            }
        }
        catch(IOException e) {
            System.out.println("You have to put a number which is a power of 2 and at least 2 players.");
            return getNbComp();
        }
        return nbPlayer;
    }

    /**
     * the main of our tournament
     * @param args no argument needed
     * @throws Exception since we use getNbComp()
     */
     public static void main(String[] args)throws Exception{
         List<Competitor> competitors = createCompetitors(getNbComp());
         Competition tournament = new Tournament(competitors);
         tournament.register(new Journalist());
         tournament.register(new Bookmaker());
         tournament.play();
     }
}

	