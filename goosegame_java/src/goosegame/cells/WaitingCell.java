package goosegame.cells;

import goosegame.Player;

/**
 * Represents a waiting cell of a board which is also a Cell
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class WaitingCell extends NormalCell{

    protected int waitingTime;
    protected int cpt;
    
    /** creates a WaitingCell
     *  @param i the index of the cell
     *  @param waiting the time you will wait on the cell
     */
    public WaitingCell(int i,int waiting){
        super(i);
        this.waitingTime=waiting;
        this.cpt=waiting;
    }

    /** returns the waiting time
     * @return the waiting time
     */
    public int getWaitingTime(){
        return this.waitingTime;
    }

    /** returns the counter
     * @return the counter
     */
    public int getCpt(){
        return this.cpt;
    }

    /** return true or false if you can play or not
     * @return true if counter is negative
     */
    public boolean canPlay(){
        this.cpt = cpt-1;
        return (this.cpt < 0);
    }
    
    /** add a player to the cell
     * @param p the player we add
     */
    public void setPlayer(Player p){
        this.cpt = this.waitingTime;
        super.setPlayer(p);
    }
    
    /** returns a string representation of the cell
     * @return a string representation of the cell
     */
    public String toString(){
        return super.toString()+" (waiting for "+this.cpt+")";
    }

    /** returns a boolean if the object is equals to the cell
     * @return a boolean if the object is equals to the cell
    */
    public boolean equals(Object o){
        if (o instanceof WaitingCell){
            WaitingCell other = (WaitingCell) o;
            return this.index==other.getIndex() && this.player==other.getPlayer() && this.waitingTime==other.getWaitingTime();
        }
        return false;
    }
}