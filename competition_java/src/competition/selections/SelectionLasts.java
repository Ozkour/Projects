package competition.selections;

import java.util.ArrayList;
import java.util.List;

import competition.competitor.Competitor;

/**
 * This class permits to select the n lasts competitors of all the competitors
 * @author Nicolas Kerman and Mina Crapez
 * @version 10/10/2021
 */
public class SelectionLasts implements Selection {

    private int n; // the number of competitors we want to take


    /**
    * The constructor of a SelectionLasts
    * @param n the number of competitors we want to take
    **/
    public SelectionLasts(int n) {
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
     * select the n lasts competitors
     * @param cmpt the list of groups of competitors we want to select
     * @return the list of competitors selected
     */
    @Override
    public List<Competitor> selected(List<List<Competitor>> cmpt) { //on a les joueurs de la poule et on veut les n derniers
        List<Competitor> res = new ArrayList<Competitor>();
        for(int i=0;i<cmpt.size();i++){
            for(int j=cmpt.get(i).size()-1;j>cmpt.get(i).size()-(this.n+1);j--){
                res.add(cmpt.get(i).get(j));
            }
        }
        return res;
    }
    
}
