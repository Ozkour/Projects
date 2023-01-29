package goosegame.cells;

/**
 * Represents a teleport cell of a board which is also a Cell
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class TeleportCell extends NormalCell{

    protected int dest;

    /** creates a TeleportCell
     *  @param i the index of the cell
     *  @param dest the destination of the teleport
     */
    public TeleportCell(int i, int dest){
        super(i);
        this.dest=dest;
    }

    /** return the destination
     * @return the destination
     */
    public int getDest(){
        return this.dest;
    }

    /** returns the index of the cell you arrive when you bounce on this cell
     * @param des the number on the dices
     * @return the index of the cell
     */
    public int bounce(int des){
        return this.getDest();
    }

    /** returns a string representation of the cell
     * @return a string representation of the cell
     */
    public String toString(){
        return super.toString()+" (teleport to "+this.getDest()+")";
    }

        /** returns a boolean if the object is equals to the cell
     * @return a boolean if the object is equals to the cell
    */
    public boolean equals(Object o){
        if (o instanceof TeleportCell){
            TeleportCell other = (TeleportCell) o;
            return this.index==other.getIndex() && this.player==other.getPlayer() && this.dest==other.getDest();
        }
        return false;
    }
}

    