package competition.selections;

import java.util.ArrayList;
import java.util.List;

import competition.competitor.Competitor;
import util.MapUtil;

/**
 * This class permits to select the n best thirds competitors in all the competitors
 * @author Nicolas Kerman and Mina Crapez
 * @version 10/10/2021
 */
public class SelectionThirds implements Selection{
    
    private int n;// the number of competitors we want to take

    /**
    * The constructor of a SelectionThirds
    * @param n the number of competitors we want to take
    **/
    public SelectionThirds(int n) {
        this.n = n;
    }
    
    /**
     * to get the number of competitors we want to take
     * @return the number of competitors we want to take
     */
    public int getN() {
        return this.n;
    }

    /**
     * to set the number of competitors we want to take
     * @param n the number of competitors we want to take
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * select the n thirds competitors
     * @param cmpt the list of groups of competitors we want to select
     * @return the list of competitors selected
     */
    @Override // COMMENTAIRE: on voulait trouver un moyen d'utiliser sort sur une liste mais échec, on fait donc une boucle 
    public List<Competitor> selected(List<List<Competitor>> cmpt) {
         List<Competitor> res = new ArrayList<Competitor>();
         List<Competitor> thirds = new ArrayList<Competitor>();
         
         for(int i=0;i<cmpt.size();i++){
             thirds.add(cmpt.get(i).get(2));
         }
         MapUtil.sortGroups(thirds);
         for(int i=0;i<this.n;i++){
            res.add(thirds.get(i));
        }
         return res;

    }
}
