
package game;

import java.io.IOException;

import game.tile.TileExceptOcean;
import game.util.Position;


/**
 * When a person play a game, he can use different strategies. 
 * Depending on his strategy, he will choose the action he's gonna play.
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 31/03/2021
 */

public abstract class Strategy {
	
	protected String name;
	private Game game; // the game where the strategy can be used 
	
	/**
	 * the constructor of a strategy
	 * @param game the game the player plays
	 */
	protected Strategy(Game game) {
		this.game = game;
		this.name = "Strategy";
	}
	
	/**
	 * to get the name of the strategy
	 * @return the name of the strategy
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * To get the game
	 * @return the game
	 */
	public Game getGame() {
		return this.game;
	}
	
	/**
	 * To choose an action 
	 * @throws IOException for the method choice()
	 * @return the chosen action 
	 */
	public Action chooseTheAction() throws IOException {
		this.getText();
		int choice = this.choice(game.getActions().size());
        return game.getActions().get(choice);
	}
	
	/**
	 * To display the different Action of the Game
	 */
	public void getText() {
		System.out.println("\nWhat do you want to do ?");
		int cpt = 0;
		for(Action action : game.getActions() ) {
			System.out.println("\n " + cpt + " - " + action.getName());
			cpt ++;
		}
		System.out.println("\n");
	}
	
	/**
	 * To choose the action depending on the strategy choosen
	 * @param nbChoices of possible actions
	 * @return the number of the action chosen 
	 * @throws IOException if the input isn't correct
	 */
	public abstract int choice(int nbChoices) throws IOException;
	

	/**
	 * To get the horizontal coordinate 
	 * @return the horizontal coordinate
	 * @throws IOException if the input isn't correct
	 */
	protected abstract int getX() throws IOException;

	/**
	 * used to get the vertical coordinate 
	 * @return the vertical coordinate
	 * @throws IOException if the input isn't correct
	 */
	protected abstract int getY() throws IOException;
	
	
	/**
	 * To get a position to deploy a npc
	 * @return the position that we want
	 * @throws IOException if the input isn't correct
	 */
	public TileExceptOcean getCoord() throws IOException {
		int x = this.getX();
		int y = this.getY();
		Position pos = new Position(x, y);
		if (this.getGame().getBoard().getTile(pos).isWalking()) {
			return (TileExceptOcean) this.getGame().getBoard().getTile(pos);
		}
		else {
			System.out.println("This tile is an ocean, please choose another tile.");
			return this.getCoord();
		}
	}

	/**
	 * To get the size of a new npc deployed
	 * @return the size of this npc
	 * @throws IOException if the input is not correct 
	 */
	public abstract int getSizeOfNpc() throws IOException;
	
	
	/**
     * to know if the strategy and an object are equals
     * @param o the other object
     * @return true if they are equals and false otherwise
     */
    public boolean equals(Object o) {
    	if (o instanceof Strategy) {
    		Strategy other = (Strategy) o;
            return other.getName().equals(this.getName());
    	}
    	return false;
    }
	
	
}