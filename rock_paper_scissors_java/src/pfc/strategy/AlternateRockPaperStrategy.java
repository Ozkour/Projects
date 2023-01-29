package pfc.strategy;

import pfc.*;

/**
 * Represents a strategy alternating the choices Rock and Paper
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */
public class AlternateRockPaperStrategy implements Strategy{
	
	/** alternate the choice paper or rock according to the last choice
     * @return the choice paper or rock
     */
	boolean alternate = true ;
  	public Choice choose(){
  		if (alternate == true) {
  			alternate = false ;
  			return Choice.ROCK ;
  		} 
  		else {
  			alternate = true ;
  			return Choice.PAPER ;
  		}	
      }
      
    }