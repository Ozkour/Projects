package game;

import java.util.ArrayList;
import java.util.List;

import game.tile.TileExceptOcean;
import game.util.NotEnoughGoldException;
import game.util.NotEnoughResourcesException;

/**
 * A person that is going to play at one of the games.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 12/02/2021
 */

public class Player {

    protected String name; // The name of the player
    protected int gold; // The gold of the player
    protected List<Resources> theResources; // The list of resources of the player
    protected List<TileExceptOcean> territories; // The list of the territories that the player has
    protected Strategy strategy; // the strategy of the player 
    
    
    /**
     * The constructor of Player
     * @param name the name of the player
     * @param strategy the strategy of the player 
     */
	  public Player(String name, Strategy strategy){
	        this.name = name;
	        this.gold = 0;
	        this.theResources = new ArrayList<>();
	        this.territories = new ArrayList<>();
	        this.strategy = strategy;
	  }
  
    /**
     * To get the name of the player
     * @return the name of the player
     */
	  public String getName(){
	      return this.name;
	  }

    /**
     * To get the gold of the player
     * @return the gold of the player
     */
	  public int getGold(){
	      return this.gold;
	  }

    /**
     * To get the resources of the player
     * @return the resources of the player
     */
    public List<Resources> getResources(){
      return this.theResources;
    }

    /**
     * To get the territories of the player
     * @return the territories of the player
     */
    public List<TileExceptOcean> getTerritories(){
      return this.territories;

    }
    
    /**
     * to get the strategy of the player 
     * @return the strategy of the Player
     */
    public Strategy getStrategy() {
    	return this.strategy;
    }
    
    /**
     * To add gold to the player
     * @param nbGold the gold we want to add to the player
     */
    public void addGold(int nbGold){
        this.gold+=nbGold;
    }

    /**
     * To remove gold to the player
     * @param nbGold the gold we want to remove to the player
     * @throws NotEnoughGoldException if the player doesn't have enough gold to buy something
     */
    public void removeGold(int nbGold) throws NotEnoughGoldException{
        if(this.gold-nbGold<0){
        	throw new NotEnoughGoldException("You don't have enough gold :'( ");
        }
        else {
            this.gold-=nbGold;
        }
    }

    /**
     * To add a territory to the list of territories of the player
     * @param tile the territory we want to add to the player
     */
    public void addTerritory(TileExceptOcean tile){
        this.territories.add(tile);
    }

    /**
     * To remove a territory of the list of territories of the player
     * @param tile the territory we want to remove to the player
     */
    public void removeTerritory(TileExceptOcean tile){
        this.territories.remove(tile);
    }

    /**
     * To add some resources to the player
     * @param resource the resource we want to add
     */
    public void addResources(Resources resource){
    	this.getResources().add(resource);
    }

    /**
     * To remove resource(s) to the player
     * @param resource the resource we want to remove
     * @throws NotEnoughResourcesException if the player does not have enough of this resource
     */

    public void removeResources(Resources resource) throws NotEnoughResourcesException {
    	
    	int index = 0;
    	
    	if (this.getResources().isEmpty()) {
    		throw new NotEnoughResourcesException();
    	}
    	
    	while (!resource.equals(this.getResources().get(index))  && index == this.getResources().size()) {
    		index ++;
    	}
    	
    	if (!resource.equals(this.getResources().get(index))) {
    		throw new NotEnoughResourcesException();
    	}
    	
    	this.getResources().remove(index);

    }

    /**
     * To check if an object is equals to a player
     * @param o an other object that we want to test
     * @return true if the player and the object are equals and false otherwise
     */
    public boolean equals(Object o){
        if (o instanceof Player){
            Player other = (Player) o;
            return this.name.equals(other.name);
        }
        else{
            return false;
        }
    }
    
    /**
     * To get a string representation of the player
     * @return String the representation of the player
     */
    public String toString(){
        return "The player " + this.name + " has "+ this.gold + " gold.";
    }
    




}
