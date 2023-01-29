package goosegame.cells;

/**
 * Represents a trap cell of a board which is also a Cell
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class TrapCell extends NormalCell{

    /** creates a TrapCell
     *  @param i the index of the cell
     */
    public TrapCell(int i){
        super(i);
    }

    /** return true or false if you can play or not
     * @return false
     */
    public boolean canPlay(){
        return false;
    }

    /** returns a string representation of the cell
     * @return a string representation of the cell
     */
    public String toString(){
        return super.toString()+" (trap)";
    }

    /** returns a boolean if the object is equals to the cell
     * @return a boolean if the object is equals to the cell
    */
    public boolean equals(Object o){
        if (o instanceof TrapCell){
            TrapCell other = (TrapCell) o;
            return this.index==other.getIndex() && this.player==other.getPlayer();
        }
        return false;
    }
}