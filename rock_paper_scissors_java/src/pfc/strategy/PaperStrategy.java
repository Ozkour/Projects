package pfc.strategy;

import pfc.*;

/**
 * Represents a strategy when the choice is PAPER
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */
public class PaperStrategy implements Strategy{

    /** returns the choice PAPER
     * @return the choice PAPER everytime
     */
    public Choice choose(){
        return Choice.PAPER;
    }
}