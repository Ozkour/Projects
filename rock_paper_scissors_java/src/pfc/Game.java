package pfc;

/**
 * Represents a game with two players
 *
 * @author Nicolas Kerman & Mina Crapez G6
 * @version 19/11/2020
 */

public class Game{
    private Player player1;
    private Player player2;

    public static final int WINNER_POINTS = 2;
    public static final int EQUAL_POINT = 1;

    /** Creates a game
     * @param p1 the first player
     * @param p2 the second player
     */
    public Game(Player p1, Player p2){
        this.player1 = p1;
        this.player2 = p2;
    }

    /** Play one round of Chi Fou Mi */
    public void playOneRound(){
        Choice c1 = this.player1.choose();
        Choice c2 = this.player2.choose();
        System.out.println(this.player1.getName()+" plays "+ c1 +". "+this.player2.getName()+" plays "+c2+"\n");
        int res =  c1.compare(c2) ;
        this.givePoints(res);
        System.out.println("The score is now "+this.player1.getName()+" = "+this.player1.getPoints()+" points - "+this.player2.getName()+" = "+this.player2.getPoints()+" points.\n");
    }

    /** Play nbRounds rounds of Chi Fou Mi and returns the winner
     * @param nbRounds
     * @return the winner of the game
     */
    public Player play(int nbRounds){
        for (int i=0;i<nbRounds;i++){
            this.playOneRound();
        }
        return this.getWinner();
    }

    /** Give points according to res. 
     * @param res -1 0 or 1 which determinate the winner of the round.
     */
    public void givePoints(int res){
        if (res>0){
            this.player1.addPoints(WINNER_POINTS);
        }
        else if(res<0){
            this.player2.addPoints(WINNER_POINTS);
        }
        else{
            this.player1.addPoints(EQUAL_POINT);
            this.player2.addPoints(EQUAL_POINT);
        }
    }

    /** returns the winner of the game according to the number of points of each player
     * @return the winner of the game according to the number of points of each player
     */
    public Player getWinner(){
        if (this.player1.getPoints() > this.player2.getPoints()){
            return this.player1;
        }
        else if (this.player1.getPoints() < this.player2.getPoints()){
            return this.player2;
        }
        else {
            return Player.NOBODY;
        }
    }

    /** returns the first player
     * @return the first player
     */
    public Player getPlayer1(){
        return this.player1;
    }

    /** returns the second player
     * @return the second player
     */
    public Player getPlayer2(){
        return this.player2;
    }

    /** returns a string representation of the game
     * @return a string representation of the game
     */
    public String toString(){
        return "The player 1 is "+this.player1.getName()+" and the player 2 is "+this.player2.getName();
    }
}