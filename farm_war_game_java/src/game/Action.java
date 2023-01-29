package game;


/**
 * An action that the player has to choose when it is his turn to play.
 * He has the choice between a certain number of actions depending on the game he plays.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public abstract class Action {
	
	protected String name; // the name of the action
	
	/**
	 * the constructor
	 */
	protected Action() {
		this.name = "Action";
	}
	
	/**
	 * to get the name of the action
	 * @return the name of the action
	 */
	public String getName() {
		return this.name;
	}
    
	/**
	 * to deal the action that the player chooses
	 * @param player the player who makes the action
	 * @param game the game that the player is playing at
	 * @throws Exception because of the different methods used (example : removeResources()) 
	 */
	public abstract void dealAction(Player player, Game game) throws Exception;
	
	 /**
     * to know if the action and an object are equals
     * @param o the other object
     * @return true if they are equals and false otherwise
     */
    public boolean equals(Object o) {
    	if (o instanceof Action) {
    		Action other = (Action) o;
            return other.getName().equals(this.getName());
    	}
    	return false;
    }

}