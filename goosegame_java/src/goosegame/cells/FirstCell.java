package goosegame.cells;

import goosegame.*;
import java.util.*; 

/**
 * Represents the first cell of a board which is also a Cell
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class FirstCell implements Cell{
    private List<Player> playersCell0;

    /**
     * creates a first cell
     */
    public FirstCell(){
        this.playersCell0 = new ArrayList<Player>();
    }
    
    /** return true or false if you can play or not
     * @return true 
     */
    public boolean canPlay(){
        return true;
    }

    /** returns the index of the cell
     * @return the index of the cell
     */
    public int getIndex(){
        return 0;
    }
    
    /** returns the index of the cell you bounce
     * @return the index of the cell you bounce
     */
    public int bounce(int i){
        return this.getIndex();
    }
    
    /** returns true or false if the cell is busy or not
     * @return false
     */
    public boolean isBusy(){
        return false;
    }

    /** returns a string representation of the cell
     * @return a string representation of the cell
     */
    public String toString(){
        return "the first cell";
    }

    /** add a player to the cell
     * @param p the player we add
     */
    public void setPlayer(Player p){
        playersCell0.add(p);
    }

 
    /** returns the players on the cell
     * @return the players on the cell
     */
    public Player getPlayer(){
        return playersCell0.get(0);
    }

}