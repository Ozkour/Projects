package game;

import java.util.List;

import game.util.Position;

/**
 * A board is a rectancle (or a square) composed of different Tiles.
 * The players of the games are going to play on it.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 19/02/2021
 */


public abstract class Board {
    
    protected int height; //the height of the board
    protected int width; //the width of the board
    protected Tile[][] theTiles; //an array which represents the board
    protected Factory factory; // the factory to build tiles of the board

    /**
     * The constructor to build the board
     * @param height the length of the board
     * @param width the width of the board
     * @param factory the factory corresponding to the game that is going to be played
     */
    protected Board(int height, int width, Factory factory){
        this.height = height;
        this.width = width;
        this.theTiles = new Tile[width][height];
        this.factory = factory;
        this.initBoard();
    }
    
    /**
     * to get the tile at a position
     * @param pos the position of the tile that we want
     * @return the Tile
     */
    public Tile getTile(Position pos){
        return this.theTiles[pos.getX()][pos.getY()];
    }
    
    /**
     * to have a matrix with all the tiles of the board
     * @return a matrix with the tiles of the board
     */
    public Tile[][] getArrayTile() {
    	return this.theTiles;
    }
    
    /**
     * to get the number of Tiles on the board
     * @return the number of Tiles
     */
    public int getSize(){
        return this.width * this.height;
    }

    /**
     * to get the width of the board
     * @return the width of the board 
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * to get the height of the board
     * @return the height of the board 
     */
    public int getHeight(){
        return this.height;
    }
    
    /**
     * to get the factory of the board
     * @return the factory of the board 
     */
    public Factory getFactory(){
        return this.factory;
    }


    /**
     * to initialize the board
     */   
    protected abstract void initBoard();
    
    
    /**
     * to know if there is a walking tile around a tile
     * @param position the position of the tile
     * @return true if the tile is alone and false otherwise
     */
    public abstract boolean isAlone(Position position);
    
    
    /**
     * to get the tiles around a tile
     * @param pos the position of the tile 
     * @return the list with the position(s) of the tile(s) around
     */
    public abstract List<Position> getTileAround(Position pos);
    
    /**
     * used to display the board
     */
    public abstract void displayBoard();
}


 
