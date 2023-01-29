package pfc.strategy;

import util.io.*;
import pfc.*;
/**
 * Represents a strategy when the player choose himself
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */


public class HumanStrategy implements Strategy{

	/** returns the choice we choose with an input
	 * @exception ArrayIndexOutOfBoundsException if our number given by the player is not between 0 and 2
     * @return the choice chose by the player
     */
    public Choice choose() throws ArrayIndexOutOfBoundsException{
	    int intLu;
        try {
			System.out.print(" Choose : Rock = 0, Paper = 1, Scissors = 2 ");
			intLu = Input.readInt();
			if (intLu < 0 || intLu >2){
				throw new ArrayIndexOutOfBoundsException("Are you stupid ? I told you to enter an integer between 0 and 2. Ok I leave");
			}
			System.out.println("valeur ok  => " + intLu);
		} catch (java.io.IOException e) {
		    intLu = 0;
			System.out.println("bad input, default value  => " + intLu);
		}
		return Choice.values()[intLu];
    }
}