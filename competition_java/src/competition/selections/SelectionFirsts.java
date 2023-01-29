package competition.selections;

import java.util.ArrayList;
import java.util.List;

import competition.competitor.Competitor;


/**
 * This class permits to select the n firsts competitors of each pool
 * @author Nicolas Kerman and Mina Crapez
 * @version 10/10/2021
 */
public class SelectionFirsts implements Selection{

    private int n; // the number of competitors we want to take


    /**
    * The constructor of a SelectionFirsts
    * @param n the number of competitors we want to take
    **/
    public SelectionFirsts(int n) {
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
     * select the n firsts competitors
     * @param cmpt the list of groups of competitors we want to select
     * @return the list of competitors selected
     */
    @Override
    public List<Competitor> selected(List<List<Competitor>> cmpt) { 
        List<Competitor> res = new ArrayList<Competitor>();
        for(int i=0;i<cmpt.size();i++){//pour chaque poule
            for(int j=0;j<this.n;j++){//pour les n premiers de chaque poule
                res.add(cmpt.get(i).get(j));//on ajoute a la liste des sélectionnés
            }
        }
        return res;
    }
}
