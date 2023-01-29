package game.boards;
import game.*;
import game.util.Position;
import game.tile.*;

import java.util.*;

/**
 * A basic board to play the games.
 * The tiles' positions on this board are random.
 * The board has at least 2/3 of Ocean tiles.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 02/03/2021
 */

public class BasicBoard extends Board{

    public static final Random alea = new Random(); //to create a new random object
    
    /**
     * the constructor
     * @param width the width of the board
     * @param height the height of the board
     * @param factory the game's factory to create the tiles
     */
    public BasicBoard(int width, int height, Factory factory){
        super(width, height, factory);
    }   

    /**
    * to choose a random type of tile to create the board
    * @param position the position of the new random tile
    * @return a random tile
    */
    public Tile randomTile(Position position){   
        int value = alea.nextInt(WalkingTile.values().length);
        
        if (value == 1){
        	return this.factory.buildDesert(position);
        }
        else if (value == 2){
        	return this.factory.buildMountain(position);
        }
        else if (value == 3){
        	return this.factory.buildGrassland(position);
        }
        else {
        	return this.factory.buildForest(position);
        }
    }

    /**
    * To get the random position of an ocean tile
    * @return the position of the tile 
    */
    public Position randomTilePosition() {
        Position position = new Position(alea.nextInt(this.getWidth()), alea.nextInt(this.getHeight()));
        
        while (this.getTile(position).isWalking()){
            position.setX(alea.nextInt(this.getWidth()));
            position.setY(alea.nextInt(this.getHeight()));
        }
        return position;
        
    }

    /**
    * To know if there is a walking tile around a tile
    * @param pos the position of the tile 
    * @return true if the tile is alone and false otherwise
    */
    public boolean isAlone(Position pos) {
    	boolean res = true;
    	List<Position> aroundTiles = this.getTileAround(pos);
    	for (int i = 0; i < aroundTiles.size(); i ++) {
    		 if(this.getTile(aroundTiles.get(i)).isWalking()) {
    			 res = false;
    		 }
    	}
    	return res;
    }
    

    /**
    * To get the position of the tiles around a tile
    * @param position the position of the tile(s) around
    * @return the list with the position(s) of the tile(s) around
    */
    public List<Position> getTileAround(Position position) {
        ArrayList<Position> aroundTiles = new ArrayList<>();
        
        if ((position.getX()+1 < this.getWidth())) {
           Position pos = new Position(position.getX()+1, position.getY());
           aroundTiles.add(pos);
        }
        if ((position.getY()+1 < this.getHeight())) {
            Position pos = new Position(position.getX(), position.getY()+1);
            aroundTiles.add(pos);
        }
        if ((position.getX()-1 >= 0)) {
            Position pos = new Position(position.getX()-1, position.getY());
            aroundTiles.add(pos);
        }
        if ((position.getY()-1 >= 0)) {
            Position pos = new Position(position.getX(), position.getY()-1);
            aroundTiles.add(pos);
        }
        return aroundTiles;
        
    }

    /**
    * To choose a random position next to a tile that is surrounded by ocean tiles 
    * @param positions the list with the ocean tiles positions around
    * @return the position of a random tile in the list
    */
    public Position randomPositionAroundATile(List<Position> positions){
        int value = alea.nextInt(positions.size());
        return positions.get(value);
    }

    /**
    * To init a board with at least 2/3 of Ocean tiles.
    * The board is generated randomly.
    */
    public void initBoard(){      
        
        for(int i = 0; i < this.getWidth(); i ++){
        	
            for(int j = 0; j < this.getHeight(); j ++){
            	
            	Position pos = new Position(i, j);
                this.theTiles[i][j] = new Ocean(pos);
            }
        }

        int maxWalkingTiles = this.getSize()/3;
        int i = 0;
        while (i < maxWalkingTiles){
            Position position = this.randomTilePosition();
            this.theTiles[position.getX()][position.getY()] = this.randomTile(position);
            i ++;
            
            if (this.isAlone(position)){
            	List<Position> surrounding = this.getTileAround(position);
                Position pos = this.randomPositionAroundATile(surrounding);
                this.theTiles[pos.getX()][pos.getY()] = this.randomTile(pos);
                i ++;
            }
        }
    }
    
    
    /**
     * To display the board
     */
    public void displayBoard() {
    	String str = "  ";
		for(int i = 0; i < this.getHeight(); i ++){
			String str2 = "";
			for(int j = 0; j < this.getWidth(); j ++){
		          str2 +=" "+this.getTile(new Position(j, i)).getDisplayBoard();
		     }
			str += " "+i;
			System.out.println(i+"|"+str2);
		}
		System.out.println(str);
    }

}
