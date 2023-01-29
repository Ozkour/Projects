package goosegame;
import goosegame.cells.*;

import java.util.*; 

/**
 * Represents a goose game
 * @author Nicolas Kerman and Mina Crapez G6
 * @version 17/12/2020
 */
public class Game{

    // the list of player of the game
    protected List<Player> thePlayers;

    // the board of the game
    protected Board board;

    // the current player of the game
    private int currentPlayer;

    /** 
     * @param board the board of the game
    */
    public Game(Board board){
        this.board = board;
        this.thePlayers = new ArrayList<Player>();
        this.currentPlayer=0;
        }

    /** return the position of the current player in the list of players
     * @return the position of the current player in the list of players
     */
    public int getCurrentPlayer(){
        return this.currentPlayer;
    }

    /** return the board of the game
     * @return the board 
     */
    public Board getBoard(){
        return this.board;
    }

    /** return the list of players
     * @return the list of players 
     */
    public List<Player> getThePlayers(){
        return this.thePlayers;
    }

     /** return true or false if the player can play or not
     * @param player the player we want to know if he can play or not
     * @return true  or false 
     */
    public boolean playerCanPlay(Player player){
        return player.getCell().canPlay();
    }

     /** move a player on a cell 
     * @param player the player we want to move
     * @param cell the cell our player will go 
     */
    public void movePlayer(Player player,Cell cell) {
        Cell c = player.getCell();
        if (cell.isBusy()){
            Player other = cell.getPlayer();
            c.setPlayer(other); 
            other.setCell(c);
            player.setCell(cell);
            cell.setPlayer(player);
        } 
        else{
            c.setPlayer(null);
            player.setCell(cell);
            cell.setPlayer(player);
        }
    }

     /** add a player to the list of players
     * @param player the player we want to add to the game 
     */
    public void addPlayer(Player player){
        this.thePlayers.add(player);
        player.getCell().setPlayer(player);
    }

     /** play a game and return the winner of the game
     * @return the player of the game
     */
    public Player play(){
        while(!this.isFinished()){
            Player currentP = this.nextPlayer();
            this.playOneRound(currentP);
        }
        this.displayWinner();
        return this.thePlayers.get(this.currentPlayer);
    }

     /** display the winner of the game
     */
    public void displayWinner(){
        System.out.println("the winner is "+this.thePlayers.get(this.currentPlayer));
    } 

    
     /** return true or false if the game is finished of not
     * @return true or false if the game is finished of not
     */
    public boolean isFinished(){
        boolean res = false;
        for(int i=0;i<this.thePlayers.size();i++){
            if(thePlayers.get(i).getCell().getIndex()==this.board.getNbOfCells()){
                res=true;
            }
        }
        return res;
    }

     /** return the next player of the game
     * @return the next player of the game
     */
    public Player nextPlayer(){
        this.currentPlayer = (this.currentPlayer+1)%this.thePlayers.size();
        return this.thePlayers.get(this.currentPlayer);
    }

     /** play a round of the game
     * @param currentP the current player of the game
     */
    public void playOneRound(Player currentP){
        if(playerCanPlay(currentP)){
            System.out.println(currentP.toString()+" is playing:");
            Cell nextcell = this.nextCell(currentP);
            this.movePlayer(currentP,nextcell);
            System.out.println("And now on " +this.board.getCell(nextcell.getIndex()).toString()+"\n");
        }
        else{
            System.out.println(currentP.toString()+" can't play because of "+currentP.getCell().toString());
        }
    }

     /** return the cell on which the player go after playing
     * @param p the player who plays
     * @return  the cell on which the player go after playing
     */
    public Cell nextCell(Player p){
        int des = p.twoDiceThrow();
        Cell currentCell = p.getCell();
        System.out.println(p.toString()+" is on "+currentCell.toString()+", throws "+des);
        int currentIndex = currentCell.getIndex();
        int nextIndex = currentIndex + des;
        if (nextIndex > this.board.getNbOfCells()){
            nextIndex = this.board.getNbOfCells()-(nextIndex-this.board.getNbOfCells());
        }
        Cell nextCell = this.board.getCell(nextIndex);
        int reachedIndex = nextCell.bounce(des);
        if (reachedIndex > this.board.getNbOfCells()){  //useful if we are on a goosecell near to the end
            reachedIndex = this.board.getNbOfCells()-(reachedIndex-this.board.getNbOfCells());
        }
        return this.board.getCell(reachedIndex);
    }
}
