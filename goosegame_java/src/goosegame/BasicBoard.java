package goosegame;
import goosegame.cells.*;

/**
 * Represents the basic board of a goose game which is also a board
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class BasicBoard extends Board{
    
    /** 
    * builds a basic board with 63 cells
    */
    public BasicBoard(){
        super(63);
    }

    /** 
     * initialises the different cells of the board 
     */
    public void initBoard(){

        this.theCells[0]= new FirstCell();

        for (int i=1;i<7;i++){
            this.theCells[i*9] = new GooseCell(i*9);
        }
        
        this.theCells[31] = new TrapCell(31);
        this.theCells[52] = new TrapCell(52);

        this.theCells[19] = new WaitingCell(19,2);

        this.theCells[6] = new TeleportCell(6,12);
        this.theCells[42] = new TeleportCell(42,30);
        this.theCells[58] = new TeleportCell(58,1);

        for (int i = 1;i<64;i++){
            if (this.theCells[i] == null){
            this.theCells[i] = new NormalCell(i);
        }
    }

    }

}
