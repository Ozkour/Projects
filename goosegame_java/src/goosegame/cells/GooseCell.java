package goosegame.cells;

/**
 * Represents a goose cell of a board which is also a Cell
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class GooseCell extends NormalCell{

    /** creates a GooseCell
     *  @param i the index of the cell
     */
    public GooseCell(int i){
        super(i);
    }

    /** returns the index of the cell you arrive when you bounce on this cell
     * @param des the number on the dices
     * @return the index of the cell
     */
    public int bounce(int des){
        return this.getIndex()+des;
    }

    /** returns a string representation of the cell
     * @return a string representation of the cell
     */
    public String toString(){
        return super.toString()+" (goose)";
    }

    /** returns a boolean if the object is equals to the cell
     * @return a boolean if the object is equals to the cell
    */
    public boolean equals(Object o){
        if (o instanceof GooseCell){
            GooseCell other = (GooseCell) o;
            return this.index==other.getIndex() && this.player==other.getPlayer();
        }
        return false;
    }
}