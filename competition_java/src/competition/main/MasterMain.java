package competition.main;

import competition.Competition;
import competition.Master;
import competition.competitor.Competitor;
import competition.selections.*;
import util.io.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The master of a league competition
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 12/11/2021
 */
public class MasterMain extends GlobalMain{

    static List<Selection> selections = new ArrayList<Selection>(); //la liste des selectioneurs
    static int nbFirsts = 0;

    /**
     * Reads the number or the size of the pools
     * @return the number or the size of the pools
     */
    public static int getPools(){
        int pools = 0;
        try {
            pools = Input.readInt(); //we check if a number has well being enter
            if(pools < 1){
                throw new IOException();
            }
        }
        catch(IOException e) {
            System.out.println("You have to put a number and at least 1.");
            return getPools();
        }
        return pools;
    }

    /**
     * Asks the user the number and the size of the pools
     * @return the number and the size of the pools
     */
    public static List<Integer> getNbSizePools(){
        List<Integer> res = new ArrayList<Integer>();
        System.out.println("How many pools do we have ?");
        res.add(getPools());
        System.out.println("How long our pool will be?");
        res.add(getPools());
        return res;

    }
    
    /**
     * Check if the number of pools multiplied by the size of a pool is equal to the number of competitors
     * @param nb the number of competitors
     * @param a the number of pools
     * @param b the size of a pool
     */
    public static void IsMultiple(int nb, int a, int b){
        if (a*b != nb){
            System.out.println("The number of pools * the size of the pools must be equal to the number of competitors.");
            List<Integer> pools = getNbSizePools();
            IsMultiple(nb,pools.get(0), pools.get(1));
        }
    }
    
    /**
     * Asks the user how to select the players
     * @param sizePool the size of a pool in our master
     * @param nbrPools the number of pools in our master
     * @throws IOException if the user doesn't write an int
     */
    public static void selection(int sizePool, int nbrPools) throws IOException{
        System.out.println("Choose the selection (you can choose many of them for example 123 or 32 or 1): \n Enter 1 to select some first competitors \n Enter 2 to select some last competitors \n Enter 3 to select some thirds competitors");
        String answer = Input.readString();
        if (answer.contains("1")){
            selectFirsts(sizePool);
        }
        if (answer.contains("2")){
            selectLasts(sizePool);
        }
        if (answer.contains("3")){
            selectThirds(nbrPools,sizePool);
        }
        if(!(answer.contains("1")|answer.contains("2")|answer.contains("3"))){
            System.out.println("You have to write number(s) between 1 and 3, try again");
            selection(sizePool,nbrPools);
        }
    }

    /**
     * Asks the user the firsts player to select
     * @param sizePool the size of a pool in our master
     * @throws IOException if the user doesn't write an int
     */
    public static void selectFirsts(int sizePool) throws IOException{
        System.out.println("How many firsts players of each pool do you want to take ?");
        int n = Input.readInt();
        while ( sizePool < n){
            System.out.println("You have to put a number which is less than the size of a group. Try again.");
            n = Input.readInt();
        }
        selections.add(new SelectionFirsts(n));
        nbFirsts = n;
    }

    /**
     * Asks the user the lasts player to select
     * @param sizePool the size of a pool in our master
     * @throws IOException if the user doesn't write an int
     */
    public static void selectLasts(int sizePool) throws IOException{
        System.out.println("How many lasts players do you want to take ?");
        int n = Input.readInt();
        while (n > sizePool - nbFirsts && n > sizePool - 3){
            System.out.println("You have to put a number which is less than the size of a group. Try again.");
            n = Input.readInt();
        }
        selections.add(new SelectionLasts(n));
    }

    /**
     * Asks the user the thirds player to select
     * @param nbPools the number of pools in our master
     * @param sizePool the size of a pool in our master
     * @throws IOException if the user doesn't write an int
     */
    public static void selectThirds(int nbPools, int sizePool) throws IOException{
        if (sizePool < 3){
            System.out.println("Pools are too small to select some thirds players");
        }
        else{
            if(nbFirsts < 3){
                System.out.println("How many thirds players do you want to take ?");
                int n = Input.readInt();
                while(n > nbPools){
                    System.out.println("You have to put a number which is less than the number of groups. Try again.");
                    n = Input.readInt();
                }
                selections.add(new SelectionThirds(n));
            }
            else{
                System.out.println("Sorry thirds players are already chosen, so you can't add them again to the competition.");
            }
        }
    }


    /**
     * the main of our master
     * @param args no argument needed
     * @throws Exception since we use getNbComp()
     */
    public static void main(String[] args)throws Exception{
        int nb = getNbComp();
        List<Integer> pools = getNbSizePools();
        IsMultiple(nb,pools.get(0), pools.get(1));
        List<Competitor> competitors = createCompetitors(nb);
        selection(pools.get(1), pools.get(0));
        Competition master = new Master(competitors, selections, pools.get(0),pools.get(1));
        
        master.play();
    }

   
}