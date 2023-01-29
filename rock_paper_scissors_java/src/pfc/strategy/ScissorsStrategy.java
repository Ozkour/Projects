package pfc.strategy;

import pfc.*;

/**
 * Represents a strategy when the choice is SCISSORS
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */
public class ScissorsStrategy implements Strategy{

    /** returns the choice SCISSORS
     * @return the choice SCISSORS everytime
     */
    public Choice choose(){
        return Choice.SCISSORS;
    }
}