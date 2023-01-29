package goosegame.cells;
import goosegame.*;

/**
 * Represents a normal cell of a board which is also a Cell
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class NormalCell implements Cell {
    
    protected int index;
    protected Player player;

    /** creates a NormalCell
     *  @param i the index of the cell
     */
    public NormalCell(int i){
        this.index = i;
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
        return this.index;
    }

    /** returns the index of the cell you arrive when you bounce on this cell
     * @param des the number on the dices
     * @return the index of the cell
     */
    public int bounce(int des){
        return this.getIndex();
    }

    /** returns true or false if the cell is busy or not
     * @return true if there is no player on the cell
     */
    public boolean isBusy(){
        return this.player != null;
    }

    /** add a player to the cell
     * @param p the player we add
     */
    public void setPlayer(Player p){
        this.player = p;
    }
    
    /** return the player on the cell
     * @return the player on the cell
     */
    public Player getPlayer(){
        return this.player;
    }

    /** returns a string representation of the cell
     * @return a string representation of the cell
     */
    public String toString(){
        return "the cell "+this.getIndex();
    }

    /** returns a boolean if the object is equals to the cell
     * @return a boolean if the object is equals to the cell
    */
    public boolean equals(Object o){
        if (o instanceof NormalCell){
            NormalCell other = (NormalCell) o;
            return this.index==other.getIndex() && this.player==other.getPlayer();
        }
        return false;
        
    }
}
