package competition;

import java.util.List;
import java.util.ArrayList;

import competition.competitor.Competitor;
import competition.observer.Bookmaker;
import competition.observer.Journalist;
import competition.selections.Selection;
import util.MapUtil;


/**
 * A Master is a type of competition.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 10/10/2021
 */

public class Master extends Competition {

    private List<Selection> select; //the list of selectors of our master
    private int nbGroups; // the number of groups
    private int sizeGroups; //the size of a group


    /**
    * The constructor of a Master
    * @param cmpt the list of competitors of the master
    * @param select the list of selectors of the master
    * @param nbGroups the number of groups of the master
    * @param sizeGroups the size of the groups in a master
    */
    public Master(List<Competitor> cmpt, List<Selection> select, int nbGroups, int sizeGroups) {
        super(cmpt);
        this.select = select;
        this.nbGroups = nbGroups;
        this.sizeGroups = sizeGroups;
        
    }

    /**
    * To get the list of selectors
    * @return the list of selectors 
    */
    public List<Selection> getSelect() {
        return this.select;
    }

    /**
    * To set the list of selectors
    * @param select the list of selectors 
    */
    public void setSelect(List<Selection> select) {
        this.select = select;
    }

    /**
    * To get the number of groups of the master
    * @return the number of groups of the master
    */
    public int getNbGroups() {
        return this.nbGroups;
    }

    /**
    * To set the number of groups of the master
    * @param nbGroups the number of groups of the master
    */
    public void setNbGroups(int nbGroups) {
        this.nbGroups = nbGroups;
    }

    /**
    * To get the size of a group of the master
    * @return the size of a group of the master
    */
    public int getSizeGroups() {
        return this.sizeGroups;
    }

    
    /**
    * To set the size of a group of the master
    * @param sizeGroups the size of a group of the master
    */
    public void setSizeGroups(int sizeGroups) {
        this.sizeGroups = sizeGroups;
    }
    
    /**
    * To play a master
    * @param competitors the list of competitors of the master
    */
    @Override
    protected void play(List<Competitor> competitors) {
        List<List<Competitor>> poules = this.createGroups(competitors);//methode de creation des poules 
        this.playGroups(poules);//on obtient la liste des joueurs selectionnés
        List<Competitor> selected_players = this.doTheSelection(poules);
        System.out.println("Final : ");
        this.playTournament(selected_players); //on donne la liste des selectionnés pour un tournament
    }

    /**
    * create our groups for the list of competitors
    * @param competitors the list of competitors of the master
    * @return the list of the groups of competitors
    */
    protected List<List<Competitor>> createGroups(List<Competitor> competitors){
        List<List<Competitor>> res = new ArrayList<List<Competitor>>();
        List<Competitor> l = new ArrayList<Competitor>(); //on crée une liste qui stockera les competitors d'une poule
        int cpt = 0;
        for (int i = 0 ; i < this.nbGroups ; i ++){ //pour chaque groupe
            for (int j = 0; j< this.sizeGroups ; j++){//pour chaque element du groupe
                l.add(competitors.get(cpt)); //on ajoute 
                cpt++;
            }
            List<Competitor> copy = new ArrayList<Competitor>(l);
            res.add(copy); //on ajoute notre poule à res
            l.clear();
        }
        return res;
    }


    /**
    * play a league for each groups selected in the master
    * @param cmpt the list of each groups of the master
    */
    protected void playGroups(List<List<Competitor>> cmpt){
        League league;
        for(int i = 0 ; i < cmpt.size() ; i++){
            System.out.println("Pool number "+(i+1));
            league = new League(cmpt.get(i));
            league.register(new Journalist());//on ajoute un journaliste
            league.register(new Bookmaker());//on ajoute un bookmaker
            league.play(cmpt.get(i)); //jouer une league pour chaque poule
            MapUtil.sortGroups(cmpt.get(i)); // on trie notre poule
        }
    }



        
    /**
    * applied our selections for each groups and remove player if we addn't a power of 2
    * @param cmpt the list of each groups of the master
    *@return the list of our selected players
    */
    protected List<Competitor> doTheSelection(List<List<Competitor>> cmpt) {
        List<Competitor> res = new ArrayList<Competitor>();
        for (int i = 0; i <this.select.size() ; i++){ //faire boucle sur les select
            res.addAll(this.select.get(i).selected(cmpt)); //on concatène pour avoir une liste final qui a appliqué tous les filtres
        }
        //System.out.println(res.size());
        while (!Selection.isPowerOfTwo(res.size())){// tant qu'on a pas une puissance de 2
            res.remove(res.size()-1);//on retire le dernier de la liste (pas forcément le dernier en points)
        }
        return res; 
    }

    /**
    * play a tournament for our selected player
    * @param cmpt the list of selected players
    */
    protected void playTournament(List<Competitor>cmpt){
        Tournament tournament = new Tournament(cmpt);
        tournament.register(new Journalist());//on ajoute un journaliste
        tournament.register(new Bookmaker());//on ajoute un bookmaker
        tournament.play(cmpt);
        System.out.println("The winner of the master is : "+tournament.getPlayers().get(0).getName()+" !");
    }

    /**
     * Plays a match in master
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    protected void playMatch(Competitor c1, Competitor c2){
        // we don't need this method since we use tournament and league 
    }
    

}
