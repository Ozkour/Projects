package pfc.strategy;

import pfc.*;

/**
 * Represents a strategy when the choice is ROCK
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */
public class RockStrategy implements Strategy{

    /** returns the choice ROCK
     * @return the choice ROCK everytime
     */
    public Choice choose(){
        return Choice.ROCK;
    }
}