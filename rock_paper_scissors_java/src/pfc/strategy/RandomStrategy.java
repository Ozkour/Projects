package pfc.strategy;

import java.util.Random;
import pfc.*;

/**
 * Represents a strategy when the choice is random
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */


public class RandomStrategy implements Strategy{

    /** returns the choice when the strategy is random
     * @return a random choice between rock, paper or scissors
     */
    private static final Random alea=new Random();

    public Choice choose(){
        int value= alea.nextInt(3);
        return Choice.values()[value];
    }
}