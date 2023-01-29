package game.util;


/**
 * The position of a tile on the board.
 * 
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 12/03/2021
 */
public class Position {
	
	private int x; // The horizontal coordinate
	private int y; // The vertical coordinate
	
	/**
	 * The constructor
	 * @param x the horizontal coordinate
	 * @param y the vertical coordinate
	 */
	public Position(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * To get the horizontal coordinate
	 * @return the horizontal coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * To get the vertical coordinate
	 * @return the vertical coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * to set the horizontal coordinate
	 * @param x the new horizontal coordinate 
	 */
	public void setX(int x) {
		this.x = x;
	}

	 /**
	  * To set the vertical coordinate
	  * @param y the new vertical coordinate
	  */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * To know if a position is equals to an other object
	 * @param other the other object
	 * @return true if the 2 positions are equal, false otherwise
	 */
	public boolean equals(Object other) {
		if(other instanceof Position) {
			Position p = (Position) other;
			return (this.x == p.getX()) && (this.y == p.getY());
		}
		return false;
	}
	
	/**
	 * A sentence to describe the position
	 * @return a sentence to describe the position
	 */
	public String toString() {
		return "(" + this.getX() + " / " + this.getY() + ")";
	}
	
}