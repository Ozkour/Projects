package competition.main;

import competition.competitor.*;
import java.util.*;
import java.io.*;
import util.io.*;

public abstract class GlobalMain {
    
    /**
     * give the number of competitor we want to have in our league
     * @return the number of competitor we want to have in our league
     * @throws IOException if the number isn't a power of two and if we don't have a number
     */
    public static int getNbComp() throws IOException{
        System.out.println("How many Competitors do we have ?");
        int nbPlayer = 0;

        try {
            nbPlayer = Input.readInt(); //we check if a number has well being enter
            if(nbPlayer < 2){
                throw new IOException();
            }
        }
        catch(IOException e) {
            System.out.println("You have to put a number and at least 2 players.");
            return getNbComp();
        }
        return nbPlayer;
    }

    /**
     * create the list of competitors that we want for our league
     * @return the list of competitors of our league
     * @throws IOException since we use getNbComp()
     */
    public static List<Competitor> createCompetitors(int nbComp) throws IOException{
        List<Competitor> cptrs = new ArrayList<Competitor>();
        for(int i=0;i<nbComp;i++){
            System.out.println("What's the name of the competitor number "+ (i+1) + " ?");
            String name = Input.readString();
            Competitor comp = new Competitor(name);
            cptrs.add(comp);
            
        }
        return cptrs;
	}

}
