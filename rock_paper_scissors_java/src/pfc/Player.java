package pfc;
import pfc.strategy.*;
/**
 * Represents a player with his name and his strategy
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */

public class Player{

    public static final Player NOBODY = new Player("Nobody",new RandomStrategy());

    private int nbPoints = 0;
    private String name;
    private Strategy strat;

    /** a constructor for the class Player
     * @param name the name of the player
     * @param strat his stategy
     */
    public Player(String name,Strategy strat){
        this.name = name;
        this.strat = strat;
    }

    /** return the choice of the player matching to his strategy
     * @return the choice of the player matching to his strategy
     */
    public Choice choose(){
        return this.strat.choose();
    }

    /** add i points to a player
     * @param i the number of points we want to add
     */
    public void addPoints(int score){
        this.nbPoints += score;
    }

    /** return the number of points of the player
     * @return the number of points of the player
     */
    public int getPoints(){
        return this.nbPoints;
    }

    /** return the name of the player
     * @return the name of the player
     */
    public String getName(){
        return this.name;
    }
}