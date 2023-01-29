package competition.selections;

import java.util.List;

import competition.competitor.Competitor;
/**
 * A selection is an interface of our different type of selection of players
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 10/10/2021
 */
public interface Selection {

    /**
     * select our competitors
     * @param cmpt the list of groups of competitors we want to select
     * @return the list of competitors selected
     */
    public List<Competitor> selected(List<List<Competitor>> cmpt);

    /**
     * check if a number is a power of 2
     * @param n the number we want to check
     * @return true if the number is a power of 2, false otherwise
     */
    public static boolean isPowerOfTwo(int n) {
            return n>0 && ((n&(n-1))==0);
        }
}
