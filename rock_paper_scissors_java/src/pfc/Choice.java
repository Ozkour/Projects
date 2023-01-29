package pfc;

/**
 * Represents the enumeration of the different choices in chi fou mi game
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */

public enum Choice{
    ROCK,PAPER,SCISSORS;

    /** return a number corresponding to the comparison of 2 choices
     * @return 0 if choices are the same, 1 if we are winning and -1 if we are losing
     */
    public int compare(Choice c){
        if (this == c){
            return 0;
        }
        else if ((this == Choice.ROCK && c == Choice.PAPER)||(this == Choice.PAPER && c == Choice.SCISSORS) || (this == Choice.SCISSORS && c == Choice.ROCK)){
            return -1;
        }
        else{
            return 1;
        }
    }
}