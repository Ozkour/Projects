package goosegame;
import goosegame.cells.*;

/**
 * Represents a game board of a goose game
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public abstract class Board{

    // The number of cells of the board
    protected int nbOfCells;

    // a tab of cells which represents the board
    protected Cell[] theCells;

    /** 
     * @param nbCells the number of cells of the board
     */
    public Board(int nbCells) {
        this.nbOfCells= nbCells;
        this.theCells = new Cell[nbCells + 1];
        this.theCells[0] = new FirstCell();
        this.initBoard();
    }  

    /** return the cell at the position i
     * @param i the position of the cell we want on the board
     * @return the cell at the position i
     */
    public Cell getCell(int i){
        return this.theCells[i];
    }
    
    /** return the number of cells
     * @return the number of cells
     */
    public int getNbOfCells(){
        return this.nbOfCells;
    }
    
    public abstract void initBoard();
}
